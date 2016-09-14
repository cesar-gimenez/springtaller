package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Cliente;

//Clase encargada de la manipulacion de datos, posibilita posteriormente utilizar
//la anotacion Autowired
@Repository
public class ClienteDAO extends DAOGenerico<Cliente>{
	
	//gestiona el entity manager
	@PersistenceContext
	private EntityManager manager;
	
	
	public ClienteDAO() {
	
		super(Cliente.class);
	}	
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
		
	
}

//	public void save(Cliente cliente){	
//		****metodo para insertar los datos (persist)****
//		manager.persist(cliente);
//}