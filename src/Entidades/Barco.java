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
public class Barco {

    protected String matricula;

    protected Double eslora;

    protected String anio;

    protected Double modulo;

    protected Integer amarre;

    public Barco(String matricula, Double eslora, String anio, Integer amarre) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anio = anio;
        this.amarre = amarre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getEslora() {
        return eslora;
    }

    public void setEslora(Double eslora) {
        this.eslora = eslora;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public double getModulo() {
        return eslora * 10;
    }

    public Integer getAmarre() {
        return amarre;
    }

    public void setAmarre(Integer amarre) {
        this.amarre = amarre;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula.toUpperCase() + "\nEslora: " + eslora + "mts" + "\nAño de Fabricacion: " + anio + "\nAmarre: " + amarre + "\n";
    }

}
