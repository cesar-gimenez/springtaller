package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Producto;


@Repository

public class ProductoDAO extends DAOGenerico<Producto>{

	@PersistenceContext
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
