package logico;

import java.util.Date;

public class OrdenCompra {
	
	private String codigo;
	private Producto producto;
	private int cantidad;
	private String distribuidor;
	private float precioTotal;
	private Date fechaSolicitud;
	private boolean procesada;
	public static int numOrdenCompra = 1;
	
	public OrdenCompra(String codigo, Producto producto) {
		super();
		this.codigo = codigo;
		this.producto = producto;
		this.fechaSolicitud = new Date();
		this.procesada = false;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal * cantidad;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public boolean isProcesada() {
		return procesada;
	}

	public void setProcesada(boolean procesada) {
		this.procesada = procesada;
	}
		
}
