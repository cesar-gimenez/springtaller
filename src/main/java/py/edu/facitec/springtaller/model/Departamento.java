package py.edu.facitec.springtaller.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue
	private long id;
	private String descripcion;
	
	
	
	//private List<Usuario> ListaUsuarios;
	
	@OneToOne(mappedBy="departamento")
	private Gerente gerente;
	
	@OneToMany(mappedBy="departamento")
	private List<Usuario> usuarios;
	


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	
	
		


}
