package m.l.cook;


import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import m.l.cook.MysqlReceptDao;
import m.l.cook.ObjectFactory;
import m.l.cook.Recept;

public class ReceptyVyhladaneListModel extends AbstractListModel {
    
      List<Recept> recepty = new ArrayList<>();
      ReceptDao receptDao;
      

    public ReceptyVyhladaneListModel() {
        receptDao = ObjectFactory.INSTANCE.receptDao();
        
        
    }

    
    @Override
    public int getSize() {
        return recepty.size();
        }

    @Override
    public Object getElementAt(int index) {
        return recepty.get(index).getNazov();
    }

    public void vrateneRecepty(List<Recept> recepty){
        this.recepty = recepty;
    }
    
    public void aktualizovat(){
        fireContentsChanged(this, 0, getSize());
        
    }
    
    
   
    
}
