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
public final class Velero extends Barco {

    private final Integer mastiles;

    public Velero(String matricula, Double eslora, String anio, Integer amarre, Integer mastiles) {
        super(matricula, eslora, anio, amarre);
        this.mastiles = mastiles;
    }

    @Override
    public double getModulo() {
        return super.getModulo() + mastiles;
    }

}
