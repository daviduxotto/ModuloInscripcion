/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moduloinscripcion;

/**
 *
 * @author David
 */
public class ObtenerEvento {
     private String nombre;
  private String id ;
  
  public ObtenerEvento(String nombre , String id ) {
    this.nombre=nombre;
    this.id=id;
  }
 
  public String getID(){
    return id ;
  }
 
  public String toString() {
    return nombre ;
  }
}
