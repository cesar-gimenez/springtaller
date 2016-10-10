package py.edu.facitec.springtaller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.facitec.springtaller.dao.ItemPedidoDAO;
import py.edu.facitec.springtaller.model.ItemPedido;

public class ItemPedidoController {
	
	@Autowired
	private ItemPedidoDAO itemPedidoDAO;
	
	
	//registrar
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> registrar(@RequestBody ItemPedido itemPedido){
		
		itemPedidoDAO.guardar(itemPedido, itemPedido.getId());
		
		return new ResponseEntity<>(itemPedido, HttpStatus.OK);
	}
	
	//lista
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemPedido>> buscarTodos(){
		
		List<ItemPedido> itemPedidos=itemPedidoDAO.buscarTodo();
		
		return new ResponseEntity<List<ItemPedido>>(itemPedidos, HttpStatus.OK);
	}
	
	//buscar por id
	@RequestMapping(method=RequestMethod.GET, value="{/id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> buscarPorID(@PathVariable Long id){
		
		ItemPedido itemPedidoBuscado = itemPedidoDAO.buscar(id);
		
		return new ResponseEntity<ItemPedido>(itemPedidoBuscado, HttpStatus.OK);
	}
	
	
	//eliminar
	@RequestMapping(method=RequestMethod.DELETE, value="{/id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> eliminar(@PathVariable Long id){
		
		ItemPedido itemPedidoAEliminar=itemPedidoDAO.buscar(id);
		
		if(itemPedidoAEliminar==null){
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		itemPedidoDAO.eliminar(itemPedidoAEliminar);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
