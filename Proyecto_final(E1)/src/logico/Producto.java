package logico;

public abstract class Producto {
	
	protected String numSerie;
	protected int cantidad;
	protected float precio;
	protected String marca;
	
	public Producto(String numSerie, int cantidad, float precio, String marca) {
		super();
		this.numSerie = numSerie;
		this.cantidad = cantidad;
		this.precio = precio;
		this.marca = marca;
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
	
	
}
