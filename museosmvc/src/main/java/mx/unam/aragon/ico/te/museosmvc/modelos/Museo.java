package mx.unam.aragon.ico.te.museosmvc.modelos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity //mapeamos esta clase a una tabla en la base de datos
//@Table(name = "museos")
//@Column- indica si son únicos, nulos o no, PK, o manda código sql para definir la columna
public class Museo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generacion de clave primaria, autoincrementable-identity
    private Integer id;

    private String nombre;
    private int fundacion;
    private String ubicacion;
    private String tipo;
    private int precio;
    private String imagen;


    public Museo() {
    }

    public Museo(int id, String nombre, int fundacion, String ubicacion, String tipo, int precio, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.fundacion = fundacion;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFundacion() {
        return fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
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
        Museo museo = (Museo) o;
        return id == museo.id && fundacion == museo.fundacion && precio == museo.precio && Objects.equals(nombre, museo.nombre) && Objects.equals(ubicacion, museo.ubicacion) && Objects.equals(tipo, museo.tipo) && Objects.equals(imagen, museo.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, fundacion, ubicacion, tipo, precio, imagen);
    }

    @Override
    public String toString() {
        return "Museo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fundacion=" + fundacion +
                ", ubicacion='" + ubicacion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
