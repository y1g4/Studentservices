
package com.mycompany.studentservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class Faculties extends javax.swing.JFrame {
    
    Connection con; //establish connection
    PreparedStatement statement; //execute sql statement more of optimised
    Statement st;//execute sql statement less of optimised
    String cs; //holding path of the database
    String user;//username for the database
    String password;//password for the database
    String query;
    ResultSet rs;
    String records;
    Boolean bnext = false;
    Boolean bprevious = true;
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Faculties.class.getName());

   
    public Faculties() {
        initComponents();
        
         con = null;
        st = null;
        statement = null;

        cs = "jdbc:mysql://localhost:3306/studentservicesdb";
        user = "root";
        password = "Peacebewithyouall2020!!";
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        universityidtxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        universityidtxt1 = new javax.swing.JTextField();
        universityidtxt2 = new javax.swing.JTextField();
        btnsave1 = new javax.swing.JButton();
        btnsave2 = new javax.swing.JButton();
        btnsave3 = new javax.swing.JButton();
        btnsave4 = new javax.swing.JButton();
        btnsave5 = new javax.swing.JButton();
        btnsave6 = new javax.swing.JButton();
        btnsave7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("University ID");

        jLabel3.setText("Faculty ID");

        jLabel4.setText("Faculty Name");

        btnsave1.setText("Save");
        btnsave1.addActionListener(this::btnsave1ActionPerformed);

        btnsave2.setText("Find");
        btnsave2.addActionListener(this::btnsave2ActionPerformed);

        btnsave3.setText("First");
        btnsave3.addActionListener(this::btnsave3ActionPerformed);

        btnsave4.setText("Last");
        btnsave4.addActionListener(this::btnsave4ActionPerformed);

        btnsave5.setText("Next");
        btnsave5.addActionListener(this::btnsave5ActionPerformed);

        btnsave6.setText("Delete");
        btnsave6.addActionListener(this::btnsave6ActionPerformed);

        btnsave7.setText("Previous");
        btnsave7.addActionListener(this::btnsave7ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(universityidtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addGap(212, 212, 212))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(universityidtxt2)
                    .addComponent(universityidtxt1))
                .addGap(210, 210, 210))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnsave1)
                .addGap(18, 18, 18)
                .addComponent(btnsave2)
                .addGap(18, 18, 18)
                .addComponent(btnsave3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsave4)
                .addGap(18, 18, 18)
                .addComponent(btnsave5)
                .addGap(18, 18, 18)
                .addComponent(btnsave7)
                .addGap(18, 18, 18)
                .addComponent(btnsave6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(universityidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(universityidtxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(universityidtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave1ActionPerformed
      
    }//GEN-LAST:event_btnsave1ActionPerformed

    private void btnsave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsave2ActionPerformed

    private void btnsave3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsave3ActionPerformed

    private void btnsave4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsave4ActionPerformed

    private void btnsave5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsave5ActionPerformed

    private void btnsave6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsave6ActionPerformed

    private void btnsave7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsave7ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Faculties().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsave1;
    private javax.swing.JButton btnsave2;
    private javax.swing.JButton btnsave3;
    private javax.swing.JButton btnsave4;
    private javax.swing.JButton btnsave5;
    private javax.swing.JButton btnsave6;
    private javax.swing.JButton btnsave7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField universityidtxt;
    private javax.swing.JTextField universityidtxt1;
    private javax.swing.JTextField universityidtxt2;
    // End of variables declaration//GEN-END:variables
}
