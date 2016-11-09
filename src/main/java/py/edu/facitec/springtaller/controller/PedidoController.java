package py.edu.facitec.springtaller.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.springtaller.dao.PedidoDAO;
import py.edu.facitec.springtaller.model.Pedido;

@RestController
@Transactional
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoDAO pedidoDAO;
	
	//registrar
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> registrar(@RequestBody Pedido pedido){
		
		pedidoDAO.guardar(pedido, pedido.getId());
		
		return new ResponseEntity<>(pedido, HttpStatus.OK);
		
	}
	
	
	//lista
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pedido>> buscarTodos(){
		
		List<Pedido> pedidos=pedidoDAO.buscarTodo();
		
		return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
	}
	
	//buscar por id
	@RequestMapping(method=RequestMethod.GET, value="{/id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> buscarPorID(@PathVariable Long id){
		
		Pedido pedidoBuscado=pedidoDAO.buscar(id);
		
		return new ResponseEntity<Pedido>(pedidoBuscado, HttpStatus.OK);
	}
	
	
	
	//eliminar
	@RequestMapping(method=RequestMethod.DELETE, value="{/id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> eliminar(@PathVariable Long id){
		
		Pedido pedidoAEliminar = pedidoDAO.buscar(id);
		
		if(pedidoAEliminar==null){
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		pedidoDAO.eliminar(pedidoAEliminar);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	//para acceder al formulario pedido
	@RequestMapping("/form")	
	public ModelAndView formulario(){
	
		System.out.println("cargando formulario pedido");
		
		return new ModelAndView("/pedidos/form");
		
		}
	
	
}
