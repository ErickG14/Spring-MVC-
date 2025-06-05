package mx.unam.aragon.ico.te.videojuegosmvc.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.security.PrivateKey;
import java.util.Objects;

@Entity
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String estudio;
    private String genero;
    private String descripcion;
    private float precio;
    private String imagen;

    public Videojuego() {
    }

    public Videojuego(Integer id, String nombre, String estudio, String genero, String descripcion, float precio, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.estudio = estudio;
        this.genero = genero;
        this.descripcion = descripcion;
        this.precio = precio;
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

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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
        Videojuego videojuego = (Videojuego) o;
        return Float.compare(precio, videojuego.precio) == 0 && Objects.equals(id, videojuego.id) && Objects.equals(nombre, videojuego.nombre) && Objects.equals(estudio, videojuego.estudio) && Objects.equals(genero, videojuego.genero) && Objects.equals(descripcion, videojuego.descripcion) && Objects.equals(imagen, videojuego.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, estudio, genero, descripcion, precio, imagen);
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estudio='" + estudio + '\'' +
                ", genero='" + genero + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}

