package mx.uv.backendlicoreria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @Column(name = "id_producto")

    private int idProducto;
    @Column(name = "nombre")

    private String nombre;
    @Column(name = "marca")

    private String marca;
    @Column(name = "precio")
    
    private double precio;
    @Column(name = "cantidad")
    
    private int cantidad;
    @Column(name = "licoreria_asignada")
    private String licoreria_asignada;


    public Producto(int idProducto, String nombre, String marca, double precio, int cantidad,
            String licoreria_asignada) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
        this.licoreria_asignada = licoreria_asignada;
    }


    public Producto(){
        
    }


    public int getIdProducto() {
        return idProducto;
    }


    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public String getLicoreria_asignada() {
        return licoreria_asignada;
    }


    public void setLicoreria_asignada(String licoreria_asignada) {
        this.licoreria_asignada = licoreria_asignada;
    }

    
}