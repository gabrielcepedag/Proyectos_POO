package logico;

import java.io.Serializable;

public abstract class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String numSerie;
	protected int cantidad;
	protected float precio;
	protected String marca;
	protected int dispMin;
	protected int dispMax;
	
	public Producto(String numSerie, int cantidad, float precio, String marca, int dispMin, int dispMax) {
		super();
		this.numSerie = numSerie;
		this.cantidad = cantidad;
		this.precio = precio;
		this.marca = marca;
		this.dispMax = dispMax;
		this.dispMin = dispMin;
	}
	
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getDispMin() {
		return dispMin;
	}

	public void setDispMin(int dispMin) {
		this.dispMin = dispMin;
	}

	public int getDispMax() {
		return dispMax;
	}

	public void setDispMax(int dispMax) {
		this.dispMax = dispMax;
	}
	
}
