package m.l.cook;

import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author asus
 */
public class NakupnyZoznamDonaskaJDialog extends javax.swing.JDialog {

    /**
     * Creates new form PizzaJDialog
     */
    public NakupnyZoznamDonaskaJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(parent);
        this.getContentPane().setBackground(new Color(149,189,110));
       
        cisloNaDonaskuLabel.setForeground(Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pizzaLabel = new javax.swing.JLabel();
        cisloNaDonaskuLabel = new javax.swing.JLabel();
        pizzaAnoButton = new javax.swing.JButton();
        pizzaNieButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pizzaLabel.setFont(new java.awt.Font("Caviar Dreams", 1, 16)); // NOI18N
        pizzaLabel.setText("<html>Váš nákupný zoznam obsahuje veľa položiek. Nechcete si radšej objednať jedlo z donášky?</html>");

        cisloNaDonaskuLabel.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        cisloNaDonaskuLabel.setForeground(new java.awt.Color(255, 255, 255));

        pizzaAnoButton.setText("Áno");
        pizzaAnoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizzaAnoButtonActionPerformed(evt);
            }
        });

        pizzaNieButton.setText("Nie");
        pizzaNieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizzaNieButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pizzaAnoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(pizzaNieButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pizzaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(cisloNaDonaskuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(pizzaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cisloNaDonaskuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pizzaAnoButton)
                    .addComponent(pizzaNieButton))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pizzaAnoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pizzaAnoButtonActionPerformed
        cisloNaDonaskuLabel.setText("Číslo na donášku: 0901 701 701");
      
    }//GEN-LAST:event_pizzaAnoButtonActionPerformed

   
    private void pizzaNieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pizzaNieButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_pizzaNieButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NakupnyZoznamDonaskaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NakupnyZoznamDonaskaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NakupnyZoznamDonaskaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NakupnyZoznamDonaskaJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NakupnyZoznamDonaskaJDialog dialog = new NakupnyZoznamDonaskaJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cisloNaDonaskuLabel;
    private javax.swing.JButton pizzaAnoButton;
    private javax.swing.JLabel pizzaLabel;
    private javax.swing.JButton pizzaNieButton;
    // End of variables declaration//GEN-END:variables
}
