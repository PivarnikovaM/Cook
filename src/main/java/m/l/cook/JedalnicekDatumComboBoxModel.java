package m.l.cook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class JedalnicekDatumComboBoxModel extends DefaultComboBoxModel<String> {

    List<LocalDate> datumy = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

    public JedalnicekDatumComboBoxModel() {
        refresh();
    }

    private void refresh() {
        removeAllElements();

        for (int i = 0; i < 7; i++) {
            datumy.add(LocalDate.now().plusDays(i));

        }

        for (LocalDate localDate : datumy) {
            addElement(formatter.format(localDate));

        }
    }

}
