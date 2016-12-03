package m.l.cook;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class MysqlIngredienciaDaoTest {

    public MysqlIngredienciaDaoTest() {
    }

    @Test
    public void testDajIngrediencie() {
        MysqlIngredienciaDao dao = new MysqlIngredienciaDao(ObjectFactory.INSTANCE.getJdbcTemplate());
        List<Ingrediencia> ingrediencie = dao.dajIngrediencie();
        assertEquals(5, ingrediencie.size());

    }
    
    

}
