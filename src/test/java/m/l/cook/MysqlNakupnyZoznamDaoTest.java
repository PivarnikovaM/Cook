package m.l.cook;

import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlNakupnyZoznamDaoTest {
    
    private NakupnyZoznamDao nakupnyZoznamDao;
    private IngredienciaDao ingredienciaDao;
    private JdbcTemplate jdbcTemplate;
    private NakupnyZoznam nakupnyZoznam;
   
    @Before    
    public void setUp() {
        nakupnyZoznamDao = ObjectFactory.INSTANCE.nakupnyZoznamDao();
        ingredienciaDao = ObjectFactory.INSTANCE.ingredienciaDao();
        
        nakupnyZoznam = new NakupnyZoznam();
        
        Ingrediencia ingrediencia = ingredienciaDao.dajIngrediencie().get(0);
        nakupnyZoznam.setPolozka(ingrediencia);
       
       
    }

    @Test
    public void testDajNakupnyZoznam() {
        List<NakupnyZoznam> nakupnyZoznam = nakupnyZoznamDao.dajNakupnyZoznam();
        assertTrue(nakupnyZoznam.size() > 0);
        
    }

    @Test
    public void testPridaj() {
        int povodnaVelkost = nakupnyZoznamDao.dajNakupnyZoznam().size();
       
        nakupnyZoznamDao.pridaj(nakupnyZoznam);
        
        int novaVelkost = nakupnyZoznamDao.dajNakupnyZoznam().size();
        assertEquals(povodnaVelkost+1, novaVelkost);
        
      
    }

    @Test
    public void testVymaz() {
        
        
        
    }
    
    @After
    public void end() {
//asi musime upravit metodu vymaz aby sme mohli v teste mazat normalne (lebo napr. vymazeme aj existujuci zaznam v NZ.
// nakupnyZoznam.getPolozka().getId()); je null neviem preco    
jdbcTemplate.update("DELETE FROM nakupnyzoznam WHERE id_ingrediencia = ?", 
                nakupnyZoznam.getPolozka().getId());

    }
    
}
