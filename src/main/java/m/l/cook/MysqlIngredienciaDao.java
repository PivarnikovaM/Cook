package m.l.cook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class MysqlIngredienciaDao implements IngredienciaDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlIngredienciaDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public List<Ingrediencia> dajIngrediencie() {
        String sql = "SELECT * FROM Cook.ingrediencia";
       // BeanPropertyRowMapper<Ingrediencia> mapper = BeanPropertyRowMapper.newInstance(Ingrediencia.class);

        return jdbcTemplate.query(sql, new IngredienciaRowMapper());

    }

    @Override
    public void pridajIngrediencie(Ingrediencia ingrediencia) {

        jdbcTemplate.update("INSERT IGNORE INTO Cook.ingrediencia VALUES (?,?)", null, ingrediencia.getNazov());

    }

    private static class IngredienciaRowMapper implements RowMapper<Ingrediencia> {

        @Override
        public Ingrediencia mapRow(ResultSet rs, int i) throws SQLException {
            Ingrediencia ingrediencia = new Ingrediencia();
            ingrediencia.setId(rs.getLong("id"));
            ingrediencia.setNazov(rs.getString("nazov"));
            
            return ingrediencia;
        }
    }

}
