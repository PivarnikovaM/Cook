package m.l.cook;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
public class MysqlReceptDaoTest {
    
    public MysqlReceptDaoTest() {
    }

    @Test
    public void testDajRecepty() {
       MysqlReceptDao dao = new MysqlReceptDao();
       List<Recept> recepty = dao.dajRecepty();
       assertEquals(2, recepty.size());
    
    }
    
    @Test
    public void testVyhladajReceptyPodlaIngrediencii() {
        MysqlReceptDao dao = new MysqlReceptDao();
        String ingrediencie = "káva, voda";
        List<Recept> vyhladajReceptyPodlaIngrediencii = dao.vyhladajReceptyPodlaIngrediencii(ingrediencie);
        assertEquals(1, vyhladajReceptyPodlaIngrediencii.size());
    }
    

   
    
}
