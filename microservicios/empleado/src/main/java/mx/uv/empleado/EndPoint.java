package mx.uv.empleado;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.empleados.RegistrarEmpleadoRequest;
import https.t4is_uv_mx.empleados.RegistrarEmpleadoResponse;
import https.t4is_uv_mx.empleados.BuscarEmpleadoResponse;
import https.t4is_uv_mx.empleados.BuscarEmpleadoRequest;
import https.t4is_uv_mx.empleados.BorrarEmpleadoRequest;
import https.t4is_uv_mx.empleados.BorrarEmpleadoResponse;

@Endpoint
public class EndPoint {


    @Autowired
    private IEmpleado iEmpleado;  

    @PayloadRoot(localPart = "RegistrarEmpleadoRequest", namespace = "https://t4is.uv.mx/empleados")
    @ResponsePayload
    public RegistrarEmpleadoResponse Registrar(@RequestPayload RegistrarEmpleadoRequest peticion) {
        Empleado empleado = new Empleado();
        empleado.setNumTrabajador(peticion.getNumeroTrabajador());
        empleado.setNombre(peticion.getNombre());
        empleado.setApellidoP(peticion.getApellidoP());
        empleado.setApellidoM(peticion.getApellidoM());
        empleado.setLicoreria_asignada(peticion.getLicoreriaAsignada());
        

        iEmpleado.save(empleado);

        RegistrarEmpleadoResponse respuesta = new RegistrarEmpleadoResponse();
        respuesta.setResultado("El empleado " + empleado.getNombre() + " " + empleado.getApellidoP()
                + " ha sido registrado exitosamente");
        return respuesta;
    }
     
    @PayloadRoot(localPart = "BuscarEmpleadoRequest", namespace = "https://t4is.uv.mx/empleados")
    @ResponsePayload
    public BuscarEmpleadoResponse Buscar(@RequestPayload BuscarEmpleadoRequest peticion) {
        BuscarEmpleadoResponse respuesta = new BuscarEmpleadoResponse();
        for (Empleado empleado : iEmpleado.findAll()) {
            if (empleado.getNombre().equals(peticion.getNombre())) {
                respuesta.setNombre(empleado.getNombre());
                respuesta.setApellidoP(empleado.getApellidoP());
                respuesta.setApellidoM(empleado.getApellidoM());
                respuesta.setNumeroTrabajador(empleado.getNumTrabajador());
                break;
            }else{
                respuesta.setNombre("No econtrado");
            }
        }
        return respuesta;
    } 

    @PayloadRoot(localPart = "BorrarEmpleadoRequest", namespace = "https://t4is.uv.mx/empleados")
    @ResponsePayload
    public BorrarEmpleadoResponse BorrarEmpleado(@RequestPayload BorrarEmpleadoRequest peticion) {
        BorrarEmpleadoResponse respuesta = new BorrarEmpleadoResponse();

        String nombreEmpleado = peticion.getNombre();

        for (Empleado empleado : iEmpleado.findAll()){
            if(nombreEmpleado.equals(empleado.getNombre())){
                iEmpleado.delete(empleado);
                respuesta.setResultado("El empleado: "+empleado.getNombre()+" ha sido eliminado");
                break;
            }else{
                respuesta.setResultado("Usuario no econtrado");
            }


        }
        return respuesta;
    }

}
