package mx.uv.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.productos.RegistrarProductoRequest;
import https.t4is_uv_mx.productos.RegistrarProductoResponse;
import https.t4is_uv_mx.productos.BuscarProductoRequest;
import https.t4is_uv_mx.productos.BuscarProductoResponse;

@Endpoint
public class EndPoint {

    @Autowired
    private IProducto iProducto;

    @PayloadRoot(localPart = "RegistrarProductoRequest", namespace = "https://t4is.uv.mx/productos")
    @ResponsePayload
    public RegistrarProductoResponse Registrar(@RequestPayload RegistrarProductoRequest peticion){
        Producto producto = new Producto();
        producto.setIdProducto(peticion.getId());
        producto.setNombre(peticion.getNombre());
        producto.setMarca(peticion.getMarca());
        producto.setPrecio(peticion.getPrecio());
        producto.setCantidad(peticion.getCantidad());
        producto.setLicoreria_asignada(peticion.getLicoreriaAsignada());

        iProducto.save(producto);

        RegistrarProductoResponse respuesta = new RegistrarProductoResponse();
        respuesta.setResultado("El producto "+ producto.getNombre()+ " ha sido registrado");
        return respuesta;
    }


    @PayloadRoot(localPart = "BuscarProductoRequest", namespace = "https://t4is.uv.mx/productos")
    @ResponsePayload
    public BuscarProductoResponse Buscar(@RequestPayload BuscarProductoRequest peticion){
        BuscarProductoResponse respuesta = new BuscarProductoResponse();
        for (Producto producto : iProducto.findAll()){
            if(producto.getNombre().equals(peticion.getNombre())){
                respuesta.setId(producto.getIdProducto());
                respuesta.setNombre(producto.getNombre());
                respuesta.setMarca(producto.getMarca());
                respuesta.setPrecio(producto.getPrecio());
                respuesta.setCantidad(producto.getCantidad());
                respuesta.setLicoreriaAsignada(producto.getLicoreria_asignada());

            }else{
                respuesta.setNombre("El producto no ha sido econtrado");
            }
        }
                
        return respuesta;
    }
}
