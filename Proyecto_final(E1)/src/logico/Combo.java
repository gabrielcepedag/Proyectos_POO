package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Combo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private ArrayList<Producto> misProductos = new ArrayList<Producto>();
	private float descuento;
	private float precioNeto;
	private float precioTotal;
	public static int cod = 1;
	
	public Combo(String codigo, String nombre, ArrayList<Producto> misProductos, float descuento) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.misProductos.addAll(misProductos);
		this.descuento = descuento;
		this.precioNeto = 0;
		this.precioTotal = 0;
		Combo.cod++;
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
		this.misProductos.addAll(misProductos);
	}

	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getPrecioNeto() {
		return calcPrecioNeto();
	}
	public void setPrecioNeto(float precioNeto) {
		this.precioNeto = precioNeto;
	}

	public float getPrecioTotal() {
		return calcPrecioTotal();
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public float calcPrecioTotal() {
		
		if (precioTotal > 0) {
			return precioTotal;
		}else {
			
			float precio = calcPrecioNeto();
			float total = (float) (precio) - (((float) descuento/100) * precio);
			this.precioTotal = total;
			return precioTotal;
		}
		
	}
	
	public float calcPrecioNeto() {
		
		if (precioNeto > 0) {
			return precioNeto;
		}else {
			float suma = 0;
			
			for (Producto producto : misProductos) {
				suma += producto.getPrecio();
			}
			precioNeto = suma;
			return precioNeto;
		}
		
	}
	
}
