package mx.unam.aragon.ico.te.Planetas.del.sistema.solar.modelos;

import java.util.Objects;

public class Planeta {

    private Integer id;
    private String nombre;           // Nombre del planeta (ej. Tierra, Marte)
    private double diametro;         // Diámetro en km
    private double masa;             // Masa en kg o múltiplos de la masa terrestre
    private double distanciaAlSol;   // Distancia media al Sol en millones de km
    private int cantidadLunas;       // Número de lunas conocidas
    private boolean tieneAnillos;    // Si el planeta tiene anillos (true/false
    private String galaxia;          // Nombre de la galaxia o sistema
    private String imagen;

    public Planeta() {
    }

    public Planeta(Integer id, String nombre, double diametro, double masa, double distanciaAlSol, int cantidadLunas, boolean tieneAnillos, String galaxia, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.diametro = diametro;
        this.masa = masa;
        this.distanciaAlSol = distanciaAlSol;
        this.cantidadLunas = cantidadLunas;
        this.tieneAnillos = tieneAnillos;
        this.galaxia = galaxia;
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getDistanciaAlSol() {
        return distanciaAlSol;
    }

    public void setDistanciaAlSol(double distanciaAlSol) {
        this.distanciaAlSol = distanciaAlSol;
    }

    public int getCantidadLunas() {
        return cantidadLunas;
    }

    public void setCantidadLunas(int cantidadLunas) {
        this.cantidadLunas = cantidadLunas;
    }

    public boolean isTieneAnillos() {
        return tieneAnillos;
    }

    public void setTieneAnillos(boolean tieneAnillos) {
        this.tieneAnillos = tieneAnillos;
    }

    public String getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(String galaxia) {
        this.galaxia = galaxia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Planeta planeta = (Planeta) o;
        return Double.compare(diametro, planeta.diametro) == 0 && Double.compare(masa, planeta.masa) == 0 && Double.compare(distanciaAlSol, planeta.distanciaAlSol) == 0 && cantidadLunas == planeta.cantidadLunas && tieneAnillos == planeta.tieneAnillos && Objects.equals(id, planeta.id) && Objects.equals(nombre, planeta.nombre) && Objects.equals(galaxia, planeta.galaxia) && Objects.equals(imagen, planeta.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, diametro, masa, distanciaAlSol, cantidadLunas, tieneAnillos, galaxia, imagen);
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", diametro=" + diametro +
                ", masa=" + masa +
                ", distanciaAlSol=" + distanciaAlSol +
                ", cantidadLunas=" + cantidadLunas +
                ", tieneAnillos=" + tieneAnillos +
                ", galaxia='" + galaxia + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
