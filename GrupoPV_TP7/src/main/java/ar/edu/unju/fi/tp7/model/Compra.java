package ar.edu.unju.fi.tp7.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "COMPRAS")
@Component
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPRA")
	private long id;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_CODIGO")
	private Producto producto;
	
	@Column(name = "CANTIDAD")
	private int cantidad;
	
	@Column(name = "TOTAL")
	private double total;
	
	public Compra() {
	}

	public Compra(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		double total=this.producto.getPrecio()*this.cantidad;
		
		
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	
}
