
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


public class Universities extends javax.swing.JFrame {
    
    
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
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Universities.class.getName());

    
    public Universities() {
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

        jLabel1 = new javax.swing.JLabel();
        btnfind = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        universitynametxt = new javax.swing.JTextField();
        universityidtxt = new javax.swing.JTextField();
        btnsave1 = new javax.swing.JButton();
        btnfirst = new javax.swing.JButton();
        btnlast = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        previousbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("University Name");

        btnfind.setText("Find");
        btnfind.addActionListener(this::btnfindActionPerformed);

        jLabel2.setText("University ID");

        btnsave1.setText("Save");
        btnsave1.addActionListener(this::btnsave1ActionPerformed);

        btnfirst.setText("First");
        btnfirst.addActionListener(this::btnfirstActionPerformed);

        btnlast.setText("Last");
        btnlast.addActionListener(this::btnlastActionPerformed);

        nextbtn.setText("Next");
        nextbtn.addActionListener(this::nextbtnActionPerformed);

        previousbtn.setText("Previous");
        previousbtn.addActionListener(this::previousbtnActionPerformed);

        deletebtn.setText("Delete");
        deletebtn.addActionListener(this::deletebtnActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(universitynametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(universityidtxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnsave1)
                        .addGap(18, 18, 18)
                        .addComponent(btnfind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnfirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnlast)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(previousbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deletebtn)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(433, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(universityidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(universitynametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfirst, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlast, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(330, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        // TODO add your handling code here:
       try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(cs, user, password);

            PreparedStatement st = con.prepareStatement("SELECT * FROM Universities WHERE   University_name ='" + universitynametxt.getText() + "'",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                universityidtxt.setText(rs.getString("University_id"));
                universitynametxt.setText(rs.getString("University_name"));
                

            } else {
                JOptionPane.showMessageDialog(null, "Record not found");
                universityidtxt.setText("");
                universitynametxt.setText("");
                universitynametxt.requestFocus();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
       
    }//GEN-LAST:event_btnfindActionPerformed

    private void btnsave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave1ActionPerformed
        // TODO add your handling code here:
         int s1 = Integer.parseInt(universityidtxt.getText());
        String s2 = universitynametxt.getText();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");//register JDBC driver

            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            query = "INSERT INTO Universities (University_id,University_name) VALUES ('" + s1 + "','" + s2 + "')";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "University saved successfully");

            universityidtxt.setText("");
            universitynametxt.setText("");
            
            universityidtxt.requestFocus();
        } catch (SQLException ex) {
            ex.printStackTrace();//displays information about SQL statement incase you typed table name or field name that is not existing
            //it displays where the error may be
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //checks if the driver  is not configured
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnsave1ActionPerformed

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
        // TODO add your handling code here:
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();

            PreparedStatement st = con.prepareStatement("SELECT * FROM Universities",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery();

            if (rs.first()) {
                universityidtxt.setText(rs.getString("University_id"));
                universitynametxt.setText(rs.getString("University_name"));
                
            } else {
                JOptionPane.showMessageDialog(null, "Record not found");
                universitynametxt.setText("");
                universitynametxt.requestFocus();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnfirstActionPerformed

    private void btnlastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlastActionPerformed
         // TODO add your handling code here:
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Universities",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery();

            if (rs.last()) {
              universityidtxt.setText(rs.getString("University_id"));
                universitynametxt.setText(rs.getString("University_name"));
            } else {
                JOptionPane.showMessageDialog(null, "Record not found");
                universitynametxt.setText("");
                universitynametxt.requestFocus();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnlastActionPerformed

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        // TODO add your handling code here:
        
         try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Universities",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            if (!bnext) {
                rs = st.executeQuery();
                rs.first();

              universityidtxt.setText(rs.getString("University_id"));
                universitynametxt.setText(rs.getString("University_name"));
                bnext = true;
            } else if (rs.next()) {

                universityidtxt.setText(rs.getString("University_id"));
                universitynametxt.setText(rs.getString("University_name"));
                bnext = true;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_nextbtnActionPerformed

    private void previousbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousbtnActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();

            PreparedStatement st = con.prepareStatement("SELECT * FROM Universities",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            if (!bprevious) {
                rs = st.executeQuery();
                rs.last();

           universityidtxt.setText(rs.getString("University_id"));
                universitynametxt.setText(rs.getString("University_name"));
                bprevious = true;
            } else if (rs.previous()) {

     universityidtxt.setText(rs.getString("University_id"));
                universitynametxt.setText(rs.getString("University_name"));
                bnext = true;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_previousbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        
         // TODO add your handling code here:
        int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "confirm", JOptionPane.YES_NO_OPTION);

        if (answer == YES_OPTION) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(cs, user, password);
                st = con.createStatement();

                PreparedStatement st = con.prepareStatement("DELETE  FROM Universities WHERE   University_name ='" + universitynametxt.getText() + "'",
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                if (st.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(null, "Record with University name: '" + universitynametxt.getText() + "'deleted");

                } else if (st.executeUpdate() == 0) {
                    JOptionPane.showMessageDialog(null, "Record with University name: '" + universitynametxt.getText() + "'does not exist");
                }

                     universityidtxt.setText(rs.getString("University_id"));
                universitynametxt.setText(rs.getString("University_name"));
                universitynametxt.requestFocus();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (st != null) {
                        st.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        } else if (answer == NO_OPTION) {
            universitynametxt.requestFocus();
            return;
        }
    }//GEN-LAST:event_deletebtnActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Universities().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnfirst;
    private javax.swing.JButton btnlast;
    private javax.swing.JButton btnsave1;
    private javax.swing.JButton deletebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton nextbtn;
    private javax.swing.JButton previousbtn;
    private javax.swing.JTextField universityidtxt;
    private javax.swing.JTextField universitynametxt;
    // End of variables declaration//GEN-END:variables
}
