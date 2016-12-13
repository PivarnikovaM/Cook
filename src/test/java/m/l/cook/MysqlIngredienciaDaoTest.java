package m.l.cook;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MysqlIngredienciaDaoTest {

    private IngredienciaDao ingredienciaDao;

    @Before 
    public void setUp() {
        ingredienciaDao =  ObjectFactory.INSTANCE.ingredienciaDao();
    }

    @Test
    public void testDajIngrediencie() {
        List<Ingrediencia> ingrediencie = ingredienciaDao.dajIngrediencie();
        assertNotNull(ingrediencie.size());
    }

    @Test
    public void testPridajIngrediencie() {
        Ingrediencia ingrediencia = new Ingrediencia();
        ingrediencia.setNazov("chlieb");
        List<Ingrediencia> ingrediencie = ingredienciaDao.dajIngrediencie();
        ingredienciaDao.pridajIngrediencie(ingrediencia);
        
        assertEquals(ingredienciaDao.dajIngrediencie().size(), ingrediencie.size()+1);
    }

    

}
