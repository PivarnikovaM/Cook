package m.l.cook;

import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MysqlReceptDao implements ReceptDao {

    private JdbcTemplate jdbcTemplate;

    private List<Ingrediencia> listIngrediencii;

    public MysqlReceptDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public List<Recept> dajRecepty() {
        String sql = "SELECT * FROM recept;";
        BeanPropertyRowMapper<Recept> mapper = BeanPropertyRowMapper.newInstance(Recept.class);

        return jdbcTemplate.query(sql, mapper);

    }

    public void zmaz(Recept recept) {
        String sql = "DELETE FROM Cook.vztahy WHERE id_recept = ?";
        String sql2 = "DELETE FROM Cook.recept \n"
                + "WHERE Cook.recept.id NOT IN \n"
                + "     (select id_recept from vztahy);";
        jdbcTemplate.update("SET FOREIGN_KEY_CHECKS = 0");
        jdbcTemplate.update("SET SQL_SAFE_UPDATES = 0");
        jdbcTemplate.update(sql, recept.getId());
        jdbcTemplate.update(sql2);
        jdbcTemplate.update("SET FOREIGN_KEY_CHECKS = 1");
        jdbcTemplate.update("SET SQL_SAFE_UPDATES = 1");
       
    }
    
  

    @Override
    public void pridajRecept(Recept recept, String ingrediencie) {

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("nazov", recept.getNazov())
                .addValue("postup", recept.getPostup());

        Number id = new SimpleJdbcInsert(ObjectFactory.INSTANCE.getJdbcTemplate())
                .withTableName("recept")
                .usingGeneratedKeyColumns("id")
                .usingColumns("nazov", "postup")
                .executeAndReturnKey(parameters);

        recept.setId(id.longValue());

        //samostatne pridame ingrediencie do databazy
        pridajIngredienciezReceptu(ingrediencie);

        //pridavanie do vztahov
        for (Ingrediencia listIngrediencia : listIngrediencii) {
            jdbcTemplate.update("INSERT INTO cook.vztahy VALUES (?,?)", recept.getId(), listIngrediencia.getId());
        }

        recept.setIngrediencie(listIngrediencii);

    }

    private void pridajIngredienciezReceptu(String stringIngrediencie) {
        List<Ingrediencia> ingrediencie = splitIngredienciaString(stringIngrediencie);
        listIngrediencii = new ArrayList<>();
        //prechadzame cez List ingrediencii
        for (Ingrediencia ingrediencia : ingrediencie) {

            //ked sa ingrediencia nenachadza v databaze
            //String queryForObject = (String) (jdbcTemplate.queryForObject("SELECT nazov FROM cook.ingrediencia WHERE nazov = (?)", String.class, ingrediencia.getNazov()));
            if (!exists(ingrediencia)) {
                MapSqlParameterSource parameters = new MapSqlParameterSource()
                        .addValue("nazov", ingrediencia.getNazov());

                Number id = new SimpleJdbcInsert(ObjectFactory.INSTANCE.getJdbcTemplate())
                        .withTableName("ingrediencia")
                        .usingGeneratedKeyColumns("id")
                        .usingColumns("nazov")
                        .executeAndReturnKey(parameters);

                ingrediencia.setId(id.longValue());
            } else {

                //ked sa nachadza v databaze priradime stare id
                Long idzTabulky = jdbcTemplate.queryForObject("SELECT id FROM cook.ingrediencia WHERE nazov = ?", Long.class, ingrediencia.getNazov());
                ingrediencia.setId(idzTabulky);
            }
            listIngrediencii.add(ingrediencia);

        }

    }

    public List<Ingrediencia> splitIngredienciaString(String stringIngrediencie) {
        List<Ingrediencia> ingrediencie = new ArrayList<>();
        Iterable<String> split = Splitter.on(',').trimResults().split(stringIngrediencie);

        for (String s : split) {
            Ingrediencia ingrediencia = new Ingrediencia();
            ingrediencia.setNazov(s);
            ingrediencie.add(ingrediencia);

        }

        return ingrediencie;

    }

    private boolean exists(Ingrediencia ingrediencia) {
        String query = "SELECT nazov FROM cook.ingrediencia WHERE nazov = ?";
        try {
            jdbcTemplate.queryForObject(query, new Object[]{ingrediencia.getNazov()}, String.class);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public List<String> ingrediencieVRecepte(Recept recept) {
        String sql = "SELECT I.nazov FROM ingrediencia I JOIN vztahy V JOIN recept R \n"
                + "ON R.id = V.id_recept and I.id = V.id_ingrediencia \n"
                + "WHERE R.nazov = ?";
        return jdbcTemplate.queryForList(sql, String.class, recept.getNazov());
    }

    public List<Recept> vyhladajReceptyPodlaIngrediencii(String ingrediencie) {
        //splitnutie ingrediencii zo stringu
        List<Ingrediencia> vsetkyIngrediencie = splitIngredienciaString(ingrediencie);
        //do mapy si ukladame recepty a hodnoty, kolko ingrediencii ktore sme zadali sa v nich nachadza
        Map<String, Integer> vyskyty = new HashMap<>();
        //prechadzame ingrediencie a tu si ukladame veci do mapy
        for (Ingrediencia ingrediencia : vsetkyIngrediencie) {
            String sql = "SELECT R.nazov FROM recept R \n"
                    + "JOIN vztahy V JOIN ingrediencia I \n"
                    + "ON R.id = V.id_recept and I.id = V.id_ingrediencia \n"
                    + "WHERE I.nazov = ?";
            //tu nam vyhodi nazvy receptov kde sa dana ingrediencia nachadza a nasledne si to ukladame do mapy
            List<String> strings = (List<String>) jdbcTemplate.queryForList(sql, String.class, ingrediencia.getNazov());
            if (strings.size() == 0) {
                return new ArrayList<>();
            }
            for (String string : strings) {
                if (vyskyty.containsKey(string)) {
                    vyskyty.put(string, vyskyty.get(string) + 1);
                } else {
                    vyskyty.put(string, 1);
                }
            }

        }
        //najdeme maximalnu hodnotu v mape (moze sa tam nachadzat aj viac krat) a nazvy receptov z nej si ulozime do listu
        List<String> nazvyReceptov = new ArrayList<>();
        int maximalnaHodnotaVMape = (Collections.max(vyskyty.values()));
        for (Entry<String, Integer> entry : vyskyty.entrySet()) {
            if (entry.getValue() == maximalnaHodnotaVMape) {
                nazvyReceptov.add(entry.getKey());
            }
        }
        //z nazvov si vyhladame v databaze dane recepty a ulozime si ich do listu
        List<Recept> vrateneRecepty = new ArrayList<>();
        for (String string : nazvyReceptov) {
            String sql2 = "SELECT * FROM recept WHERE nazov = ?";
            BeanPropertyRowMapper<Recept> mapper = BeanPropertyRowMapper.newInstance(Recept.class);
            vrateneRecepty.addAll(jdbcTemplate.query(sql2, mapper, string));

        }

        return vrateneRecepty;

    }

}
