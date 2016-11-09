package py.edu.facitec.springtaller.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import py.edu.facitec.springtaller.model.general.General;

@Entity
public class Producto extends General {
	
	
	
	//aplicacion de restricciones
	@Column(length=100, nullable=false, unique=true)
	private String descripcion;
	private Date fechaVencimiento;
	private double precio;
	private int cantidad;
	
	
	@OneToMany(mappedBy="producto")
	private List<ItemPedido> itemPedidos;
	
	
	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + ", fechaVencimiento=" + fechaVencimiento
				+ ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}







	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}



	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


}
