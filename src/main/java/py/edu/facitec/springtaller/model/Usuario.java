package py.edu.facitec.springtaller.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	private String login;
	private String name;
	private String password;
	
	@OneToMany(mappedBy="usuario")
	private List<Pedido> pedidos;
	
	@ManyToOne
	private Departamento departamento;
	
	
	
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", name=" + name + ", password=" + password + "]";
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	
	
	


}
