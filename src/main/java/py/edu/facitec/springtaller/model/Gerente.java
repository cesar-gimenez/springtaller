package py.edu.facitec.springtaller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Gerente {

	
	@Id
	@GeneratedValue
	private int id;
	private String ci;
	private String nombre;
	
	@OneToOne
	private Departamento departamento;
	
	@Override
	public String toString() {
		return "Gerente [id=" + id + ", ci=" + ci + ", nombre=" + nombre + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCi() {
		return ci;
	}


	public void setCi(String ci) {
		this.ci = ci;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
