package py.edu.facitec.springtaller.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue
	private long id;
	private String descripcion;
	private Date fechaVencimiento;
	private double precio;
	private int cantidad;
	
	
	@OneToMany(mappedBy="producto")
	private List<ItemPedido> itemPedidos;
	
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", fechaVencimiento=" + fechaVencimiento
				+ ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}



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
