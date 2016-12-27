package m.l.cook;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlReceptDaoTest {

    private JdbcTemplate jdbcTemplate;
    private ReceptDao receptDao;
    private Recept recept;
    private String ingrediencie;
    private List<String> ingrediencieVRecepte;

    @Before
    public void setUp() {
        receptDao = ObjectFactory.INSTANCE.receptDao();
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
     
        recept = new Recept();
        ingrediencie = "kaviár";

    }

    @Test
    public void testDajRecepty() {
        List<Recept> recepty = receptDao.dajRecepty();
        assertTrue(recepty.size() > 0);

    }

    @Test
    public void testZmaz() {
        int povodnaVelkost = receptDao.dajRecepty().size();
        receptDao.pridajRecept(recept, ingrediencie);
        receptDao.zmaz(recept);
        int novaVelkost = receptDao.dajRecepty().size();
        assertEquals(povodnaVelkost, novaVelkost);
    }

    

    @Test
    public void testIngrediencieVRecepte() {
        recept = new Recept();
     
        ingrediencieVRecepte = receptDao.ingrediencieVRecepte(recept);
        assertTrue(ingrediencieVRecepte.size() >= 0);
    }

    @Test
    public void testVyhladajReceptyPodlaIngrediencii() {
        String ingrediencie = "stolík";
        List<Recept> vyhladajReceptyPodlaIngrediencii = receptDao.vyhladajReceptyPodlaIngrediencii(ingrediencie);
        assertEquals(0, vyhladajReceptyPodlaIngrediencii.size());

    }
    
    @Test
    public void testSplitIngredienciaString(){
        String string = "caj, kava";
        List<Ingrediencia> splitIngredienciaString = receptDao.splitIngredienciaString(string);
        assertEquals(2, splitIngredienciaString.size());
    }
    
    @After
    public void end() {
        receptDao.zmaz(recept);
        
        
    }

}

