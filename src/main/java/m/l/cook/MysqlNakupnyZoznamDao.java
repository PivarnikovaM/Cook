package m.l.cook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class MysqlNakupnyZoznamDao implements NakupnyZoznamDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlNakupnyZoznamDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<NakupnyZoznam> dajNakupnyZoznam() {

        String sql = ("SELECT nakupnyzoznam.id AS nakupnyzoznam_id,\n" +
            "        nakupnyzoznam.id_ingrediencia as nakupnyzoznam_ingrediencia,\n" +
            "        nakupnyzoznam.stav as nakupnyzoznam_stav,\n" +
            "        ingrediencia.id as ingrediencia_id,\n" +
            "        ingrediencia.nazov as ingrediencia_nazov\n" +
            "        FROM nakupnyzoznam \n" +
            "        JOIN ingrediencia on ingrediencia.id = nakupnyzoznam.id_ingrediencia;");
      
        return jdbcTemplate.query(sql, new NakupnyZoznamRowMapper());

    }

    @Override
    public void pridaj(NakupnyZoznam nakupnyZoznam) {
        jdbcTemplate.update("INSERT INTO nakupnyzoznam VALUES (?,?,?)",
               null, nakupnyZoznam.getPolozka().getNazov(), nakupnyZoznam.isStav());

    }

    private static class NakupnyZoznamRowMapper implements RowMapper<NakupnyZoznam> {

        public NakupnyZoznamRowMapper() {
        }

        @Override
        public NakupnyZoznam mapRow(ResultSet rs, int i) throws SQLException {
            NakupnyZoznam nakupnyZoznam = new NakupnyZoznam();
            nakupnyZoznam.setId(rs.getLong("nakupnyzoznam_id"));
            nakupnyZoznam.setStav(rs.getBoolean("nakupnyzoznam_stav"));
            
            Ingrediencia ingrediencia = new Ingrediencia();
            ingrediencia.setId(rs.getLong("ingrediencia_id"));
            ingrediencia.setNazov(rs.getString("ingrediencia_nazov"));
            
            nakupnyZoznam.setPolozka(ingrediencia);
            
            return nakupnyZoznam;
            
        
        }
    }

}
