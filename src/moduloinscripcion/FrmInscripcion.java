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

public class FrmInscripcion extends javax.swing.JFrame {
 DefaultTableModel modelo;
String IdEvento, Usuario;
 ConexionBD con=new ConexionBD();
Connection cn = con.conectar();
    public FrmInscripcion(String idEvento,String usuario) {
      IdEvento=idEvento;
      Usuario=usuario;
        initComponents();        
         modelo = new DefaultTableModel();
         Tabla.setModel(modelo);
         modelo.addColumn("Nombre");  
         modelo.addColumn("Carne");         
         this.setLocationRelativeTo(null);
         this.setIconImage( new ImageIcon(getClass().getResource("/Img/new.png")).getImage());
       llenartabla();
       llenarbus();
    }

    private FrmInscripcion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        txtfiltrado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BtnNuevo = new javax.swing.JButton();
        labelicon = new javax.swing.JLabel();
        ComboBus = new javax.swing.JComboBox();
        ComboAsiento = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelicon1 = new javax.swing.JLabel();
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
        jScrollPane1.setBounds(30, 150, 450, 240);

        txtfiltrado.setForeground(new java.awt.Color(0, 21, 56));
        txtfiltrado.setToolTipText("Busqueda por nombre");
        txtfiltrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfiltradoKeyPressed(evt);
            }
        });
        getContentPane().add(txtfiltrado);
        txtfiltrado.setBounds(370, 110, 195, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 21, 56));
        jLabel2.setText("Nueva Inscripcion");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 70, 260, 29);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(330, 110, 38, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 21, 56));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 10, 150, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 21, 56));
        jLabel4.setText("Seleccione No. Asiento");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(490, 260, 110, 13);

        BtnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnNuevo.setForeground(new java.awt.Color(0, 21, 56));
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/new.png"))); // NOI18N
        BtnNuevo.setText("Inscribir Alumno");
        BtnNuevo.setToolTipText("Nuevo Alumno");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BtnNuevo);
        BtnNuevo.setBounds(440, 390, 160, 30);

        labelicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/bus.png"))); // NOI18N
        getContentPane().add(labelicon);
        labelicon.setBounds(510, 140, 70, 90);

        ComboBus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBusItemStateChanged(evt);
            }
        });
        getContentPane().add(ComboBus);
        ComboBus.setBounds(490, 230, 80, 20);

        getContentPane().add(ComboAsiento);
        ComboAsiento.setBounds(490, 280, 80, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 21, 56));
        jLabel5.setText("Busqueda Rapida");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 120, 120, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 21, 56));
        jLabel6.setText("Seleccione No. Bus");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(490, 210, 90, 13);

        labelicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user icono.png"))); // NOI18N
        getContentPane().add(labelicon1);
        labelicon1.setBounds(20, 50, 110, 120);

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FondoPrincipal2.jpg"))); // NOI18N
        getContentPane().add(labelfondo);
        labelfondo.setBounds(0, 0, 610, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfiltradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltradoKeyPressed
       llenartabla();
    }//GEN-LAST:event_txtfiltradoKeyPressed
   
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmInscritos inscritos = new FrmInscritos(IdEvento,Usuario);
                inscritos.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
             try
{   int fila = Tabla.getSelectedRow();
        if(fila != -1){ //vamos a editar
           // modelo.removeRow(fila);
            String carne = modelo.getValueAt(fila, 1).toString();
            String nombre = modelo.getValueAt(fila, 0).toString();         
            insertarinscripcion(carne);
            
            FrmInscritos inscritos = new FrmInscritos(IdEvento, Usuario);
            inscritos.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar un esudiante");
        }
    }                                         
   catch(Exception ex)
   {
         JOptionPane.showMessageDialog(this,"Error" + ex.toString());
   }
    }//GEN-LAST:event_BtnNuevoActionPerformed

     public void insertarinscripcion(String Carne)
    {       
        String idusuario ="",idalumno = "";
        String consulta;
        try
        {
             //primero necesitamos saber el id del usuario logeado
            consulta = "select id_usuario from con_usuarios where nombre_usuario ='"+Usuario+"'";
            Statement st =  cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);                   
            while(rs.next())  //while simple      
                idusuario= rs.getString(1);
            
             //segundo necesitamos saber el id del alumno
            consulta = "select Id_Alumno from con_alumnos where carne ='"+Carne+"'";
            Statement st2 =  cn.createStatement();
            ResultSet rs2 = st2.executeQuery(consulta);                   
            while(rs2.next())  //while simple      
                idalumno= rs2.getString(1);
            
            //tercero vamos a guardar la inscripcion
             PreparedStatement guardarStmt =cn.prepareStatement("INSERT INTO con_inscripciones (id_alumno, id_evento, inscribio, no_asiento,no_bus) VALUES (?,?,?,?,?)");   
                guardarStmt.setInt(1,  Integer.parseInt(idalumno));
                guardarStmt.setInt(2, Integer.parseInt(IdEvento));
                guardarStmt.setInt(3, Integer.parseInt(idusuario));
                guardarStmt.setInt(4, Integer.parseInt(ComboAsiento.getSelectedItem().toString()));
                guardarStmt.setInt(5, Integer.parseInt(ComboBus.getSelectedItem().toString()));
     //Ejecuta la sentencia
     guardarStmt.execute();
     guardarStmt.close();
       JOptionPane.showMessageDialog(null,"Se ha Inscrito correctamente");
            
         }
        catch(Exception ex) {        
         JOptionPane.showMessageDialog(null, "Error al inscribit" + ex.toString());
        }
        con.desconectar();
        
        ImprimirRecibo dialog = new ImprimirRecibo(new javax.swing.JFrame(), true);
  
    }
    
    private void ComboBusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBusItemStateChanged
       llenarasiento();
    }//GEN-LAST:event_ComboBusItemStateChanged

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
            java.util.logging.Logger.getLogger(FrmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
   
        java.awt.EventQueue.invokeLater(new Runnable() {
             @Override
            public void run()
            {
                     new FrmInscripcion().setVisible(true);         
            }
        });
    }
    
    public void llenartabla() //----------------------------LLENAR TALA...............
    {
        modelo.setRowCount(0);
      String filtrado = txtfiltrado.getText();
        if(filtrado!="")
            filtrado = " where  Nombre like  '%"+filtrado+"%'";
        String consulta = "SELECT a.nombre, a.carne  FROM con_alumnos a  LEFT JOIN con_inscripciones i ON i.id_alumno = a.id_alumno " + filtrado+" GROUP BY a.id_alumno  HAVING COUNT( i.id_alumno ) <1";        
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

    public void llenarbus() 
    {
                          
        String consulta = "Select no_bus from con_buses ";        
        try
        {           
            Statement st =  cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);              
            while(rs.next())  //while simple      
            { 
             ComboBus.addItem(rs.getString(1)); 
            }                                
        }
        catch(Exception ex) {        
         JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos" + ex);
        }
        // hacemos un objeto donde metemos el combo evento                         
    }
    
    public void llenarasiento()
    {
        ComboAsiento.removeAllItems();
        String consulta = "Select no_asiento from con_asientos where disponibilidad=true and  no_bus="+ComboBus.getSelectedItem().toString();        
        try
        {           
            Statement st =  cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);              
            while(rs.next())  //while simple      
            { 
             ComboAsiento.addItem(rs.getString(1)); 
            }                                
        }
        catch(Exception ex) {        
         JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos" + ex);
        }
        // hacemos un objeto donde metemos el combo evento                
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox ComboAsiento;
    private javax.swing.JComboBox ComboBus;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelicon;
    private javax.swing.JLabel labelicon1;
    private javax.swing.JTextField txtfiltrado;
    // End of variables declaration//GEN-END:variables
}


