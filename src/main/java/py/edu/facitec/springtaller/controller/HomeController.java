package py.edu.facitec.springtaller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//para indicar que esta clase interactua con los reques venidos de la web
@Controller
public class HomeController {

	
	
	@RequestMapping("/")
	public String index(){
		
		return "Hello-world";
	}
}
