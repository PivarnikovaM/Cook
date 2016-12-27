/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.l.cook;

import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author martinapivarnikova
 */
public class MysqlJedalnicekDaoTest {

    private JedalnicekDao jedalnicekDao;
    private ReceptDao receptDao;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        jedalnicekDao = ObjectFactory.INSTANCE.jedalnicekDao();
        receptDao = ObjectFactory.INSTANCE.receptDao();
    }

    @Test
    public void testDajJedalnicek() {
        List<Jedalnicek> jedalnicek = jedalnicekDao.dajJedalnicek();
        assertTrue(jedalnicek.size() > 0);

    }

    @Test
    public void testSaveOrUpdate() {

        int povodne = jedalnicekDao.dajJedalnicek().size();
        Recept recept = receptDao.dajRecepty().get(0);

        Jedalnicek jedalnicek = new Jedalnicek();
        jedalnicek.setDatum(LocalDate.now().plusDays(10));
        jedalnicek.setRecept(recept);

        jedalnicekDao.saveOrUpdate(jedalnicek);
        int nove = jedalnicekDao.dajJedalnicek().size();

        assertEquals(povodne + 1, nove);

        jedalnicekDao.saveOrUpdate(jedalnicek);

        assertEquals(povodne + 1, nove);

    }

    @After
    public void end() {

        jdbcTemplate.update("DELETE FROM jedalnicek WHERE datum >= CURDATE()+9");

    }

}



