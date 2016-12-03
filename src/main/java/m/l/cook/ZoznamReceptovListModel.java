/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.l.cook;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author martinapivarnikova
 */
public class ZoznamReceptovListModel extends AbstractListModel{
    
    List<Recept> recepty;

    public ZoznamReceptovListModel() {
        recepty = ObjectFactory.INSTANCE.receptDao().dajRecepty();
    }
    
    @Override
    public int getSize() {
        return recepty.size();
    }

    @Override
    public Object getElementAt(int index) {
        return recepty.get(index).getNazov();
    }
    
    public void aktualizovat(){
        fireContentsChanged(this, 0, getSize());
    }
    


    
}
