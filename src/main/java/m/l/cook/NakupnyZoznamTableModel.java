package m.l.cook;

import javax.swing.table.AbstractTableModel;

public class NakupnyZoznamTableModel extends AbstractTableModel {

    private NakupnyZoznamDao nakupnyZoznamDao = ObjectFactory.INSTANCE.nakupnyZoznamDao();

    private static final String[] NAZVY_STLPCOV = {"Položky", "Stav"};

    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    @Override
    public int getRowCount() {
        return nakupnyZoznamDao.dajNakupnyZoznam().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NakupnyZoznam nakupnyZoznam = nakupnyZoznamDao.dajNakupnyZoznam().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return nakupnyZoznam.getPolozka().getNazov();
            case 1:
                return nakupnyZoznam.isStav();
            default:
                return "???";
        }

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return Boolean.class;
        }

        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    void aktualizovat() {
        fireTableDataChanged();
    }
}
