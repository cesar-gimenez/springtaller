package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;

import py.edu.facitec.springtaller.model.ItemPedido;

public class ItemPedidoDAO extends DAOGenerico<ItemPedido>{
	
	
	private EntityManager em;
	
	public ItemPedidoDAO() {
	
		super(ItemPedido.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
}
