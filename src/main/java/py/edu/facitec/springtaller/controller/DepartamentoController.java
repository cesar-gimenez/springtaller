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

import py.edu.facitec.springtaller.dao.DepartamentoDAO;
import py.edu.facitec.springtaller.model.Departamento;

public class DepartamentoController {
	
	@Autowired
	private DepartamentoDAO departamentoDAO;
	
	//registrar
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> registrar(@RequestBody Departamento departamento){
		
		
		departamentoDAO.guardar(departamento, departamento.getId());
		
		return new ResponseEntity<>(departamento, HttpStatus.OK);
	}
	
	
	//lista
	@RequestMapping (method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Departamento>> buscarTodos(){
		
		List<Departamento> departamentos = departamentoDAO.buscarTodo();
		
		return new ResponseEntity<List<Departamento>>(departamentos, HttpStatus.OK);
	}
	
	
	//buscar por id
	@RequestMapping(method=RequestMethod.GET, value="{/id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> buscarPorID(@PathVariable Long id){
		
		Departamento departamentoBuscado= departamentoDAO.buscar(id);
		
		return new ResponseEntity<Departamento>(departamentoBuscado, HttpStatus.OK);
	}

	
	//eliminar
	
	@RequestMapping(method=RequestMethod.DELETE, value="{/id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> eliminar(@PathVariable Long id){
		
		Departamento departamentoAEliminar=departamentoDAO.buscar(id);
		
		if(departamentoAEliminar==null){
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		departamentoDAO.eliminar(departamentoAEliminar);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}
