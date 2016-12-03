package m.l.cook;


import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;


public class ZvolenyReceptIngrediencieListModel extends AbstractListModel {

    List<String> ingrediencie = new ArrayList<>();
    IngredienciaDao ingredienciaDao;
    ReceptDao receptDao;
    

    public ZvolenyReceptIngrediencieListModel() {
        ingredienciaDao = ObjectFactory.INSTANCE.ingredienciaDao();
        receptDao = ObjectFactory.INSTANCE.receptDao();
        ingredienciaDao.dajIngrediencie();
    }
    
    
    @Override
    public int getSize() {
        return ingrediencie.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ingrediencie.get(index);
    }
    
    public void nastavIngrediencievDanomRecepte(Recept recept){
        ingrediencie = receptDao.ingrediencieVRecepte(recept);
        
    }
    
    
}
