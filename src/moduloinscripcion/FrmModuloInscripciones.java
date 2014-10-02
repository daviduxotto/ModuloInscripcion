package moduloinscripcion;
import BD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class FrmModuloInscripciones extends javax.swing.JFrame {
    String Usuario;
  ConexionBD con=new ConexionBD();
Connection cn = con.conectar();

    public FrmModuloInscripciones(String usuario) {
        Usuario=usuario;
        initComponents();
         this.setLocationRelativeTo(null);
        this.setIconImage( new ImageIcon(getClass().getResource("/Img/user.png")).getImage());
    }

    private FrmModuloInscripciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelicon = new javax.swing.JLabel();
        BotonIscritos = new javax.swing.JButton();
        labelicon1 = new javax.swing.JLabel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alumnos e Inscripciones");
        setMinimumSize(new java.awt.Dimension(615, 490));
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/carnet.png"))); // NOI18N
        jButton1.setText("Gestion de Alumnos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 280, 250, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 21, 56));
        jLabel2.setText("Modulo de Alumnos e Inscripciones");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 50, 390, 70);

        labelicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lapiz.png"))); // NOI18N
        getContentPane().add(labelicon);
        labelicon.setBounds(280, 130, 130, 120);

        BotonIscritos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonIscritos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agenda.png"))); // NOI18N
        BotonIscritos.setText("Incripciones de Convenciones");
        BotonIscritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIscritosActionPerformed(evt);
            }
        });
        getContentPane().add(BotonIscritos);
        BotonIscritos.setBounds(300, 280, 260, 50);

        labelicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user icono.png"))); // NOI18N
        getContentPane().add(labelicon1);
        labelicon1.setBounds(190, 110, 130, 120);

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FondoPrincipal2.jpg"))); // NOI18N
        getContentPane().add(labelfondo);
        labelfondo.setBounds(0, 0, 610, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmAlumnos alumnos = new FrmAlumnos();
        alumnos.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotonIscritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIscritosActionPerformed
       inscripciones();
    }//GEN-LAST:event_BotonIscritosActionPerformed

    public void inscripciones() 
    {
        //primero llenaremos combos con los eventos
        //establecemos un modelo para el combo para recibir los eventos
         DefaultComboBoxModel value;
          value =new DefaultComboBoxModel();
          JComboBox ComboEvento = new  JComboBox (); // 
          ComboEvento.setModel(value);
        String consulta = "Select Id_evento, evento from con_eventos ";        
        try
        {           
            Statement st =  cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);              
            while(rs.next())  //while simple      
            { 
             value.addElement(new ObtenerEvento(rs.getString(2),rs.getString(1)));        
            }                                
        }
        catch(Exception ex) {        
         JOptionPane.showMessageDialog(null, "Error al intentar abrir la base de datos" + ex);
        }
        // hacemos un objeto donde metemos el combo evento
        Object[] mensaje =  {    //objeto con los controles pa el inputdialog
                "Evento: ", ComboEvento
         };
        int Opcion = JOptionPane.showConfirmDialog(null, mensaje,"Selecciones el Evento", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        ObtenerEvento evento = (ObtenerEvento)ComboEvento.getSelectedItem();
        String idEvento= evento.getID();
         if(Opcion==JOptionPane.OK_OPTION) // si el usiario preciona aceptar
                {
                FrmInscritos inscritos = new FrmInscritos(idEvento, Usuario);
                inscritos.setVisible(true);
         }
         
         
    }
    
   
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
           UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            
        } catch (Exception ex) {            
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmModuloInscripciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIscritos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelicon;
    private javax.swing.JLabel labelicon1;
    // End of variables declaration//GEN-END:variables
}
