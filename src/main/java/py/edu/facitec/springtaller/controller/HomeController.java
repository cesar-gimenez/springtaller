package py.edu.facitec.springtaller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//para indicar que esta clase recibira requisiciones venidos de un cliente, en este caso de un navegador web
@Controller
public class HomeController {

	
	//para responder a cierta URL
	@RequestMapping("/")
	public String index(){
		
		
		//operacion a ser realizada
		System.out.println("Cargando pagina");
		return "Hello-world";
	}
}
