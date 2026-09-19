
package com.mycompany.studentservices;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_page extends javax.swing.JFrame {
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
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main_page.class.getName());

   
    public Main_page() {
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

        jMenu3 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        reportFaculty = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        jMenuItem1.setText("Universities");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Campuses");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Departments");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Programmes");
        jMenuItem4.addActionListener(this::jMenuItem4ActionPerformed);
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Programme Level");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Course Units");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reports");

        reportFaculty.setText("Facaulties");
        reportFaculty.addActionListener(this::reportFacultyActionPerformed);
        jMenu2.add(reportFaculty);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void reportFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportFacultyActionPerformed
        // TODO add your handling code here:
        

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");//registers the jdbc Driver
        con = DriverManager.getConnection(cs, user, password);
        st = con.createStatement();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    }

    String RESULT = "Faculties.pdf";

    Document document = new Document(PageSize.A5.rotate());
    try {
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));//Need to write in a table
    } catch (DocumentException ex) {

    } catch (FileNotFoundException ex) {
        Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
    }

    document.open();

    Image img = null;
    try {
        img = Image.getInstance("/home/anonymous/NetBeansProjects/Studentservices/university_header.png");
    } catch (BadElementException ex) {
        Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
    }
    if (img != null) {
            if (img != null) {
        img.scaleToFit(500, 100);
        img.setAlignment(Image.ALIGN_CENTER);
        try {
            document.add(img);
        } catch (DocumentException ex) {
            Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }
    try {
        document.add(new Paragraph("                          LIST OF ALL FACULTIES\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18)));
    } catch (DocumentException ex) {
        Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        document.add(new Paragraph("     "));
    } catch (DocumentException ex) {
        Logger.getLogger(Main_page.class.getName()).log(Level.SEVERE, null, ex);
    }

    PdfPTable table = new PdfPTable(2);//create table with 2 columns

    // PdfWriter writer = new PdfWriter();
    try {
        PreparedStatement st = con.prepareStatement("SELECT * FROM Faculties",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs = st.executeQuery();

        table.addCell("FACULTY ID");
        table.addCell("FACULTY NAME");

        while (rs.next()) {
            table.addCell(rs.getString("Faculty_id"));
            table.addCell(rs.getString("Faculty_name"));

        }
        document.add(table);

        DateFormat df = new SimpleDateFormat("dd/MM/yy");
     Calendar calobj = Calendar.getInstance();
     String cal1 = df.format(calobj.getTime()).toString();
     
        
         Chunk glue1 = new Chunk(new VerticalPositionMark());
                Paragraph ptot1 = new Paragraph("Generated by: The mighty group",FontFactory.getFont(FontFactory.TIMES_BOLD, 15, Font.ITALIC, BaseColor.BLACK));
                ptot1.add(new Chunk(glue1));
                ptot1.add("Issued on: " + cal1 + "");
                document.add(ptot1);


        document.close();//close a pdf document

    } catch (SQLException ex) {
        ex.printStackTrace();
    }catch (DocumentException ex) {
        ex.printStackTrace();
    }

    }//GEN-LAST:event_reportFacultyActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new Main_page().setVisible(true));
        
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         
         
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem reportFaculty;
    // End of variables declaration//GEN-END:variables
}
