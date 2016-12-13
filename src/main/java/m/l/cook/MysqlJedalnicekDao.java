package m.l.cook;

import static java.lang.String.valueOf;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import static java.lang.String.valueOf;

public class MysqlJedalnicekDao implements JedalnicekDao {

    private JdbcTemplate jdbcTemplate;

    MysqlJedalnicekDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public List<Jedalnicek> dajJedalnicek() {
        String sql = "SELECT jedalnicek.id AS jedalnicek_id, "
                + "jedalnicek.datum as jedalnicek_datum, "
                + "jedalnicek.id_recept as jedalnicek_recept, "
                + "recept.id as recept_id, "
                + "recept.nazov as recept_nazov, "
                + "recept.postup as recept_postup "
                + "FROM jedalnicek JOIN recept on recept.id = jedalnicek.id_recept;";

        return jdbcTemplate.query(sql, new JedalnicekRowMapper());
    }

    public void vymazAkJePo() {
      jdbcTemplate.update("DELETE FROM jedalnicek WHERE datum < CURDATE()");
    }
    
    
    @Override
    public void saveOrUpdate(Jedalnicek jedalnicek) {
        if (jedalnicek.getId() == null) {
            jdbcTemplate.update("INSERT IGNORE INTO Cook.jedalnicek VALUES (?,?,?)",
                    null, 
                    java.sql.Date.valueOf(jedalnicek.getDatum()), 
                    jedalnicek.getRecept().getId());
        } else {
            jdbcTemplate.update("UPDATE JEDALNICEK SET id_recept = ? WHERE id = ?",
                    jedalnicek.getRecept().getId(), 
                    jedalnicek.getId());

        }

    }

    private static class JedalnicekRowMapper implements RowMapper<Jedalnicek> {

        public JedalnicekRowMapper() {
        }

        @Override
        public Jedalnicek mapRow(ResultSet rs, int i) throws SQLException {
            Jedalnicek jedalnicek = new Jedalnicek();
            jedalnicek.setId(rs.getLong("jedalnicek_id"));
            jedalnicek.setDatum(rs.getDate("jedalnicek_datum").toLocalDate());
            
            Recept recept = new Recept();
            recept.setId(rs.getLong("recept_id"));
            recept.setNazov(rs.getString("recept_nazov"));
            recept.setPostup(rs.getString("recept_postup"));
            
            jedalnicek.setRecept(recept);
            return jedalnicek;
            
            
        }
    }

}
