package m.l.cook;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

public class JedalnicekTableModel extends AbstractTableModel {

    private JedalnicekDao jedalnicekDao = ObjectFactory.INSTANCE.jedalnicekDao();

    private static final String[] NAZVY_STLPCOV = {"Dátum", "Recept"};

    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    
     DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

    @Override
    public int getRowCount() {
        return jedalnicekDao.dajJedalnicek().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Collections.sort(jedalnicekDao.dajJedalnicek(), new JedalnicekComparator());
        Jedalnicek jedalnicek = jedalnicekDao.dajJedalnicek().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return formatter.format(jedalnicek.getDatum());
            case 1:
                return jedalnicek.getRecept().getNazov();
            default:
                return "???";
        }

    }

    public Jedalnicek getObjectAt(int rowIndex){
        return jedalnicekDao.dajJedalnicek().get(rowIndex);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    void aktualizovat() {
        //Collections.sort(jedalnicekDao.dajJedalnicek(), new JedalnicekComparator());
        fireTableDataChanged();
    }

    private static class JedalnicekComparator implements Comparator<Jedalnicek>{

        @Override
        public int compare(Jedalnicek o1, Jedalnicek o2) {
            return o1.getDatum().compareTo(o2.getDatum());
        }
    }

}
