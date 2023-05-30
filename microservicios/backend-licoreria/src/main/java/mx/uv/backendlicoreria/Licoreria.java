package mx.uv.backendlicoreria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="licoreriasR")
public class Licoreria {
    

    @Id
    @Column(name = "id_tienda")
    private int idTienda;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    public Licoreria(){

    }

    
    public Licoreria(String nombre, String direccion, int idTienda) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.idTienda = idTienda;
    }

    public int getIdTienda(){
        return idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdTienda(int idTienda){
        this.idTienda = idTienda;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
 
    }
}