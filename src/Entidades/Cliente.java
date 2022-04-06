/*
 * Bienvenido, este es un mensaje auto-generado por Damian Dries
 * Damian Dries - JAVA DEV 
 * www.damiandries.com.ar
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Damian Dries - "www.damiandries.com.ar"
 */
public class Cliente {
    
    private String nombre;
    private Integer dni;

     public Cliente(String nombre, Integer dni) {
          this.nombre = nombre;
          this.dni = dni;
     }

     public Integer getDni() {
          return dni;
     }

     public void setDni(Integer dni) {
          this.dni = dni;
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }


    @Override
    public String toString() {
        return "\nNombre: "+nombre + "\tDni: "+ dni ;
    }
    
    
}
