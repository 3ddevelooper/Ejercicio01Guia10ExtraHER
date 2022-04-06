/*
 * Bienvenido, este es un mensaje auto-generado por Damian Dries
 * Damian Dries - JAVA DEV 
 * www.damiandries.com.ar
 */
package Entidades;

/**
 *
 * @author Damian Dries - "www.damiandries.com.ar"
 */
public final class BarcoMotor extends Barco{
   private final Integer potenciaCV;

    public BarcoMotor(String matricula, Double eslora, String anio, Integer amarre,Integer potenciaCV) {
        super(matricula, eslora, anio, amarre);
        this.potenciaCV = potenciaCV;
        
    }

    @Override
    public double getModulo(){
         return super.getModulo()+potenciaCV;
    }
    
}
