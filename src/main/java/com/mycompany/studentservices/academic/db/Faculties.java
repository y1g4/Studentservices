
package com.mycompany.studentservices.academic.db;

import com.mycompany.studentservices.academic.model.ComboItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    
    private Connection con; //establish connection
    PreparedStatement statement; //execute sql statement more of optimised
    private PreparedStatement navPst;
    Statement st;//execute sql statement less of optimised
    private String cs; //holding path of the database
    private String user;//username for the database
    private String password;//password for the database
    String query;
    private ResultSet rs;
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

    loadDropdowns();   // connect() removed — loadDropdowns() opens/closes its own connection

    // close the DB connection cleanly when the window closes
    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            closeNavigationResources();
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    });
}

  private void loadDropdowns() {
    universityidtxt4.removeAllItems();
    campusselecttxt.removeAllItems();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();

        ResultSet rsUni = st.executeQuery("SELECT University_id, University_name FROM Universities");
        while (rsUni.next()) {
            universityidtxt4.addItem(new ComboItem(rsUni.getInt("University_id"), rsUni.getString("University_name")));
        }
        rsUni.close();

        ResultSet rsCampus = st.executeQuery("SELECT Campus_id, Campus_name FROM Campuses");
        while (rsCampus.next()) {
            campusselecttxt.addItem(new ComboItem(rsCampus.getInt("Campus_id"), rsCampus.getString("Campus_name")));
        }
        rsCampus.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
        try {
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

  private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(cs, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not connect to the database:\n" + ex.getMessage(),
                    "Connection error", JOptionPane.ERROR_MESSAGE);
        }
    }
   /** Closes whatever ResultSet/PreparedStatement is currently backing First/Last/Find/Next/Previous. */
    private void closeNavigationResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (navPst != null) {
                navPst.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        rs = null;
        navPst = null;
    }
    
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        universityidtxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnsave1 = new javax.swing.JButton();
        btnfind = new javax.swing.JButton();
        btnfirst = new javax.swing.JButton();
        btnlast = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnprevious = new javax.swing.JButton();
        campusselecttxt = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        facultynametxt = new javax.swing.JTextField();
        universityidtxt4 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("University ID");

        jLabel3.setText("Faculty ID");

        jLabel4.setText("Faculty Name");

        btnsave1.setText("Save");
        btnsave1.addActionListener(this::btnsave1ActionPerformed);

        btnfind.setText("Find");
        btnfind.addActionListener(this::btnfindActionPerformed);

        btnfirst.setText("First");
        btnfirst.addActionListener(this::btnfirstActionPerformed);

        btnlast.setText("Last");
        btnlast.addActionListener(this::btnlastActionPerformed);

        btnnext.setText("Next");
        btnnext.addActionListener(this::btnnextActionPerformed);

        btndelete.setText("Delete");
        btndelete.addActionListener(this::btndeleteActionPerformed);

        btnprevious.setText("Previous");
        btnprevious.addActionListener(this::btnpreviousActionPerformed);

        campusselecttxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        campusselecttxt.addActionListener(this::campusselecttxtActionPerformed);

        jLabel5.setText("Campus ID");

        universityidtxt4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        universityidtxt4.addActionListener(this::universityidtxt4ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(universityidtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addGap(212, 212, 212))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnsave1)
                .addGap(18, 18, 18)
                .addComponent(btnfind)
                .addGap(18, 18, 18)
                .addComponent(btnfirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlast)
                .addGap(18, 18, 18)
                .addComponent(btnnext)
                .addGap(18, 18, 18)
                .addComponent(btnprevious)
                .addGap(18, 18, 18)
                .addComponent(btndelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(campusselecttxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(210, 210, 210))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(233, 233, 233)
                    .addComponent(facultynametxt)
                    .addGap(200, 200, 200)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(233, 233, 233)
                    .addComponent(universityidtxt4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(200, 200, 200)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(universityidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campusselecttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfirst, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlast, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnprevious, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(170, 170, 170)
                    .addComponent(facultynametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(235, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(253, Short.MAX_VALUE)
                    .addComponent(universityidtxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(152, 152, 152)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave1ActionPerformed
   // TODO add your handling code here:
    int s1 = Integer.parseInt(universityidtxt.getText());
    String s2 = facultynametxt.getText();
    int s3 = ((ComboItem) universityidtxt4.getSelectedItem()).getId();
    int s4 = ((ComboItem) campusselecttxt.getSelectedItem()).getId();

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");//register JDBC driver

        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();
        query = "INSERT INTO Faculties (Faculty_id,Faculty_name,Universities_University_id,Campuses_Campus_id) VALUES ('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "')";
        st.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Faculty saved successfully");

        universityidtxt.setText("");
        facultynametxt.setText("");
        universityidtxt4.setSelectedIndex(-1);
        campusselecttxt.setSelectedIndex(-1);

        universityidtxt.requestFocus();
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
    }//GEN-LAST:event_btnsave1ActionPerformed

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        // TODO add your handling code here:
        
        try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(cs, user, password);

        PreparedStatement st = con.prepareStatement("SELECT * FROM Faculties WHERE   Faculty_name ='" + facultynametxt.getText() + "'",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery();

        if (rs.first()) {
            universityidtxt.setText(rs.getString("Faculty_id"));
            facultynametxt.setText(rs.getString("Faculty_name"));
            universityidtxt4.setSelectedItem(new ComboItem(rs.getInt("Universities_University_id"), ""));
            campusselecttxt.setSelectedItem(new ComboItem(rs.getInt("Campuses_Campus_id"), ""));

        } else {
            JOptionPane.showMessageDialog(null, "Record not found");
            universityidtxt.setText("");
            facultynametxt.requestFocus();
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

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
        // TODO add your handling code here:
        
          try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();

        PreparedStatement st = con.prepareStatement("SELECT * FROM Faculties",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery();

        if (rs.first()) {
            universityidtxt.setText(rs.getString("Faculty_id"));
            facultynametxt.setText(rs.getString("Faculty_name"));
            universityidtxt4.setSelectedItem(new ComboItem(rs.getInt("Universities_University_id"), ""));
            campusselecttxt.setSelectedItem(new ComboItem(rs.getInt("Campuses_Campus_id"), ""));
            
        } else {
            JOptionPane.showMessageDialog(null, "Record not found");
            universityidtxt.setText("");
            facultynametxt.requestFocus();
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
        PreparedStatement st = con.prepareStatement("SELECT * FROM Faculties",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery();

        if (rs.last()) {
          universityidtxt.setText(rs.getString("Faculty_id"));
            facultynametxt.setText(rs.getString("Faculty_name"));
            universityidtxt4.setSelectedItem(new ComboItem(rs.getInt("Universities_University_id"), ""));
            campusselecttxt.setSelectedItem(new ComboItem(rs.getInt("Campuses_Campus_id"), ""));
        } else {
            JOptionPane.showMessageDialog(null, "Record not found");
            universityidtxt.setText("");
            facultynametxt.requestFocus();
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

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:
        
          try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Faculties",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        if (!bnext) {
            rs = st.executeQuery();
            rs.first();

          universityidtxt.setText(rs.getString("Faculty_id"));
            facultynametxt.setText(rs.getString("Faculty_name"));
            universityidtxt4.setSelectedItem(new ComboItem(rs.getInt("Universities_University_id"), ""));
            campusselecttxt.setSelectedItem(new ComboItem(rs.getInt("Campuses_Campus_id"), ""));
            bnext = true;
        } else if (rs.next()) {

            universityidtxt.setText(rs.getString("Faculty_id"));
            facultynametxt.setText(rs.getString("Faculty_name"));
            universityidtxt4.setSelectedItem(new ComboItem(rs.getInt("Universities_University_id"), ""));
            campusselecttxt.setSelectedItem(new ComboItem(rs.getInt("Campuses_Campus_id"), ""));
            bnext = true;

        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnnextActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
    int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "confirm", JOptionPane.YES_NO_OPTION);

    if (answer == YES_OPTION) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();

            PreparedStatement st = con.prepareStatement("DELETE  FROM Faculties WHERE   Faculty_name ='" + facultynametxt.getText() + "'",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            if (st.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Record with Faculty name: '" + facultynametxt.getText() + "'deleted");

            } else if (st.executeUpdate() == 0) {
                JOptionPane.showMessageDialog(null, "Record with Faculty name: '" + facultynametxt.getText() + "'does not exist");
            }

                 universityidtxt.setText(rs.getString("Faculty_id"));
            facultynametxt.setText(rs.getString("Faculty_name"));
            facultynametxt.requestFocus();
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
        facultynametxt.requestFocus();
        return;
    }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnpreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreviousActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();

        PreparedStatement st = con.prepareStatement("SELECT * FROM Faculties",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        if (!bprevious) {
            rs = st.executeQuery();
            rs.last();

       universityidtxt.setText(rs.getString("Faculty_id"));
            facultynametxt.setText(rs.getString("Faculty_name"));
            universityidtxt4.setSelectedItem(new ComboItem(rs.getInt("Universities_University_id"), ""));
            campusselecttxt.setSelectedItem(new ComboItem(rs.getInt("Campuses_Campus_id"), ""));
            bprevious = true;
        } else if (rs.previous()) {

     universityidtxt.setText(rs.getString("Faculty_id"));
            facultynametxt.setText(rs.getString("Faculty_name"));
            universityidtxt4.setSelectedItem(new ComboItem(rs.getInt("Universities_University_id"), ""));
            campusselecttxt.setSelectedItem(new ComboItem(rs.getInt("Campuses_Campus_id"), ""));
            bnext = true;

        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnpreviousActionPerformed

    private void campusselecttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campusselecttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campusselecttxtActionPerformed

    private void universityidtxt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_universityidtxt4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_universityidtxt4ActionPerformed

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
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnfirst;
    private javax.swing.JButton btnlast;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprevious;
    private javax.swing.JButton btnsave1;
    private javax.swing.JComboBox campusselecttxt;
    private javax.swing.JTextField facultynametxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField universityidtxt;
    private javax.swing.JComboBox universityidtxt4;
    // End of variables declaration//GEN-END:variables
}
