/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.l.cook;

import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author martinapivarnikova
 */
public class JedalnicekUpravaJDialog extends javax.swing.JDialog {

    private JedalnicekReceptyComboBoxModel receptyComboBoxModel;
    private Jedalnicek jedalnicek;
    private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    private JedalnicekDao jedalnicekDao = ObjectFactory.INSTANCE.jedalnicekDao();

    /**
     * Creates new form UpravaJedalnickaJDialog
     */
    public JedalnicekUpravaJDialog(Jedalnicek jedalnicek, java.awt.Frame parent) {

        super(parent, true);
        this.jedalnicek = jedalnicek;
        receptyComboBoxModel = new JedalnicekReceptyComboBoxModel();
        this.getContentPane().setBackground(new Color(149, 189, 110));
        this.setLocationRelativeTo(parent);
        initComponents();
        receptyComboBoxModel.setSelectedItem(jedalnicek);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datumLabel = new javax.swing.JLabel();
        receptyComboBox = new javax.swing.JComboBox<>();
        ulozButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        datumLabel.setFont(new java.awt.Font("Caviar Dreams", 1, 24)); // NOI18N
        datumLabel.setText(formatter.format(jedalnicek.getDatum()));

        receptyComboBox.setFont(new java.awt.Font("Caviar Dreams", 1, 13)); // NOI18N
        receptyComboBox.setModel(receptyComboBoxModel);

        ulozButton.setFont(new java.awt.Font("Caviar Dreams", 1, 13)); // NOI18N
        ulozButton.setText("Uložiť");
        ulozButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulozButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(datumLabel)
                .addContainerGap(299, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(receptyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ulozButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(datumLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(receptyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ulozButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ulozButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulozButtonActionPerformed
        jedalnicek.setRecept((Recept) receptyComboBox.getSelectedItem());

        jedalnicekDao.saveOrUpdate(jedalnicek);

        //zatvor okno
        dispose();
    }//GEN-LAST:event_ulozButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel datumLabel;
    private javax.swing.JComboBox<Recept> receptyComboBox;
    private javax.swing.JButton ulozButton;
    // End of variables declaration//GEN-END:variables
}
