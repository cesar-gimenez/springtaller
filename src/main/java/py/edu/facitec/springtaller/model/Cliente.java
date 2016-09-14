package py.edu.facitec.springtaller.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	private String correo;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;
	
	
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", correo=" + correo + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	
	
	
	

}
