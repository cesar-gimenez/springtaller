package py.edu.facitec.springtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.edu.facitec.springtaller.dao.ClienteDAO;
import py.edu.facitec.springtaller.model.Cliente;

@Transactional
@Controller
public class ClienteController {
		
	
	@Autowired
		private ClienteDAO clienteDao;
		
	
	@RequestMapping("/clientes")
		public String save(Cliente cliente){
			
			clienteDao.guardar(cliente, cliente.getId());
			
			System.out.println("Registrando el cliente: "+cliente);   
			
			
			return "/clientes/ok";
		}
		
		 @RequestMapping("/clientes/formulario") 
		 public String formulario(){      
			 
			 return "/clientes/formulario";  
		} 
}
