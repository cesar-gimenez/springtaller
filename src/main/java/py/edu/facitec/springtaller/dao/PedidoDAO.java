package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;

import py.edu.facitec.springtaller.dao.DAOGenerico;
import py.edu.facitec.springtaller.model.Pedido;

public class PedidoDAO extends DAOGenerico<Pedido>{
	
	private EntityManager em;
	
	public PedidoDAO() {
	
		super(Pedido.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	
	
	

}
