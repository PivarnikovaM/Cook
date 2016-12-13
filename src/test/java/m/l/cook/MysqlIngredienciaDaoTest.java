package m.l.cook;

import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlIngredienciaDaoTest {

    private IngredienciaDao ingredienciaDao;
    private Ingrediencia ingrediencia;
    private JdbcTemplate jdbcTemplate;

    @Before 
    public void setUp() {
        ingredienciaDao =  ObjectFactory.INSTANCE.ingredienciaDao();
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        
        
        this.ingrediencia = new Ingrediencia();
        this.ingrediencia.setNazov("nejakaIngrediencia");
    }

    @Test
    public void testDajIngrediencie() {
        List<Ingrediencia> ingrediencie = ingredienciaDao.dajIngrediencie();
        assertTrue(ingrediencie.size() > 0);
    }

    @Test
    public void testPridajIngrediencie() {
        
        int povodne = ingredienciaDao.dajIngrediencie().size();
        
        ingredienciaDao.pridajIngrediencie(this.ingrediencia);
        
        int nove = ingredienciaDao.dajIngrediencie().size();
        
        assertEquals(povodne+1, nove);
    }

     @After
    public void end(){
        jdbcTemplate.update("DELETE FROM ingrediencia WHERE nazov = ?",ingrediencia.getNazov());
                
        
    }

}
