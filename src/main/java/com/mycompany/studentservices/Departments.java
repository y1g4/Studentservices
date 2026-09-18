
package com.mycompany.studentservices;

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

public class Departments extends javax.swing.JFrame {
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
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Departments.class.getName());

    
    public Departments() {
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
    jCombofacultyid.removeAllItems();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();

        ResultSet rsFaculty = st.executeQuery("SELECT Faculty_id, Faculty_name FROM Faculties");
        while (rsFaculty.next()) {
            jCombofacultyid.addItem(new ComboItem(rsFaculty.getInt("Faculty_id"), rsFaculty.getString("Faculty_name")));
        }
        rsFaculty.close();

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

        deptidtxt = new javax.swing.JTextField();
        deptnametxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        Findbtn = new javax.swing.JButton();
        Firstbtn = new javax.swing.JButton();
        Lastbtn = new javax.swing.JButton();
        Nextbtn = new javax.swing.JButton();
        Previousbtn = new javax.swing.JButton();
        Deletebtn = new javax.swing.JButton();
        jCombofacultyid = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Faculty ID");

        jLabel4.setText("Department ID");

        jLabel5.setText("Department Name");

        savebtn.setText("Save");
        savebtn.addActionListener(this::savebtnActionPerformed);

        Findbtn.setText("Find");
        Findbtn.addActionListener(this::FindbtnActionPerformed);

        Firstbtn.setText("First");
        Firstbtn.addActionListener(this::FirstbtnActionPerformed);

        Lastbtn.setText("Last");
        Lastbtn.addActionListener(this::LastbtnActionPerformed);

        Nextbtn.setText("Next");
        Nextbtn.addActionListener(this::NextbtnActionPerformed);

        Previousbtn.setText("Previous");
        Previousbtn.addActionListener(this::PreviousbtnActionPerformed);

        Deletebtn.setText("Delete");
        Deletebtn.addActionListener(this::DeletebtnActionPerformed);

        jCombofacultyid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(deptnametxt)
                    .addComponent(deptidtxt)
                    .addComponent(jCombofacultyid, 0, 260, Short.MAX_VALUE))
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(savebtn)
                .addGap(18, 18, 18)
                .addComponent(Findbtn)
                .addGap(18, 18, 18)
                .addComponent(Firstbtn)
                .addGap(18, 18, 18)
                .addComponent(Lastbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Nextbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(Previousbtn)
                .addGap(18, 18, 18)
                .addComponent(Deletebtn)
                .addGap(14, 14, 14))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(101, 101, 101)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(417, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(115, 115, 115)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(403, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(deptidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(deptnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombofacultyid, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Findbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Firstbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lastbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Previousbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(324, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(197, 197, 197)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(207, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
    int s1 = Integer.parseInt(deptidtxt.getText());
    String s2 = deptnametxt.getText();
    int s3 = ((ComboItem) jCombofacultyid.getSelectedItem()).getId();

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");//register JDBC driver

        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();
        query = "INSERT INTO Departments (Department_id,Department_name,Faculties_Faculty_id) VALUES ('" + s1 + "','" + s2 + "','" + s3 + "')";
        st.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Department saved successfully");

        deptidtxt.setText("");
        deptnametxt.setText("");
        jCombofacultyid.setSelectedIndex(-1);

        deptidtxt.requestFocus();
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
       
    }//GEN-LAST:event_savebtnActionPerformed

    private void FindbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindbtnActionPerformed
        // TODO add your handling code here:
         try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(cs, user, password);

        PreparedStatement st = con.prepareStatement("SELECT * FROM Departments WHERE   Department_name ='" + deptnametxt.getText() + "'",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery();

        if (rs.first()) {
            deptidtxt.setText(rs.getString("Department_id"));
            deptnametxt.setText(rs.getString("Department_name"));
            jCombofacultyid.setSelectedItem(new ComboItem(rs.getInt("Faculties_Faculty_id"), ""));

        } else {
            JOptionPane.showMessageDialog(null, "Record not found");
            deptidtxt.setText("");
            deptnametxt.requestFocus();
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
   
       
    }//GEN-LAST:event_FindbtnActionPerformed

    private void FirstbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstbtnActionPerformed
        // TODO add your handling code here:
         try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();

        PreparedStatement st = con.prepareStatement("SELECT * FROM Departments",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery();

        if (rs.first()) {
            deptidtxt.setText(rs.getString("Department_id"));
            deptnametxt.setText(rs.getString("Department_name"));
            jCombofacultyid.setSelectedItem(new ComboItem(rs.getInt("Faculties_Faculty_id"), ""));
            
        } else {
            JOptionPane.showMessageDialog(null, "Record not found");
            deptidtxt.setText("");
            deptnametxt.requestFocus();
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

    }//GEN-LAST:event_FirstbtnActionPerformed

    private void LastbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastbtnActionPerformed
           try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Departments",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery();

        if (rs.last()) {
          deptidtxt.setText(rs.getString("Department_id"));
            deptnametxt.setText(rs.getString("Department_name"));
            jCombofacultyid.setSelectedItem(new ComboItem(rs.getInt("Faculties_Faculty_id"), ""));
        } else {
            JOptionPane.showMessageDialog(null, "Record not found");
            deptidtxt.setText("");
            deptnametxt.requestFocus();
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

    }//GEN-LAST:event_LastbtnActionPerformed

    private void NextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextbtnActionPerformed
      // TODO add your handling code here:
      try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Departments",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        if (!bnext) {
            rs = st.executeQuery();
            rs.first();

          deptidtxt.setText(rs.getString("Department_id"));
            deptnametxt.setText(rs.getString("Department_name"));
            jCombofacultyid.setSelectedItem(new ComboItem(rs.getInt("Faculties_Faculty_id"), ""));
            bnext = true;
        } else if (rs.next()) {

            deptidtxt.setText(rs.getString("Department_id"));
            deptnametxt.setText(rs.getString("Department_name"));
            jCombofacultyid.setSelectedItem(new ComboItem(rs.getInt("Faculties_Faculty_id"), ""));
            bnext = true;

        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }


    }//GEN-LAST:event_NextbtnActionPerformed

    private void PreviousbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousbtnActionPerformed
     // TODO add your handling code here:
    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();

        PreparedStatement st = con.prepareStatement("SELECT * FROM Departments",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        if (!bprevious) {
            rs = st.executeQuery();
            rs.last();

       deptidtxt.setText(rs.getString("Department_id"));
            deptnametxt.setText(rs.getString("Department_name"));
            jCombofacultyid.setSelectedItem(new ComboItem(rs.getInt("Faculties_Faculty_id"), ""));
            bprevious = true;
        } else if (rs.previous()) {

     deptidtxt.setText(rs.getString("Department_id"));
            deptnametxt.setText(rs.getString("Department_name"));
            jCombofacultyid.setSelectedItem(new ComboItem(rs.getInt("Faculties_Faculty_id"), ""));
            bnext = true;

        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_PreviousbtnActionPerformed

    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
      // TODO add your handling code here:
    
     // TODO add your handling code here:
    int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "confirm", JOptionPane.YES_NO_OPTION);

    if (answer == YES_OPTION) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(cs, user, password);
            st = con.createStatement();

            PreparedStatement st = con.prepareStatement("DELETE  FROM Departments WHERE   Department_name ='" + deptnametxt.getText() + "'",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            if (st.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Record with Department name: '" + deptnametxt.getText() + "'deleted");

            } else if (st.executeUpdate() == 0) {
                JOptionPane.showMessageDialog(null, "Record with Department name: '" + deptnametxt.getText() + "'does not exist");
            }

                 deptidtxt.setText(rs.getString("Department_id"));
            deptnametxt.setText(rs.getString("Department_name"));
            deptnametxt.requestFocus();
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
        deptnametxt.requestFocus();
        return;
    }
    }//GEN-LAST:event_DeletebtnActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new Departments().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Deletebtn;
    private javax.swing.JButton Findbtn;
    private javax.swing.JButton Firstbtn;
    private javax.swing.JButton Lastbtn;
    private javax.swing.JButton Nextbtn;
    private javax.swing.JButton Previousbtn;
    private javax.swing.JTextField deptidtxt;
    private javax.swing.JTextField deptnametxt;
    private javax.swing.JComboBox jCombofacultyid;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton savebtn;
    // End of variables declaration//GEN-END:variables
}
