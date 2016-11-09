package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Usuario;


@Repository
public class UsuarioDAO extends DAOGenerico<Usuario> {
	
	@PersistenceContext
	private EntityManager em;
	
	public UsuarioDAO() {
	
		super(Usuario.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
