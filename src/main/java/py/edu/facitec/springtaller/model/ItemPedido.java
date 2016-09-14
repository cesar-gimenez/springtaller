package py.edu.facitec.springtaller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	
	@Id
	@GeneratedValue
	private long id;
	private int cantidadProducto;
	private double subTotal;
	
	@ManyToOne
	private Pedido pedido;	
	
	@ManyToOne
	private Producto producto;
	
	
	@Override
	public String toString() {
		return "itemPedido [id=" + id + ", cantidadProducto=" + cantidadProducto + ", subTotal=" + subTotal + "]";
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public int getCantidadProducto() {
		return cantidadProducto;
	}




	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}




	public double getSubTotal() {
		return subTotal;
	}




	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	


}
