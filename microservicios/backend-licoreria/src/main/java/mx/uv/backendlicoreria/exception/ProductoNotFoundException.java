package mx.uv.backendlicoreria.exception;

public class ProductoNotFoundException extends RuntimeException {
    public ProductoNotFoundException (int id ){
        super("El producto "+ id + " no fue encontrado");
    }
    
}
