package mx.uv.backendlicoreria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.uv.backendlicoreria.exception.EmpleadoNotFoundException;
import mx.uv.backendlicoreria.exception.LicoreriaNotFoundException;
import mx.uv.backendlicoreria.exception.ProductoNotFoundException;


@RestController
@CrossOrigin("http://localhost:3000")
public class BackController {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private LicoreriaRepositorio licoreriaRepositorio;


    //Metodos para las rutas de empleado

    @PostMapping("/empleado")
    Empleado newEmpleado(@RequestBody Empleado newEmpleado) {
        return empleadoRepositorio.save(newEmpleado);
    }

    @GetMapping("/empleado/{id}")
    Empleado getEmpleadoById(@PathVariable Integer id) {
        return empleadoRepositorio.findById(id)
                .orElseThrow(() -> new EmpleadoNotFoundException(id));
    }

    @GetMapping("/empleados")
    List<Empleado> obtenerEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @PutMapping("/empleado/{id}")
    Empleado updateEmpleado(@RequestBody Empleado newEmpleado, @PathVariable Integer id) {
        return empleadoRepositorio.findById(id)
                .map(empleado -> {
                    empleado.setNombre(newEmpleado.getNombre());
                    empleado.setApellidoP(newEmpleado.getApellidoP());
                    empleado.setApellidoM(newEmpleado.getApellidoM());
                    empleado.setLicoreria_asignada(newEmpleado.getLicoreria_asignada());
                    return empleadoRepositorio.save(empleado);

                }).orElseThrow(() -> new EmpleadoNotFoundException(id));
    }

    @DeleteMapping("/empleado/{id}")
    String deleteEmpleado(@PathVariable int id) {
        if (!empleadoRepositorio.existsById(id)) {
            throw new EmpleadoNotFoundException(id);
        }

        empleadoRepositorio.deleteById(id);

        return "El empleado " + id + " ha sido eliminado";
    }


    //____________________________________________________________________

    //Metodos para las rutas de producto


    @PostMapping("/producto")
    Producto newProducto(@RequestBody Producto newProducto) {
        return productoRepositorio.save(newProducto);
    }

    @GetMapping("/productos")
    List<Producto> obtenerProductos() {
        return productoRepositorio.findAll();
    }

    @GetMapping("/producto/{id}")
    Producto getProductById(@PathVariable int id){
        return productoRepositorio.findById(id)
        .orElseThrow(()-> new ProductoNotFoundException(id));
    }

    @PutMapping("/producto/{id}")
    Producto updateProducto(@RequestBody Producto newProducto, @PathVariable int id){
        return productoRepositorio.findById(id)
        .map(producto -> {
            producto.setNombre(newProducto.getNombre());
            producto.setMarca(newProducto.getMarca());
            producto.setPrecio(newProducto.getPrecio());
            producto.setCantidad(newProducto.getCantidad());
            producto.setLicoreria_asignada(newProducto.getLicoreria_asignada());
            return productoRepositorio.save(producto);
        }).orElseThrow(() -> new ProductoNotFoundException(id));
    }

    @DeleteMapping("/producto/{id}")
    String deleteProducto (@PathVariable int id){
        if(!productoRepositorio.existsById(id)){
            throw new ProductoNotFoundException(id);
        }

        productoRepositorio.deleteById(id);

        return "La licoreria con id "+id+" ha sido eliminada";
    }


    //____________________________________________________________________

    //Metodos para las rutas de producto


    @PostMapping("/licoreria")
    Licoreria newLicoreria(@RequestBody Licoreria newLicoreria) {
        return licoreriaRepositorio.save(newLicoreria);
    }

    @GetMapping("/licorerias")
    List<Licoreria> obtenerLicorerias() {
        return licoreriaRepositorio.findAll();
    }

    @GetMapping("/licoreria/{id}")
    Licoreria getLicoreriaById(@PathVariable int id){
        return licoreriaRepositorio.findById(id)
        .orElseThrow(()-> new LicoreriaNotFoundException(id));
    }

    @PutMapping("/licoreria/{id}")
    Licoreria updateLicoreria (@RequestBody Licoreria newLicoreria, @PathVariable int id){
        return licoreriaRepositorio.findById(id)
        .map(licoreria ->{
            licoreria.setNombre(newLicoreria.getNombre());
            licoreria.setDireccion(newLicoreria.getDireccion());
            return licoreriaRepositorio.save(licoreria);
        }).orElseThrow(() -> new LicoreriaNotFoundException(id));
    }

    @DeleteMapping("/licoreria/{id}")
    String deleteLicoreria (@PathVariable int id){
        if(!licoreriaRepositorio.existsById(id)){
            throw new LicoreriaNotFoundException(id);
        }

        licoreriaRepositorio.deleteById(id);

        return "La licoreria con id "+id+" ha sido eliminada";
    }

}
