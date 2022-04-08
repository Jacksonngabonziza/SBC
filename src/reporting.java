/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
//import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.apache.poi.hssf.usermodel.HeaderFooter.date;

/**
 *
 * @author ngabo
 */
public class reporting extends javax.swing.JFrame {
    
    
String[] options = {"All","Non-returned"};
String choice;
private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
public void extract(){

Home ob=new Home();

                    
                   choice = (String)JOptionPane.showInputDialog(null, "Entry and Exit Report", 
                null, JOptionPane.QUESTION_MESSAGE,null , options, null); 
                  //System.out.print(choice);

   database con2=new database();
 Connection con3=con2.data1();
 
 String fulln="";
 String idn="";
 String time_in="";
 String time_out="";

 //String[] options = {"Select department","MinICT","MinEMA","ALL","Visitors No ID"};

        try {
        
          
             PreparedStatement selectall=con3.prepareStatement("SELECT * FROM citizens"); 
            PreparedStatement select=con3.prepareStatement("SELECT * FROM citizens WHERE rertuntime=null;");
//            PreparedStatement sele=con3.prepareStatement("SELECT * FROM noid_visitors;");
           
            if(options[1].equals(choice)){
             //select.setString(1, choice); String[] options = {"Visitors with ID","Visitors No ID","ALL"};
            ResultSet rs=selectall.executeQuery();
            while(rs.next()){
            //Date date=new Date(time_in.getTime());
            if(rs.getTimestamp("rertuntime") != null){
            continue;
            }else{
            fulln=rs.getString("fullname");
            idn=rs.getString("idnumber");
            time_in=rs.getString("departuretime");
            time_out=rs.getString("rertuntime");
            
            DefaultTableModel model = (DefaultTableModel) report_tabl.getModel();
model.addRow(new Object[]{fulln,idn,time_in,time_out});
            }
            }
            
            //report_table.addRow(fulln,idn,phne);
           //ResultSet rse=sele.executeQuery();
          }
            else{
            
            ResultSet rs=selectall.executeQuery();
            while(rs.next()){

            fulln=rs.getString("fullname");
            idn=rs.getString("idnumber");
            time_in=rs.getString("departuretime");
            time_out=rs.getString("rertuntime");
            DefaultTableModel model = (DefaultTableModel) report_tabl.getModel();
            model.addRow(new Object[]{fulln,idn,time_in,time_out});
            }}
//            
//ResultSet rse=sele.executeQuery();
// 
//            while(rse.next()){
//            phne=rse.getString("phonenumber");
//            fulln=rse.getString("fullname");
//            String reason=rse.getString("reason");
//            time_in=rse.getString("Time_in");
//            time_out=rse.getString("Time_out");
//            int v_id=rse.getInt("visitor_id");
//            
////            desti=rse.getString("destination");
////            equip=rse.getString("equipment");
//           
//            DefaultTableModel modele = (DefaultTableModel) report_tabl.getModel();
//           // modele.removeAllElements();
//           
//modele.addRow(new Object[]{fulln,v_id,phne,time_in,time_out});
//           
//            }
//           
//  
//            }
//           else if(options[3].equals(choice)){
//            ResultSet rsf=selectll.executeQuery();
//            while(rsf.next()){
//            phne=rsf.getString("phonenumber");
//            fulln=rsf.getString("FullName");
//            idn=rsf.getString("id");
//            time_in=rsf.getString("Time_in");
//            time_out=rsf.getString("Time_out");
//            int v_id=rsf.getInt("visitor_id");
//            DefaultTableModel model = (DefaultTableModel) report_tabl.getModel();
//            model.addRow(new Object[]{fulln,v_id,phne,time_in,time_out});
//            } 
//           }
//            else{
//         
//            ResultSet rse=sele.executeQuery();
//            while(rse.next()){
//                phne=rse.getString("phonenumber");
//            fulln=rse.getString("fullname");
//            String reason=rse.getString("reason");
//            time_in=rse.getString("Time_in");
//            time_out=rse.getString("Time_out");
//            int v_id=rse.getInt("visitor_id");
////          desti=rse.getString("destination");
////            equip=rse.getString("equipment");
//            DefaultTableModel model = (DefaultTableModel) report_tabl.getModel();
//model.addRow(new Object[]{fulln,v_id,phne,time_in,time_out});
//           
//            }}
            
            
            

 //JOptionPane.showMessageDialog(Container_pane,"Visitor Added");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                  
                        

}






public void filter(){

   
}










    /**
     * Creates new form reporting
     */
    public reporting() {
        initComponents();
  
         
    }
public void openFile(String file){
               try{
                   File path = new File(file);
                   Desktop.getDesktop().open(path);
                   
                   
               }catch(IOException ioe){
               System.out.println(ioe);
               }
               
               }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        report_tabl = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REPORTS");
        setIconImages(null);
        setLocation(new java.awt.Point(280, 200));
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 800));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(1082, 800));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Print(PDF)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("BACK ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORTS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        report_tabl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Full Name", "ID", "Departure", "Return"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        report_tabl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_tablMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(report_tabl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Print Excell");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton4)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void report_tablMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_tablMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_report_tablMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {         
            
            report_tabl.print();
        } catch (PrinterException ex) {
            Logger.getLogger(reporting.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        Home obj=new Home();
//      obj.setVisible(true);
//      this.setVisible(false);
Home ob=new Home();
//ob.setVisible(true);

       dispose();
       ob.focus();
//       SimpleDateFormat sdf=new SimpleDateFormat("yyyy,MM,dd");
//       String dr=sdf.format(from_date.getDate());
//       //System.out.print(dr);
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here: 
        try{
           JFileChooser jFileChooser = new JFileChooser();
           jFileChooser.showSaveDialog(this);
           File saveFile = jFileChooser.getSelectedFile();
           
           if(saveFile != null){
               saveFile = new File(saveFile.toString()+".xlsx");
               Workbook wb = new XSSFWorkbook();
               org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet("Passenger");
               
               Row rowCol = sheet.createRow(0);
               for(int i=0;i<report_tabl.getColumnCount();i++){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(report_tabl.getColumnName(i));
               }
               
               for(int j=0;j<report_tabl.getRowCount();j++){
                   Row row = sheet.createRow(j+1);
                   for(int k=0;k<report_tabl.getColumnCount();k++){
                       Cell cell = row.createCell(k);
                       if(report_tabl.getValueAt(j, k)!=null){
                           cell.setCellValue(report_tabl.getValueAt(j, k).toString());
                       }
                   }
               }
               FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
               wb.write(out);
               wb.close();
               out.close();
               openFile(saveFile.toString());
           }else{
               JOptionPane.showMessageDialog(null,"Error al generar archivo");
           }
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(IOException io){
           System.out.println(io);
       }     
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(reporting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reporting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reporting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reporting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reporting().setVisible(true);
                
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable report_tabl;
    // End of variables declaration//GEN-END:variables
}
