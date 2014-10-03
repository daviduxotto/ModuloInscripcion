package Principal;
import admin.*;
import BD.ConexionBD;
import moduloinscripcion.*;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FrmLogin extends javax.swing.JFrame {
ConexionBD con=new ConexionBD();
Connection cn = con.conectar();
    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
         this.setIconImage( new ImageIcon(getClass().getResource("/Img/candado.png")).getImage());
         
        
    } // fin inicializacion de componentes
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        txtcontrasenia = new javax.swing.JPasswordField();
        labelerror = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Session");
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 422, 180));
        setMinimumSize(new java.awt.Dimension(406, 180));
        setName("Iniciar "); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 21, 56));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 70, 65, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 21, 56));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 100, 110, 17);

        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(0, 21, 56));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(130, 130, 250, 23);

        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtusuario.setToolTipText("Ingrese su nombre de usuario");
        getContentPane().add(txtusuario);
        txtusuario.setBounds(240, 60, 150, 23);

        txtcontrasenia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcontrasenia.setToolTipText("Ingrese su contraseña");
        getContentPane().add(txtcontrasenia);
        txtcontrasenia.setBounds(241, 97, 150, 23);

        labelerror.setForeground(new java.awt.Color(0, 21, 56));
        labelerror.setText("*");
        getContentPane().add(labelerror);
        labelerror.setBounds(150, 160, 180, 14);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Login.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 410, 180);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
     String Usuario= txtusuario.getText();
     String Contrasenia = new String(txtcontrasenia.getPassword());
     acceder(Usuario, Contrasenia);    // fin boton ingresar 
    }//GEN-LAST:event_btnIngresarActionPerformed
   
    public void acceder (String usuario, String password) //funcion acceder
    { 
        String consulta = "Select * from con_usuarios where nombre_usuario='"+usuario+"' && password='"+password+"'";        
        try
        {
            Statement st =  cn.createStatement();
            ResultSet rs = st.executeQuery(consulta); 
            String rol="";
            String entrar="no";
            while(rs.next())  //while simple   
            {
                entrar="si";       
                rol=rs.getString(4);
              
            }
            if(entrar=="si")
            {
               
                if(rol.equals("inscripcion"))
                {                    
                   FrmModuloInscripciones inscripciones = new FrmModuloInscripciones(usuario);
                   inscripciones.setVisible(true);
                }       
                
                 if(rol.equals("Administrador"))
                {                    
                     Menu menuprincipal = new Menu();
                     menuprincipal.setVisible(true);
                }            
                this.dispose();
            }
            else            
            {
              labelerror.setText("*Usuario no valido");      
              txtusuario.requestFocus();
            }
        }
        catch(Exception ex) {        
         JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos");
        }
        con.desconectar();
    }
 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       try {
           UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            
        } catch (Exception ex) {            
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelerror;
    private javax.swing.JPasswordField txtcontrasenia;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
