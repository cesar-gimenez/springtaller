package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;

import py.edu.facitec.springtaller.model.Departamento;

public class DepartamentoDAO extends DAOGenerico<Departamento>{

	
		private EntityManager em;
		
		public DepartamentoDAO() {
			// TODO Auto-generated constructor stub
			super(Departamento.class);
		}

		@Override
		protected EntityManager getEntityManager() {
			// TODO Auto-generated method stub
			return em;
		}
		
	
}
