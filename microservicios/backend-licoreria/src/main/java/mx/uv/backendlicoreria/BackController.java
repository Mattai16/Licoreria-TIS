package mx.uv.backendlicoreria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:3000")
public class BackController {


    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private LicoreriaRepositorio licoreriaRepositorio;


    @PostMapping("/empleado")
    Empleado newEmpleado(@RequestBody Empleado newEmpleado){
        return empleadoRepositorio.save(newEmpleado);
    }

    @GetMapping("/empleados")
    List<Empleado> obtenerEmpleados(){
        return empleadoRepositorio.findAll();
    }

    @PostMapping("/producto")
    Producto newProducto (@RequestBody Producto newProducto){
        return productoRepositorio.save(newProducto);
    }

    @GetMapping("/productos")
    List<Producto> obtenerProductos(){
        return productoRepositorio.findAll();
    }

    @PostMapping("/licoreria")
    Licoreria newLicoreria (@RequestBody Licoreria newLicoreria){
        return licoreriaRepositorio.save(newLicoreria);
    }


    @GetMapping("/licorerias")
    List<Licoreria> obtenerLicorerias(){
        return licoreriaRepositorio.findAll();
    }


    
}
