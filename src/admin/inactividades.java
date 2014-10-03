/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis
 */
public class inactividades extends javax.swing.JFrame {
            conectate con;
int sal=0;
int conf=0;
    /**
     * Creates new form inactividades
     */
    public inactividades() {
        initComponents();
jLabel7.setVisible(false);
        con = new conectate();
          comboss();
          
       jButton5.setVisible(false);
        combo();
          
    }
    
    
     private void nuevo(){
         jComboBox1.setEnabled(false);
        jTextField1.setText("");
        jTextField2.setText("");
      jTextField3.setText("");
       jTextField4.setText("");
      jTextField5.setText("");
      jTextField1.setEditable(true);
      jTextField2.setEditable(true);
      jTextField3.setEditable(true);
        jTextField4.setEditable(true);
      jTextField5.setEditable(true);
      jDateChooser1.setEnabled(true);
        jDateChooser2.setEnabled(true);
       jButton1.setEnabled(true);
       jButton2.setEnabled(false);
       jButton3.setEnabled(false);
       jButton4.setEnabled(false);
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
    }
    
     public void busactividad()
{
    
    
try{  
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT  * from con_actividades where Actividad='"+jComboBox1.getSelectedItem()+"'");
         
        
         ResultSet res1 = pstm.executeQuery();
      
         while(res1.next()){
             java.util.Date finic=(res1.getDate(3));
java.util.Date ffin=(res1.getDate(4));

             
      jLabel7.setText(res1.getString(1));
      jTextField1.setText(res1.getString(2));
       jDateChooser1.setDate(finic);
       jDateChooser2.setDate(ffin);
      jTextField2.setText(res1.getString(5));
          jTextField3.setText(res1.getString(6));
          jTextField4.setText(res1.getString(7));
          jTextField5.setText(res1.getString(8));
          if (res1.getInt(9)==1){
              jRadioButton1.setSelected(true);
              jRadioButton2.setSelected(false);
          } else {
              jRadioButton2.setSelected(true);
              jRadioButton1.setSelected(false);
             }
          
         PreparedStatement pstm1 = con.getConnection().prepareStatement("select con_salones.Salon from con_salones,con_actividades where con_salones.id_Salon='"+res1.getInt(10)+"'  group by con_salones.Salon");
         
        
         ResultSet res2 = pstm1.executeQuery();
      jComboBox2.removeAllItems();
         while(res2.next()){
      jComboBox2.addItem(res2.getString(1));
         }
         res2.close();
          
          
         }
         
         
         
         
         res1.close();
          }catch(SQLException e){
         System.out.println(e);
    }     
}
     public void comboss1()
{
try{    
         PreparedStatement pstm1 = con.getConnection().prepareStatement("select con_salones.Salon from con_salones,con_actividades where con_salones.id_Salon=1  group by con_salones.Salon");
         
        
         ResultSet res2 = pstm1.executeQuery();
      jComboBox2.removeAllItems();
         while(res2.next()){
      jComboBox2.addItem(res2.getString(1));
         }
         res2.close();
          }catch(SQLException e){
         System.out.println(e);
    }   
    
    
}
     
     
     public void ElActividad(){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("delete from con_actividades where id_Actividad='"+jLabel7.getText()+"'")) {
     
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
 }
       public void ActActividad(){
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

         bussalon();
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("update con_Actividades set Actividad='"+jTextField1.getText()+"',A_Fecha_I='"+finic+"',A_Fecha_F='"+ffin+"',A_Hora_i='"+jTextField2.getText()+"',A_Hora_F='"+jTextField3.getText()+"',Impartira='"+jTextField4.getText()+"',Cupo='"+jTextField5.getText()+"',Confirmado='"+conf+"',id_salon='"+sal+"'    where id_Actividad='"+jLabel7.getText()+"'")) {
     
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
 }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
    
    
    
    
public void comboss()
{
try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT  Salon from con_salones");
         
        
         ResultSet res = pstm.executeQuery();
      jComboBox2.removeAllItems();
         while(res.next()){
      jComboBox2.addItem(res.getString(1));
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }   
    
    
}

public void combo()
{
try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT  Actividad from con_Actividades");
         
        
         ResultSet res = pstm.executeQuery();
      jComboBox1.removeAllItems();
         while(res.next()){
      jComboBox1.addItem(res.getString(1));
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }   
    
    
}


public void bussalon()
{
try{  
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT  id_Salon from con_salones where Salon='"+jComboBox2.getSelectedItem()+"'");
         
        
         ResultSet res = pstm.executeQuery();
      
         while(res.next()){
      sal=(res.getInt(1));
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

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre_de_Actividad");

        jDateChooser1.setDateFormatString("yyyy-MM-d");

        jDateChooser2.setDateFormatString("yyyy-MM-d");

        jTextField2.setEditable(false);

        jLabel2.setText("Hora_inicio");

        jTextField3.setEditable(false);

        jLabel3.setText("Hora_Fin");

        jTextField4.setEditable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Impartira");

        jTextField5.setEditable(false);

        jLabel5.setText("Cupo");

        jRadioButton1.setText("Confirmado");
        jRadioButton1.setEnabled(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("No_Confirmado");
        jRadioButton2.setEnabled(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Salon");

        jButton1.setText("INGRESAR");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jButton5.setText("Guardar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Actividades");

        jLabel9.setText("ADMINISTRADOR DE ACTIVIDADES");

        jButton7.setText("MENU");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel10.setText("Formato 00:00:00");

        jButton6.setText("CANCELAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addComponent(jLabel9))
                                    .addComponent(jLabel8))
                                .addGap(71, 71, 71)
                                .addComponent(jButton7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2))
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addGap(107, 107, 107)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jButton5)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(31, 31, 31)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
int confirmado1 =JOptionPane.showConfirmDialog(rootPane, "¿Desea Guardar Esta Actividad?");
        if (JOptionPane.OK_OPTION == confirmado1)
  
        {
        String finic;
String fin;
        String formato=jDateChooser1.getDateFormatString();
        Date date=jDateChooser1.getDate();
        SimpleDateFormat sdf=new SimpleDateFormat(formato);
       finic   =String.valueOf(sdf.format(date));



     String formato1=jDateChooser2.getDateFormatString();
        Date date1=jDateChooser2.getDate();
        SimpleDateFormat sdf1=new SimpleDateFormat(formato1);
       fin   =String.valueOf(sdf1.format(date1));

String Actividad =jTextField1.getText();
        String finicio =finic;
        String ffin =fin;
        String hinicio = jTextField2.getText();
        String hfin = jTextField3.getText();
          String impartira = jTextField4.getText();
        int cupo =Integer.parseInt(jTextField5.getText());
     bussalon();
    
        int confirmado =conf;
        
        int salon =sal;
        
        
        p.NuevaActividad(Actividad, finicio, ffin, hinicio, hfin, impartira, cupo, confirmado, salon);
jButton1.setEnabled(false);
combo();
jComboBox1.setEnabled(true);
jTextField1.setEditable(false);
jTextField2.setEditable(false);
jTextField3.setEditable(false);
jDateChooser1.setEnabled(false);
jDateChooser2.setEnabled(false);
jButton2.setEnabled(true);
jButton3.setEnabled(true);
jButton4.setEnabled(true);
 jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        }
        else
        {
        jButton1.setEnabled(false);
combo();
jComboBox1.setEnabled(true);
jTextField1.setEditable(false);
jTextField2.setEditable(false);
jTextField3.setEditable(false);
jDateChooser1.setEnabled(false);
jDateChooser2.setEnabled(false);
jButton2.setEnabled(true);
jButton3.setEnabled(true);
jButton4.setEnabled(true);
 jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
busactividad();        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

        jRadioButton2.setSelected(false);
conf=1;
   



// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

     jRadioButton1.setSelected(false);
conf=0;
   
// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
nuevo();
comboss();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  int confirmado = JOptionPane.showConfirmDialog(rootPane, "Esta Seguro De Eliminar");

if (JOptionPane.OK_OPTION == confirmado)
{   
   
        
        ElActividad();   
combo();
}else
        {
        jButton1.setEnabled(false);
combo();
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
   jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
  comboss();
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
jTextField4.setEditable(false);
jTextField5.setEditable(false);
jDateChooser1.setEnabled(false);
jDateChooser2.setEnabled(false);
jButton5.setVisible(false);
jButton2.setEnabled(true);
  jButton3.setEnabled(true); 
  jButton4.setEnabled(true);
  jButton5.setVisible(false);
  jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        ActActividad();
        combo();
}
else
{        jButton1.setEnabled(false);
combo();
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
 jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);

    
}

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        
Menu menu= new Menu();
        menu.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
jButton1.setEnabled(false);
combo();
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
 jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed
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
            java.util.logging.Logger.getLogger(inactividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inactividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inactividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inactividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inactividades().setVisible(true);
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
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
