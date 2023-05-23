package uv.mx.tienda;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.licorerias.RegistrarLicoreriaRequest;
import https.t4is_uv_mx.licorerias.RegistrarLicoreriaResponse;




@Endpoint
public class EndPoint {

    @Autowired
    private ILicoreria iLicoreria;

    @PayloadRoot(localPart = "RegistrarLicoreriaRequest",namespace = "https://t4is.uv.mx/licorerias")
    @ResponsePayload
    public RegistrarLicoreriaResponse Registrar(@RequestPayload RegistrarLicoreriaRequest peticion) {
        Licoreria licoreria = new Licoreria();
        licoreria.setIdTienda(peticion.getId());
        licoreria.setNombre(peticion.getNombre());
        licoreria.setDireccion(peticion.getDireccion());

        iLicoreria.save(licoreria);

        RegistrarLicoreriaResponse respuesta = new RegistrarLicoreriaResponse();
        respuesta.setResultado("La licoreria "+ licoreria.getNombre()+ " ha sido registrada");
        return respuesta;
    }
    
}
