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

import py.edu.facitec.springtaller.dao.GerenteDAO;
import py.edu.facitec.springtaller.model.Gerente;

public class GerenteController {
	
	@Autowired
	private GerenteDAO gerenteDAO;
	
	//registrar
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> registrar(@RequestBody Gerente gerente){
		
		gerenteDAO.guardar(gerente, gerente.getId());
		
		return new ResponseEntity<>(gerente, HttpStatus.OK);
	}

	
	//lista
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Gerente>> buscarTodos(){
		
		List<Gerente> gerentes=gerenteDAO.buscarTodo();
		
		return new ResponseEntity<List<Gerente>>(gerentes, HttpStatus.OK);
	}
	
	
	//buscar por id
	@RequestMapping(method=RequestMethod.GET, value="{/id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> buscarPorID(@PathVariable Integer id){
	
		Gerente gerenteBuscado=gerenteDAO.buscar(id);
		
		return new ResponseEntity<Gerente>(gerenteBuscado, HttpStatus.OK);
	}
	
	
	//eliminar
	@RequestMapping(method=RequestMethod.DELETE, value="{/id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> eliminar(@PathVariable Integer id){
		
		Gerente gerenteAEliminar = gerenteDAO.buscar(id);
		
		if(gerenteAEliminar==null){
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		gerenteDAO.eliminar(gerenteAEliminar);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
