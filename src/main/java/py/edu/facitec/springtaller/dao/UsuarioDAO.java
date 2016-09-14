package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;

import py.edu.facitec.springtaller.model.Usuario;

public class UsuarioDAO extends DAOGenerico<Usuario> {
	
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
