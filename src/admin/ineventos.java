/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ineventos extends javax.swing.JFrame {
 conectate con;
    /**
     * Creates new form eventos
     */
    public ineventos() {
        initComponents();
jLabel7.setVisible(false);
        con = new conectate();
       jButton5.setVisible(false);
        combo1();
        
        
    }

     private void nuevo(){
         jComboBox1.setEnabled(false);
        jTextField1.setText("");
        jTextField2.setText("");
      jTextField3.setText("");
      jTextField1.setEditable(true);
      jTextField2.setEditable(true);
      jTextField3.setEditable(true);
      jDateChooser1.setEnabled(true);
        jDateChooser2.setEnabled(true);
       jButton1.setEnabled(true);
       jButton2.setEnabled(false);
       jButton3.setEnabled(false);
       jButton4.setEnabled(false);
    }
     
         public void busactividad()
{
    
    
try{  
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT  * from con_eventos where Evento='"+jComboBox1.getSelectedItem()+"'");
         
        
         ResultSet res1 = pstm.executeQuery();
      
         while(res1.next()){
             Date finic=(res1.getDate(3));
Date ffin=(res1.getDate(4));

             
      jLabel7.setText(res1.getString(1));
      jTextField1.setText(res1.getString(2));
       jDateChooser1.setDate(finic);
       jDateChooser2.setDate(ffin);
      jTextField2.setText(res1.getString(5));
          jTextField3.setText(res1.getString(6));
         }
         res1.close();
          }catch(SQLException e){
         System.out.println(e);
    }     
}
     
     
     
     public void ElEvento(){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("delete from con_eventos where id_Evento='"+jLabel7.getText()+"'")) {
     
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
 }
     
     public void ActEvento(){
         String finic;
String ffin;
        String formato=jDateChooser1.getDateFormatString();
        Date date=jDateChooser1.getDate();
        SimpleDateFormat sdf=new SimpleDateFormat(formato);
       finic   =String.valueOf(sdf.format(date));



     String formato1=jDateChooser2.getDateFormatString();
        Date date1=jDateChooser2.getDate();
        SimpleDateFormat sdf1=new SimpleDateFormat(formato1);
       ffin   =String.valueOf(sdf1.format(date1));

         
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("update con_eventos set Evento='"+jTextField1.getText()+"',E_Fecha_Inicio='"+finic+"',E_Fecha_Final='"+ffin+"',Precio='"+jTextField2.getText()+"',Cupo='"+Integer.parseInt(jTextField3.getText())+"'     where id_Evento='"+jLabel7.getText()+"'")) {
     
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
 }
     
    
    public void combo1()
{
try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT  Evento from con_eventos");
         
         jComboBox1.removeAllItems();
         ResultSet res = pstm.executeQuery();
      
         while(res.next()){
      jComboBox1.addItem(res.getString(1));
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
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

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("AGREGAR");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jTextField2.setEditable(false);

        jTextField3.setEditable(false);

        jDateChooser1.setDateFormatString("yyyy-MM-d");

        jDateChooser2.setDateFormatString("yyyy-MM-d");

        jLabel1.setText("ADIMINISTRACION DE EVENTOS");

        jLabel2.setText("Nombre del Evento");

        jLabel3.setText("Fecha Inicio");

        jLabel4.setText("Fecha Final");

        jLabel5.setText("Precio");

        jLabel6.setText("Cupo");

        jButton2.setText("NUEVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ACTUALIZAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton5.setText("Guardar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("jLabel7");

        jButton6.setText("MENU");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel8.setText("Eventos");

        jButton7.setText("CANCELAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jLabel2)
                            .addGap(77, 77, 77)
                            .addComponent(jLabel3)
                            .addGap(101, 101, 101)
                            .addComponent(jLabel4))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel1)
                                                .addGap(94, 94, 94)))
                                        .addComponent(jButton6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton5)
                            .addGap(14, 14, 14)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel5)
                                .addGap(158, 158, 158)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 int confirmado =JOptionPane.showConfirmDialog(rootPane, "¿Desea Guardar El Evento?");
        if (JOptionPane.OK_OPTION == confirmado)
  
        {
        
        String finic;
String ffin;
        String formato=jDateChooser1.getDateFormatString();
        Date date=jDateChooser1.getDate();
        SimpleDateFormat sdf=new SimpleDateFormat(formato);
       finic   =String.valueOf(sdf.format(date));



     String formato1=jDateChooser2.getDateFormatString();
        Date date1=jDateChooser2.getDate();
        SimpleDateFormat sdf1=new SimpleDateFormat(formato1);
       ffin   =String.valueOf(sdf1.format(date1));




       String evento =jTextField1.getText();
        String inicio =finic;
        String fin =ffin;
        String precio = jTextField2.getText();
        int cupo =Integer.parseInt(jTextField3.getText());
        
        p.NuevoEvento(evento,inicio,fin,precio,cupo);        
jButton1.setEnabled(false);
combo1();
jComboBox1.setEnabled(true);
jTextField1.setEditable(false);
jTextField2.setEditable(false);
jTextField3.setEditable(false);
jDateChooser1.setEnabled(false);
jDateChooser2.setEnabled(false);
jButton2.setEnabled(true);
jButton3.setEnabled(true);
jButton4.setEnabled(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
        else{
            jButton1.setEnabled(false);
combo1();
jComboBox1.setEnabled(true);
jTextField1.setEditable(false);
jTextField2.setEditable(false);
jTextField3.setEditable(false);
jDateChooser1.setEnabled(false);
jDateChooser2.setEnabled(false);
jButton2.setEnabled(true);
jButton3.setEnabled(true);
jButton4.setEnabled(true);
            
        }
    
    }
    
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
nuevo();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
busactividad();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

     int confirmado = JOptionPane.showConfirmDialog(rootPane, "Esta Seguro De Eliminar");

if (JOptionPane.OK_OPTION == confirmado)
{   
        
        ElEvento();

combo1();}
else{
            jButton1.setEnabled(false);
combo1();
jComboBox1.setEnabled(true);
jTextField1.setEditable(false);
jTextField2.setEditable(false);
jTextField3.setEditable(false);
jDateChooser1.setEnabled(false);
jDateChooser2.setEnabled(false);
jButton2.setEnabled(true);
jButton3.setEnabled(true);
jButton4.setEnabled(true);
            
        }


// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
jTextField1.setEditable(true);
jTextField2.setEditable(true);
jTextField3.setEditable(true);
jDateChooser1.setEnabled(true);
jDateChooser2.setEnabled(true);
jComboBox1.setEnabled(false);
jButton5.setVisible(true);
jButton2.setEnabled(false);
  jButton3.setEnabled(false); 
  jButton4.setEnabled(false);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
int confirmado = JOptionPane.showConfirmDialog(rootPane, "Desea Guardar Cambios");

if (JOptionPane.OK_OPTION == confirmado)
{

        
        
        jComboBox1.setEnabled(true);
jTextField1.setEditable(false);
jTextField2.setEditable(false);
jTextField3.setEditable(false);
jDateChooser1.setEnabled(false);
jDateChooser2.setEnabled(false);
jButton5.setVisible(false);
jButton2.setEnabled(true);
  jButton3.setEnabled(true); 
  jButton4.setEnabled(true);
        
        ActEvento();
        combo1();
}
        else{
            jButton1.setEnabled(false);
combo1();
jComboBox1.setEnabled(true);
jTextField1.setEditable(false);
jTextField2.setEditable(false);
jTextField3.setEditable(false);
jDateChooser1.setEnabled(false);
jDateChooser2.setEnabled(false);
jButton2.setEnabled(true);
jButton3.setEnabled(true);
jButton4.setEnabled(true);
          jButton5.setVisible(false);  
        }
    
    
  

        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
  

Menu menu= new Menu();
        menu.setVisible(true);
        this.setVisible(false);        

// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
jButton1.setEnabled(false);
combo1();
jComboBox1.setEnabled(true);
jTextField1.setEditable(false);
jTextField2.setEditable(false);
jTextField3.setEditable(false);
jDateChooser1.setEnabled(false);
jDateChooser2.setEnabled(false);
jButton2.setEnabled(true);
jButton3.setEnabled(true);
jButton4.setEnabled(true);
          jButton5.setVisible(false);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed



config p= new config(); 
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
            java.util.logging.Logger.getLogger(ineventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ineventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ineventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ineventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ineventos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
