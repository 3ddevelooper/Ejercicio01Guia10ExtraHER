/*
 * Bienvenido, este es un mensaje auto-generado por Damian Dries
 * Damian Dries - JAVA DEV 
 * www.damiandries.com.ar
 */
package Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *
 * @author Damian Dries - "www.damiandries.com.ar"
 */
public class Alquiler {

    private Cliente cliente;

    private ArrayList<Barco> barcos;

    private ArrayList<Integer> posicionAmarre;

    private Date fechaInicioAlquiler;

    private Date fechaFinAlquiler;

    public Alquiler(Cliente cliente, ArrayList<Barco> barcos, ArrayList<Integer> posicionAmarre, Date fechaInicioAlquiler, Date fechaFinAlquiler) {
        this.cliente = cliente;
        this.barcos = barcos;
        this.posicionAmarre = posicionAmarre;
        this.fechaInicioAlquiler = fechaInicioAlquiler;
        this.fechaFinAlquiler = fechaFinAlquiler;

    }

    public ArrayList<Integer> getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(ArrayList<Integer> posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    public void setBarcos(ArrayList<Barco> barcos) {
        this.barcos = barcos;
    }
    
    public Date getFechaInicioAlquiler() {
        return fechaInicioAlquiler;
    }

    public void setFechaInicioAlquiler(Date fechaInicioAlquiler) {
        this.fechaInicioAlquiler = fechaInicioAlquiler;
    }

    public Date getFechaFinAlquiler() {
        return fechaFinAlquiler;
    }

    public void setFechaFinAlquiler(Date fechaFinAlquiler) {
        this.fechaFinAlquiler = fechaFinAlquiler;
    }


    public int calcularDiasDeAlquiler() {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        Period periodo = Period.between( LocalDate.parse(formato.format((fechaFinAlquiler)), DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now());
        return Math.abs((int)periodo.getDays());

      
        //return (int) ((fechaFinAlquiler.getTime() - fechaInicioAlquiler.getTime()) / 86400000);
    
    }
    public double precioFinal() {
        
//        double salida = 0;
//        for (Barco barco : barcos) {
//               salida += (barco.eslora*10)*((int) ((fechaFinAlquiler.getTime() - fechaInicioAlquiler.getTime()) / 86400000));
//          }
//        return salida;
        return barcos.stream().map((barco) -> (barco.eslora*10)*((int) ((fechaFinAlquiler.getTime() - fechaInicioAlquiler.getTime()) / 86400000))).reduce(0.0, (accumulator, _item) -> accumulator + _item);
    }

    public ArrayList<Integer> listaAmarres() {
        ArrayList<Integer> amarres = new ArrayList();
        amarres.add(1);
        amarres.add(2);
        amarres.add(3);
        amarres.add(4);
        amarres.add(5);
        amarres.add(6);
        amarres.add(7);
        amarres.add(8);
        amarres.add(9);
        amarres.add(10);
        return amarres;
    }

    public double precioSegunBarco() {
        Scanner read = new Scanner(System.in);
        //ArrayList<Integer> amarres = listaAmarres();
        int suma = 0;
        int opcion = 0;
        String sele = "";
        double precioAlquiler = 0;
        int numAmarre = (int) (Math.random() * 9)+1;
        do {
            System.out.println("A continuacion ingrese los datos del barco");
            System.out.println("Ingrese la matricula");
            String matricula = read.nextLine();
            System.out.println("Ingrese los metros de eslora");
            Double eslora = Double.parseDouble(read.nextLine());
            System.out.println("Ingrese el año de fabricacion");
            String anio = read.nextLine();

            do {
                
                System.out.println("Elija El Tipo De Barco\n" + "1-Barco Comun\n" + "2-Velero\n" + "3-Barco Con Motor\n" + "4-Yate");
                opcion = Integer.parseInt(read.nextLine());
                
                switch (opcion) {
                    case 1:
                        barcos.add(new Barco(matricula, eslora, anio,numAmarre));
                        precioAlquiler =  (eslora*10)*calcularDiasDeAlquiler();
                        break;
                    case 2:
                        System.out.println("¿Cuantos mástiles tiene?");
                        int mastiles = Integer.parseInt(read.nextLine());
                        precioAlquiler =  (eslora*10)*calcularDiasDeAlquiler() + mastiles;
                        barcos.add(new Velero(matricula, eslora, anio, numAmarre,mastiles));
                        break;
                    case 3:

                        System.out.println("¿Qué potencia en CV posee?");
                        int potenciaCV = Integer.parseInt(read.nextLine());
                        precioAlquiler =  (eslora*10)*calcularDiasDeAlquiler() + potenciaCV;
                        barcos.add(new BarcoMotor(matricula, eslora, anio,numAmarre, potenciaCV));
                        break;
                    case 4:

                        System.out.println("¿Qué potencia en CV posee?");
                        int potencia = Integer.parseInt(read.nextLine());
                        System.out.println("¿Cuantos camarotes?");
                        int camarotes = Integer.parseInt(read.nextLine());
                        precioAlquiler =  (eslora*10)*calcularDiasDeAlquiler() + potencia+camarotes;
                        barcos.add(new Yate(matricula, eslora, anio,numAmarre, potencia, camarotes));
                        break;
                    default:
                        System.out.println("no se conoce la opción");
                        break;
                }
            } while (opcion > 5);

            System.out.println("¿Desea agregar alguna embaracacion mas?");
            sele = read.nextLine();
            suma += precioAlquiler;
            precioAlquiler = 0;
        } while (!(sele.equalsIgnoreCase("no")));
        return suma;
    }

}
