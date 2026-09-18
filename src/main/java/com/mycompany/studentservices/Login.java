
package com.mycompany.studentservices;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class Login extends javax.swing.JFrame {

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
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

   
    public Login() {
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

        signupbtn = new javax.swing.JButton();
        loginbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        signupbtn.setText("Signup");
        signupbtn.addActionListener(this::signupbtnActionPerformed);

        loginbtn.setText("Login");
        loginbtn.addActionListener(this::loginbtnActionPerformed);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        txtpassword.addActionListener(this::txtpasswordActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(254, 254, 254)
                    .addComponent(txtusername, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addGap(77, 77, 77)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(263, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        // TODO add your handling code here:
        
    String s1 =  txtusername.getText();
    String s2 =  txtpassword.getText();


try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");//register JDBC driver
    
    con = DriverManager.getConnection(cs,user,password);
    st = con.createStatement();
    query = "INSERT INTO Login (Username,Password) VALUES ('"+s1+"','"+s2+"')";
    st. executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Sign up successfull\n You can now Login");
    
    txtusername.setText("");
    txtpassword.setText("");
    txtusername.requestFocus();  //setting focus on REGNO  
    
}
catch (SQLException ex){
    ex.printStackTrace();//displays information about SQL statement incase you typed table name or field name that is not existing
    //it displays where the error may be
}
catch (ClassNotFoundException e){
  e.printStackTrace();  //checks if the driver  is not configured
}

finally{
    
    try{
        if(st != null)
        {
            st.close();
        }
        if(con != null){
            con.close();
        }
    }
        catch (SQLException ex){
                ex.printStackTrace();
                }
    }
    }//GEN-LAST:event_signupbtnActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        // TODO add your handling code here:
         if(txtusername.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please insert  Username");
           txtusername.requestFocus();
            return;
        }
        if(txtpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please insert  Password ");
            txtpassword.requestFocus();
            return;
        } 
        try{
                
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(cs,user,password);
            st = con.createStatement();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Login WHERE   Username ='"+txtusername.getText()+"'  and "
                        + "Password ='"+txtpassword.getText()+"'", 
            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                //query = "select * from signup where RegNo = '"+txtusername.getText()+"'";
           //st.executeUpdate(query);
           //JOptionPane.showMessageDialog(null,"record saved");
           ResultSet rs = st.executeQuery();
           
           if(rs.first())
           {
               //rs.last
               
           
           txtusername.setText(rs.getString("Username")); 
           txtpassword.setText(rs.getString("Password"));
           txtusername.requestFocus();
           dispose();
         // new Main_page().Main();
           }
           else{
               JOptionPane.showMessageDialog(null,"Wrong password");
                       txtusername.setText("");
                       txtusername.requestFocus();
           }

                }
                
                catch(SQLException ex){
                    ex.printStackTrace();
                
                }
                  catch(ClassNotFoundException e){
                    e.printStackTrace();
                
                }
                
                finally{
                
                try{
                if (st != null)
                {
                    st.close();
                }
                
                if (con !=null){
                    con.close();
                }
                
                }
                catch (SQLException ex){
                        ex.printStackTrace();
                        }
                }
    }//GEN-LAST:event_loginbtnActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginbtn;
    private javax.swing.JButton signupbtn;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
