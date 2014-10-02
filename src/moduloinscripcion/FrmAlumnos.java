package moduloinscripcion;
import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmAlumnos extends javax.swing.JFrame {
 DefaultTableModel modelo;
 ConexionBD con=new ConexionBD();
Connection cn = con.conectar();
    public FrmAlumnos() {

        initComponents();        
         modelo = new DefaultTableModel();
         Tabla.setModel(modelo);
         modelo.addColumn("Nombre");  
         modelo.addColumn("Carne");
         this.setLocationRelativeTo(null);
         this.setIconImage( new ImageIcon(getClass().getResource("/Img/user.png")).getImage());
       llenartabla();
    }

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        txtfiltrado = new javax.swing.JTextField();
        BtnHuella = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BtnEliminar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BtnNuevo = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        labelicon = new javax.swing.JLabel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estudiantes");
        setMinimumSize(new java.awt.Dimension(615, 490));
        getContentPane().setLayout(null);

        Tabla.setForeground(new java.awt.Color(0, 21, 56));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Carne"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 150, 537, 240);

        txtfiltrado.setForeground(new java.awt.Color(0, 21, 56));
        txtfiltrado.setToolTipText("Busqueda por nombre");
        txtfiltrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfiltradoKeyPressed(evt);
            }
        });
        getContentPane().add(txtfiltrado);
        txtfiltrado.setBounds(370, 110, 195, 30);

        BtnHuella.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnHuella.setForeground(new java.awt.Color(0, 21, 56));
        BtnHuella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Huella.png"))); // NOI18N
        BtnHuella.setText("Asignar Huella");
        BtnHuella.setToolTipText("Asignar huella digital al alumno");
        BtnHuella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHuellaActionPerformed(evt);
            }
        });
        getContentPane().add(BtnHuella);
        BtnHuella.setBounds(410, 390, 140, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 21, 56));
        jLabel2.setText("Gestion de Estudiantes");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 70, 270, 29);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(330, 110, 38, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 21, 56));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu.png"))); // NOI18N
        jButton1.setText("Menu Principal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 10, 150, 30);

        BtnEliminar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnEliminar1.setForeground(new java.awt.Color(0, 21, 56));
        BtnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete.png"))); // NOI18N
        BtnEliminar1.setText("Eliminar");
        BtnEliminar1.setToolTipText("Eliminar Alumno");
        BtnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(BtnEliminar1);
        BtnEliminar1.setBounds(290, 390, 110, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 21, 56));
        jLabel4.setText("Busqueda Rapida");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 120, 120, 17);

        BtnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnNuevo.setForeground(new java.awt.Color(0, 21, 56));
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/new.png"))); // NOI18N
        BtnNuevo.setText("Nuevo");
        BtnNuevo.setToolTipText("Nuevo Alumno");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BtnNuevo);
        BtnNuevo.setBounds(40, 390, 110, 30);

        BtnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnEditar.setForeground(new java.awt.Color(0, 21, 56));
        BtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/write.png"))); // NOI18N
        BtnEditar.setText("Editar");
        BtnEditar.setToolTipText("Editar de Alumno");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnEditar);
        BtnEditar.setBounds(160, 390, 110, 30);

        labelicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user icono.png"))); // NOI18N
        getContentPane().add(labelicon);
        labelicon.setBounds(20, 50, 110, 120);

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FondoPrincipal2.jpg"))); // NOI18N
        getContentPane().add(labelfondo);
        labelfondo.setBounds(0, 0, 610, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfiltradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltradoKeyPressed
       llenartabla();
    }//GEN-LAST:event_txtfiltradoKeyPressed

    private void BtnHuellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHuellaActionPerformed
        try
{   int fila = Tabla.getSelectedRow();
        if(fila != -1){ //vamos a inscribir
           // modelo.removeRow(fila);
            String carne = modelo.getValueAt(fila, 1).toString();
            String nombre = modelo.getValueAt(fila, 0).toString();         
           FrmHuella huella = new FrmHuella(carne,nombre);
           huella.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar un esudiante");
        }
    }//GEN-LAST:event_BtnHuellaActionPerformed
   catch(Exception ex)
   {
         JOptionPane.showMessageDialog(this,"Error" + ex.toString());
   }
    } 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
            nuevo();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
      try
{   int fila = Tabla.getSelectedRow();
        if(fila != -1){ //vamos a editar
           // modelo.removeRow(fila);
            String carne = modelo.getValueAt(fila, 1).toString();
            String nombre = modelo.getValueAt(fila, 0).toString();         
            editar(nombre,carne);    
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar un esudiante");
        }
    }                                         
   catch(Exception ex)
   {
         JOptionPane.showMessageDialog(this,"Error" + ex.toString());
   }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminar1ActionPerformed
        try
{   int fila = Tabla.getSelectedRow();
        if(fila != -1){ //vamos a editar
           // modelo.removeRow(fila);
            String carne = modelo.getValueAt(fila, 1).toString();
            String nombre = modelo.getValueAt(fila, 0).toString();         
            eliminar(nombre,carne);    
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar un esudiante");
        }
    }                                         
   catch(Exception ex)
   {
         JOptionPane.showMessageDialog(this,"Error" + ex.toString());
   }
    }//GEN-LAST:event_BtnEliminar1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
   
        java.awt.EventQueue.invokeLater(new Runnable() {
             @Override
            public void run()
            {
                     new FrmAlumnos().setVisible(true);         
            }
        });
    }
    
    public void llenartabla() //----------------------------LLENAR TALA...............
    {
        modelo.setRowCount(0);
      String filtrado = txtfiltrado.getText();
        if(filtrado!="")
            filtrado = " where  Nombre like  '%"+filtrado+"%'";
        String consulta = "Select Nombre,  Carne from con_alumnos " + filtrado;        
        try
        {
            Statement st =  cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);                      
            while(rs.next())  //while simple      
            { 
                 Object []object = new Object[8];
                object[0] = rs.getString(1);
                object[1] = rs.getString(2);
        modelo.addRow(object);  
            }                                
        }
        catch(Exception ex) {        
         JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos" + ex);
        }
    } //---------------------------- FIN LLENAR TALA...............

    
    public void nuevo () //---------------------------Nuevo estudiante .............
    {     // preparamos los eleentos para el dialog
         JTextField  TxtNombre= new JTextField(); 
         JTextField  TxtCarne = new JTextField(); // 
         Object[] mensaje =  {    //objeto con los controles pa el inputdialog
                "Nomre", TxtNombre, "Carné", TxtCarne
         };
         //mosramos el dialogo
         // respuesta de aceptar o cancelar del usuario
         int Opcion = JOptionPane.showConfirmDialog(null, mensaje,"Nuevo Estudiante", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
         if(Opcion==JOptionPane.OK_OPTION) // si el usiario preciona aceptar
                {
                    try {   
                        PreparedStatement guardarStmt =cn.prepareStatement("insert into con_alumnos (Nombre, Carne) values (?,?)");  
                       guardarStmt.setString(1,TxtNombre.getText());
                       guardarStmt.setString(2,TxtCarne.getText());
                        //Ejecuta la sentencia
                        guardarStmt.execute();
                        guardarStmt.close();              
                        JOptionPane.showMessageDialog(null,"Se ha registrado correctamente");                      
                        } catch (SQLException ex) {
                        //Si ocurre un error lo indica en la consola
                        System.err.println("Error al guardar alumno ." + ex.toString());
                        }
                }
         llenartabla();
    } //----------------------- fin nuevo estudiante....................
    
    public void editar(String nombre, String carne) //-----------------editar estudiante-----------------
    {
        // preparamos los eleentos para el dialog
         JTextField  TxtNombre= new JTextField(); 
         JTextField  TxtCarne = new JTextField(); // 
         TxtNombre.setText(nombre);
         TxtCarne.setText(carne);
         TxtCarne.enable(false);
         Object[] mensaje =  {    //objeto con los controles pa el inputdialog
               "Carné", TxtCarne, "Nomre", TxtNombre
         };
         //mosramos el dialogo
         // respuesta de aceptar o cancelar del usuario
         int Opcion = JOptionPane.showConfirmDialog(null, mensaje,"Editar Estudiante", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
         if(Opcion==JOptionPane.OK_OPTION) // si el usiario preciona aceptar
                {
                    try {   
                        PreparedStatement guardarStmt =cn.prepareStatement("update con_alumnos set Nombre=? where carne=?");  
                       guardarStmt.setString(1,TxtNombre.getText());
                       guardarStmt.setString(2,carne);
                        //Ejecuta la sentencia
                        guardarStmt.execute();
                        guardarStmt.close();              
                        JOptionPane.showMessageDialog(null,"Se ha Actualizado correctamente");                      
                        } catch (SQLException ex) {
                        //Si ocurre un error lo indica en la consola
                        System.err.println("Error al guardar alumno ." + ex.toString());
                        }
                }
         llenartabla();
    }  // -------------------------fin editar alumno................................
    
    public void eliminar(String nombre, String carne)
    {
        int Opcion = JOptionPane.showConfirmDialog(null,"Realmente desea eliminar a: "+nombre ,"Confirmacion para eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
         if(Opcion==JOptionPane.OK_OPTION) // si el usiario preciona aceptar
                {
                    try {   
                        PreparedStatement guardarStmt =cn.prepareStatement("delete from con_alumnos where carne=?");                        
                       guardarStmt.setString(1,carne);
                        //Ejecuta la sentencia
                        guardarStmt.execute();
                        guardarStmt.close();              
                        JOptionPane.showMessageDialog(null,"Se ha Eliminado correctamente");                      
                        } catch (SQLException ex) {
                        //Si ocurre un error lo indica en la consola
                        System.err.println("Error al eliminar alumno ." + ex.toString());
                        }
                }
         llenartabla();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnEliminar1;
    private javax.swing.JButton BtnHuella;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelicon;
    private javax.swing.JTextField txtfiltrado;
    // End of variables declaration//GEN-END:variables
}


