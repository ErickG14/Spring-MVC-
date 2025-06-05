package mx.unam.aragon.ico.te.pinturasMVC.Modelo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Pinturas")
public class Pintura {
    private Integer id;
    private String artista;

    private String nombre;
    private int year;
    private String imagen;

    public Pintura() {
    }

    public Pintura(Integer id, String artista, String nombre, int year, String imagen) {
        this.id = id;
        this.artista = artista;
        this.nombre = nombre;
        this.year = year;
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Pintura{" +
                "id=" + id +
                ", artista='" + artista + '\'' +
                ", nombre='" + nombre + '\'' +
                ", year=" + year +
                ", imagen='" + imagen + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artista, nombre, year, imagen);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pintura pintura = (Pintura) o;
        return year == pintura.year && Objects.equals(id, pintura.id) && Objects.equals(artista, pintura.artista) && Objects.equals(nombre, pintura.nombre) && Objects.equals(imagen, pintura.imagen);
    }
}
