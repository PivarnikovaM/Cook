package m.l.cook;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class JedalnicekReceptyComboBoxModel extends DefaultComboBoxModel<Recept> {

    private ReceptDao receptDao = ObjectFactory.INSTANCE.receptDao();

    List<Recept> recepty;

    public JedalnicekReceptyComboBoxModel() {
        refresh();
    }

    private void refresh() {
        removeAllElements();

        recepty = receptDao.dajRecepty();

        for (Recept recept : recepty) {
            addElement(recept);
            
        }
    }

}
