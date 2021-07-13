package logico;

import java.util.ArrayList;

public class Combo {

	private String codigo;
	private String nombre;
	private ArrayList<Producto> misProductos = new ArrayList<Producto>();
	private float descuento;
	private float precioNeto;
	private float precioTotal;
	
	public Combo(String codigo, String nombre, ArrayList<Producto> misProductos, float descuento) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.misProductos = misProductos;
		this.descuento = descuento;
		this.precioNeto = 0;
		this.precioTotal = 0;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Producto> getMisProductos() {
		return misProductos;
	}
	public void setMisProductos(ArrayList<Producto> misProductos) {
		this.misProductos = misProductos;
	}

	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getPrecioNeto() {
		return precioNeto;
	}
	public void setPrecioNeto(float precioNeto) {
		this.precioNeto = precioNeto;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public float calcPrecioTotal() {
		float total = (float) (((float) descuento/100) * calcPrecioNeto());
		
		this.precioTotal = total;
		return precioTotal;
	}
	
	public float calcPrecioNeto() {
		float suma = 0;
		
		for (Producto producto : misProductos) {
			suma += producto.getPrecio();
		}
		
		return suma;
	}
	
}
