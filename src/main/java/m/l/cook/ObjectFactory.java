package m.l.cook;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum ObjectFactory {
    INSTANCE;
    private JdbcTemplate jdbcTemplate;

    private ReceptDao receptDao;

    private IngredienciaDao ingredienciaDao;

    private NakupnyZoznamDao nakupnyZoznamDao;
    
    private JedalnicekDao jedalnicekDao;

    public JdbcTemplate getJdbcTemplate() {

        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/cook?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
            dataSource.setUser("cook");
            dataSource.setPassword("cook");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;

    }

    public ReceptDao receptDao() {
        if (this.receptDao == null) {
            this.receptDao = new MysqlReceptDao();
        }
        return receptDao;
    }
    
    public IngredienciaDao ingredienciaDao() {
        if (this.ingredienciaDao == null) {
            this.ingredienciaDao = new MysqlIngredienciaDao();
        }
        return ingredienciaDao;
    }
    
    public NakupnyZoznamDao nakupnyZoznamDao(){
        if (this.nakupnyZoznamDao == null){
            this.nakupnyZoznamDao = new MysqlNakupnyZoznamDao(jdbcTemplate);
        }
        return nakupnyZoznamDao;
    }
    
    public JedalnicekDao jedalnicekDao(){
        if (this.jedalnicekDao == null) {
            this.jedalnicekDao = new MysqlJedalnicekDao();
        }
        return jedalnicekDao; 
    }

}
