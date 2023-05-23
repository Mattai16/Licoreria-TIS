package mx.uv.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;






@Controller
@SpringBootApplication
public class ServiceApplication {

	@Autowired
	private IProducto iProducto;
	

	public ServiceApplication(IProducto iProducto) {
		this.iProducto = iProducto;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);


	}

	@RequestMapping("/")
	public ModelAndView menu(){
		return new ModelAndView("main");
	}

	@RequestMapping("/licorerias")
	public ModelAndView menuLicorerias(){
		return new ModelAndView("main");
	}

	@RequestMapping("/empleados")
	public ModelAndView menuEmpleados(){
		return new ModelAndView("main");
	}

    @RequestMapping("/productos")
    public ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        Iterable<Producto> productosIterable = iProducto.findAll();
        productosIterable.forEach(productos::add);
        return productos;
    }

}
