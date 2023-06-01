package mx.uv.backendlicoreria.exception;

public class LicoreriaNotFoundException extends RuntimeException{

    public LicoreriaNotFoundException( int id){
        super("No se econtro la licoreria "+ id);
    }
    
}
