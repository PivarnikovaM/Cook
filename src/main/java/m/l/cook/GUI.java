/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.l.cook;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author martinapivarnikova
 */
public class GUI extends javax.swing.JFrame {

    ReceptyJpanel receptyPanel;
    NakupnyZoznamJPanel nakupnyZoznamPanel;
    JedalnicekJPanel jedalnicekPanel;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();

        receptyButton.setOpaque(false);
        receptyButton.setContentAreaFilled(false);
        receptyButton.setBorderPainted(false);

        nakupnyZoznamButton.setOpaque(false);
        nakupnyZoznamButton.setContentAreaFilled(false);
        nakupnyZoznamButton.setBorderPainted(false);

        pridavanieReceptovButton.setOpaque(false);
        pridavanieReceptovButton.setContentAreaFilled(false);
        pridavanieReceptovButton.setBorderPainted(false);

        jedalnicekButton.setOpaque(false);
        jedalnicekButton.setContentAreaFilled(false);
        jedalnicekButton.setBorderPainted(false);

        // jTextField1.setBackground(new Color(255,255,255,95));
        receptyJPanel.setVisible(false);
        receptyJPanel.setOpaque(true);

        receptyPanel = new ReceptyJpanel();
        nakupnyZoznamPanel = new NakupnyZoznamJPanel();
        jedalnicekPanel = new JedalnicekJPanel();

    }

    /*Runnable Refresh = new Runnable() {
        public void run() {
            receptyPanel = new ReceptyJpanel();
            nakupnyZoznamPanel = new NakupnyZoznamJPanel();
            jedalnicekPanel = new JedalnicekJPanel();

            receptyJPanel.removeAll();
            receptyJPanel.setVisible(false);
            receptyJPanel.add(receptyPanel);

            receptyJPanel.setVisible(true);
        }
    };*/

    public void aktualizujVsetko() {

        receptyPanel = new ReceptyJpanel();
        nakupnyZoznamPanel = new NakupnyZoznamJPanel();
        jedalnicekPanel = new JedalnicekJPanel();

        receptyJPanel.removeAll();
        receptyJPanel.setVisible(false);
        receptyJPanel.add(receptyPanel);

        receptyJPanel.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        receptyJPanel = new javax.swing.JPanel();
        receptyButton = new javax.swing.JButton();
        cookLabel = new javax.swing.JLabel();
        nakupnyZoznamButton = new javax.swing.JButton();
        pridavanieReceptovButton = new javax.swing.JButton();
        jedalnicekButton = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 667));
        setMinimumSize(new java.awt.Dimension(1000, 667));
        setPreferredSize(new java.awt.Dimension(1000, 667));
        getContentPane().setLayout(null);

        receptyJPanel.setBackground(new java.awt.Color(149, 189, 110));
        getContentPane().add(receptyJPanel);
        receptyJPanel.setBounds(360, 70, 620, 520);

        receptyButton.setBackground(new java.awt.Color(255, 255, 255));
        receptyButton.setFont(new java.awt.Font("Caviar Dreams", 1, 30)); // NOI18N
        receptyButton.setForeground(new java.awt.Color(132, 160, 104));
        receptyButton.setText("recepty");
        receptyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receptyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(receptyButton);
        receptyButton.setBounds(30, 190, 140, 90);

        cookLabel.setFont(new java.awt.Font("Universe", 1, 70)); // NOI18N
        cookLabel.setForeground(new java.awt.Color(132, 160, 104));
        cookLabel.setText("COOK");
        cookLabel.setIconTextGap(0);
        getContentPane().add(cookLabel);
        cookLabel.setBounds(40, 0, 260, 130);

        nakupnyZoznamButton.setBackground(new java.awt.Color(255, 255, 255));
        nakupnyZoznamButton.setFont(new java.awt.Font("Caviar Dreams", 1, 30)); // NOI18N
        nakupnyZoznamButton.setForeground(new java.awt.Color(132, 160, 104));
        nakupnyZoznamButton.setText("nákupný zoznam");
        nakupnyZoznamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nakupnyZoznamButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nakupnyZoznamButton);
        nakupnyZoznamButton.setBounds(20, 460, 280, 90);

        pridavanieReceptovButton.setBackground(new java.awt.Color(255, 255, 255));
        pridavanieReceptovButton.setFont(new java.awt.Font("Caviar Dreams", 1, 30)); // NOI18N
        pridavanieReceptovButton.setForeground(new java.awt.Color(132, 160, 104));
        pridavanieReceptovButton.setText("pridávanie receptov");
        pridavanieReceptovButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridavanieReceptovButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridavanieReceptovButton);
        pridavanieReceptovButton.setBounds(30, 280, 330, 90);

        jedalnicekButton.setBackground(new java.awt.Color(255, 255, 255));
        jedalnicekButton.setFont(new java.awt.Font("Caviar Dreams", 1, 30)); // NOI18N
        jedalnicekButton.setForeground(new java.awt.Color(132, 160, 104));
        jedalnicekButton.setText("jedálniček");
        jedalnicekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jedalnicekButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jedalnicekButton);
        jedalnicekButton.setBounds(30, 370, 180, 90);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jkqdp16z2jmoen2sx9yy1hjiaxmjjm96tvlnymyadqphd2aw6akvks5rsgc3ekjh-f.jpg"))); // NOI18N
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 1060, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void receptyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receptyButtonActionPerformed
        receptyJPanel.setVisible(false);
        receptyJPanel.remove(nakupnyZoznamPanel);
        receptyJPanel.remove(jedalnicekPanel);
        receptyJPanel.add(receptyPanel);
        receptyJPanel.setVisible(true);


    }//GEN-LAST:event_receptyButtonActionPerformed

    private void nakupnyZoznamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nakupnyZoznamButtonActionPerformed
        receptyJPanel.setVisible(false);
        receptyJPanel.remove(jedalnicekPanel);
        receptyJPanel.remove(receptyPanel);
        receptyJPanel.add(nakupnyZoznamPanel);
        receptyJPanel.setVisible(true);
    }//GEN-LAST:event_nakupnyZoznamButtonActionPerformed

    private void pridavanieReceptovButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridavanieReceptovButtonActionPerformed
        PridajReceptJDialog pridajReceptJDialog = new PridajReceptJDialog(this, true);
        pridajReceptJDialog.setVisible(true);

        aktualizujVsetko();
    }//GEN-LAST:event_pridavanieReceptovButtonActionPerformed

    private void jedalnicekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jedalnicekButtonActionPerformed
        receptyJPanel.setVisible(false);
        receptyJPanel.remove(receptyPanel);
        receptyJPanel.remove(nakupnyZoznamPanel);
        receptyJPanel.add(jedalnicekPanel);
        receptyJPanel.setVisible(true);
    }//GEN-LAST:event_jedalnicekButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel cookLabel;
    private javax.swing.JButton jedalnicekButton;
    private javax.swing.JButton nakupnyZoznamButton;
    private javax.swing.JButton pridavanieReceptovButton;
    private javax.swing.JButton receptyButton;
    private javax.swing.JPanel receptyJPanel;
    // End of variables declaration//GEN-END:variables
}