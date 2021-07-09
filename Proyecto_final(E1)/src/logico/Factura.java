package logico;

import java.util.ArrayList;

public class Factura {
	
	private String codigo;
	private Cliente miCliente;
	private ArrayList<Producto> misProductos;
	private float valorTotal;
	
	public Factura(String codigo, Cliente miCliente, float valorTotal) {
		super();
		this.codigo = codigo;
		this.miCliente = miCliente;
		this.misProductos = new ArrayList<Producto>();
		this.valorTotal = valorTotal;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Cliente getMiCliente() {
		return miCliente;
	}
	public void setMiCliente(Cliente miCliente) {
		this.miCliente = miCliente;
	}

	public ArrayList<Producto> getMisProductos() {
		return misProductos;
	}
	public void setMisProductos(ArrayList<Producto> misProductos) {
		this.misProductos = misProductos;
	}

	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public void agregarProducto(Producto producto) {
		misProductos.add(producto);
	}
	
	public float calcPrecioFactura() {
		int total = 0;
		
		for (Producto producto : misProductos) {
			total += producto.getPrecio();
		}
		return total;
	}
}
