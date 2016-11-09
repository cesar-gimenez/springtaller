package py.edu.facitec.springtaller.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import py.edu.facitec.springtaller.model.general.General;
@Entity
public class Pedido extends General{
	

	//aplicacion de restricciones
	@Column(length=100, nullable=false, unique=true)
	private Date fechaToma;
	private Date fechaEntrega;
	private double total;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Usuario usuario;
	
	//lista que quiero visualizar
	@JsonManagedReference
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itempedidos;
	
	
	
	@Override
	public String toString() {
		return "Pedido [fechaToma=" + fechaToma + ", fechaEntrega=" + fechaEntrega + ", total="
				+ total + "]";
	}


	

	public Date getFechaToma() {
		return fechaToma;
	}


	public void setFechaToma(Date fechaToma) {
		this.fechaToma = fechaToma;
	}


	public Date getFechaEntrega() {
		return fechaEntrega;
	}


	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	


}
