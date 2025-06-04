package test.java.unam.aragon.Carrosmvc.Modelo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Autos")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marca;
    private String modelo;
    private int año;
    private String version;
    private String color;
    private String imagen;

    public Carro() {
    }

    public Carro(int id, String marca, String modelo, int año, String version, String color, String imagen) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.version = version;
        this.color = color;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        Carro carro = (Carro) o;
        return id == carro.id && año == carro.año && Objects.equals(marca, carro.marca) && Objects.equals(modelo, carro.modelo) && Objects.equals(version, carro.version) && Objects.equals(color, carro.color) && Objects.equals(imagen, carro.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, año, version, color, imagen);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", version='" + version + '\'' +
                ", color='" + color + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}


