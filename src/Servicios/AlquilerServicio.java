/*
 * Bienvenido, este es un mensaje auto-generado por Damian Dries
 * Damian Dries - JAVA DEV 
 * www.damiandries.com.ar
 */
package Servicios;

import Entidades.Alquiler;
import Entidades.Cliente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Damian Dries - "www.damiandries.com.ar"
 */
public class AlquilerServicio {

    
    public void mostrarDatos() {
        Scanner read = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
       
        System.out.println("Ingrese el nombre y apellido del cliente");
        String nombre = read.nextLine();
        System.out.println("Ingrese el dni");
        int dni = read.nextInt();
        System.out.println("Ingrese el numero del dia de devolucion");
        int dia = read.nextInt();
        int mes = 0;
        Cliente cli1 = new Cliente(nombre, dni);
        Date Fecha=new Date();
        if(dia>Fecha.getDay()){
            mes=Fecha.getMonth()+1;
        }else{
            mes=Fecha.getMonth();
        }
        Alquiler tran1 = new Alquiler(cli1, new ArrayList(), new ArrayList(), Fecha ,new Date(Date.UTC(Fecha.getYear(), mes, dia+1, 0, 0, 0)) );
        
        double precioFinal = tran1.precioSegunBarco();
        String barcos = tran1.getBarcos().stream().map((barco) -> "\n"+barco.getClass().getSimpleName()
                +barco.getAmarre()+"\n"+barco.toString()).reduce("", String::concat);
        
        System.out.println("\nCLIENTE: "+tran1.getCliente()+"\n\nEmbarcaciones: \n"+barcos+"\nFecha Incio Alquiler: "
                +formato.format(tran1.getFechaInicioAlquiler())
                +"\nFecha Fin Alquiler: "+formato.format(tran1.getFechaFinAlquiler())
                +"\nCantidad de dias de alquiler: "+tran1.calcularDiasDeAlquiler()
                +"\n\nPrecio final por dia de alquiler para sus embarcaciones es: "+(precioFinal)+"\n");
    }
}
