package m.l.cook;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class NakupnyZoznamIngrediencieComboBoxModel extends DefaultComboBoxModel<Ingrediencia>{
    
    private IngredienciaDao ingredienciaDao = ObjectFactory.INSTANCE.ingredienciaDao();
    
    List<Ingrediencia> ingrediencie;

    public NakupnyZoznamIngrediencieComboBoxModel() {
        refresh();
    }
    
    public void refresh(){
        removeAllElements();
        
        ingrediencie = ingredienciaDao.dajIngrediencie();
        
       
        for (Ingrediencia ingrediencia : ingrediencie) {
            addElement(ingrediencia);
            
        }
    }

  

   
    
    
    


    
}
