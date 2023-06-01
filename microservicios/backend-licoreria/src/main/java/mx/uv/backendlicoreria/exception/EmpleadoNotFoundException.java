package mx.uv.backendlicoreria.exception;

public class EmpleadoNotFoundException extends RuntimeException{
    public EmpleadoNotFoundException(int id){
        super("No se pudo encontrar al empleado "+ id);
    }
    
}
