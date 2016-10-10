package py.edu.facitec.springtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.springtaller.dao.ClienteDAO;
import py.edu.facitec.springtaller.model.Cliente;

@Transactional
@Controller

//controlador para peticiones res
@RestController
@RequestMapping("/cliente")
public class ClienteController {
		
	//injecta una dependencia
	@Autowired
		private ClienteDAO clienteDao;
		
	//responder a peticiones POST
	@RequestMapping(method=RequestMethod.POST)
	
		//save: vienen los datos del formulario y se pasan a objeto
		//registra un cliente
		public String save(@RequestBody Cliente cliente){
			
			clienteDao.guardar(cliente, cliente.getId());
			
			System.out.println("Registrando el cliente: "+cliente);   
			
			
			return "/clientes/ok";
		}
		
		 @RequestMapping(value="/formulario", method=RequestMethod.GET) 
		 public String formulario(){      
			 
			 return "/clientes/formulario";  
		} 
		
		 //lista de productos
		@RequestMapping(method=RequestMethod.GET) 
		public ModelAndView lista(){
			
			ModelAndView model=new ModelAndView();
			
			//agregamos la lista de clientes al objeto que contendra la vista
			
			model.addObject("cliente", clienteDao.buscarTodo());
			
			return model;
		}
		
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//buscar cliente por id
		@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Cliente> buscarPorID(@PathVariable Integer id){
			
			Cliente clienteBuscado=clienteDao.buscar(id);
			
			return new ResponseEntity<Cliente>(clienteBuscado, HttpStatus.OK);
		}
		
		
		//eliminar cliente
		
		@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
		
		public ResponseEntity<Cliente> eliminar(@PathVariable Integer id){
			
			Cliente clienteAEliminar=clienteDao.buscar(id);
			
			if(clienteAEliminar==null){
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			clienteDao.eliminar(clienteAEliminar);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
			
		}
		
		
		
		 
}
