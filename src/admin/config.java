/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;
import java.sql.*;
/**
 *
 * @author Luis
 */
public class config {
      conectate con;

 public config (){
    con = new conectate();
  } 
 public void NuevoSalon(String salon, String ubicacion){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into con_salones (Salon, Ubicacion) values(?,?)")) {
               pstm.setString(1, salon);
               pstm.setString(2, ubicacion);
               
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
 }
              
       
 
  public void NuevoEvento(String evento, String inicio, String fin, String precio, int cupo){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into con_eventos (Evento, E_Fecha_Inicio,E_Fecha_Final,Precio,Cupo) values(?,?,?,?,?)")) {
               pstm.setString(1, evento);
               pstm.setString(2, inicio);
               pstm.setString(3, fin);
               pstm.setString(4, precio);
               pstm.setInt(5, cupo);
               
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
  }
       public void NuevoBus(int nbus, int nasientos){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into con_buses (no_bus, asientos) values(?,?)")) {
               pstm.setInt(1, nbus);
               pstm.setInt(2, nasientos);
             
               
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
         }
       }

       public void NuevoUsuario(String nusuario, String npassword,String nrol){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into con_usuarios (nombre_usuario, password,rol) values(?,?,?)")) {
               pstm.setString(1, nusuario);
               pstm.setString(2, npassword);
             pstm.setString(3, nrol);
               
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
         }
       }
    
   

         public void NuevaActividad(String Actividad,String finicio,String ffin,String hinicio,String hfin,String impartira, int cupo, int confirmado, int salon){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into con_actividades (Actividad, A_Fecha_I,A_Fecha_F,A_Hora_I,A_Hora_F,Impartira,Cupo,Confirmado,id_salon) values(?,?,?,?,?,?,?,?,?)")) {
         
               
               pstm.setString(1, Actividad);
               pstm.setString(2, finicio);
               pstm.setString(3, ffin);
               pstm.setString(4, hinicio);
               pstm.setString(5, hfin);
               pstm.setString(6, impartira);
               pstm.setInt(7, cupo);
               pstm.setInt(8, confirmado);
               pstm.setInt(9, salon);
               
               
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
  }
          
         
         
         
}
       
       
       
       
       
       
       
       
       
       
       
       
   
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
