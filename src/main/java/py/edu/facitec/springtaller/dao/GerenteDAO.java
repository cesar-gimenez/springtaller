package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;

import py.edu.facitec.springtaller.model.Gerente;

public class GerenteDAO extends DAOGenerico<Gerente>{
	
	private EntityManager em;
	
	public GerenteDAO() {
	
		
		super(Gerente.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
