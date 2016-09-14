package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;

import py.edu.facitec.springtaller.model.Producto;

public class ProductoDAO extends DAOGenerico<Producto>{
	
	private EntityManager em;
	
	public ProductoDAO() {
		super(Producto.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	

}
