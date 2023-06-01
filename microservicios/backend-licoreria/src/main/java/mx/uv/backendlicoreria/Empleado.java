package mx.uv.backendlicoreria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "empleados")
public class Empleado {
    


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "num_trabajador")
    private int numTrabajador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidoP")
    private String apellidoP;

    @Column(name = "apellidoM")
    private String apellidoM;

    @Column(name = "licoreria_asignada")
    private int licoreria_asignada;


    public Empleado(){
        
    }
        
    public Empleado(int numTrabajador, String nombre, String apellidoP, String apellidoM, int licoreria_asignada) {
        this.numTrabajador = numTrabajador;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.licoreria_asignada = licoreria_asignada;
    }


    public int getNumTrabajador() {
        return numTrabajador;
    }

    public void setNumTrabajador(int numTrabajador) {
        this.numTrabajador = numTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getLicoreria_asignada() {
        return licoreria_asignada;
    }

    public void setLicoreria_asignada(int licoreria_asignada) {
        this.licoreria_asignada = licoreria_asignada;
    }

}