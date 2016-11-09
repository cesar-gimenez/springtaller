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

import py.edu.facitec.springtaller.dao.UsuarioDAO;
import py.edu.facitec.springtaller.model.Usuario;

@RestController
@Transactional
@RequestMapping("/usuario")

public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	//registrar
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){
		
		usuarioDAO.guardar(usuario, usuario.getLogin());
		
		return new ResponseEntity<>(usuario, HttpStatus.OK);
		
	}
	
	
	//lista
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> buscarTodos(){
		
		List<Usuario> usuarios= usuarioDAO.buscarTodo();
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	//busca por id
	@RequestMapping(method=RequestMethod.GET, value="{/id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarPorID(@PathVariable Integer id){
		
		Usuario usuarioBuscado=usuarioDAO.buscar(id);
		
		return new ResponseEntity<Usuario>(usuarioBuscado, HttpStatus.OK);
	
	}
	
	
	//eliminar
	@RequestMapping(method=RequestMethod.DELETE, value="{/id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> eliminar(@PathVariable Integer id){
		
		Usuario usuarioAEliminar=usuarioDAO.buscar(id);
		
		if(usuarioAEliminar==null){
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		usuarioDAO.eliminar(usuarioAEliminar);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//para acceder al formulario producto
		@RequestMapping("/form")	
		public ModelAndView formulario(){
		
			System.out.println("cargando formulario usuario");
			
			return new ModelAndView("/usuarios/form");
			
			}
	
}	