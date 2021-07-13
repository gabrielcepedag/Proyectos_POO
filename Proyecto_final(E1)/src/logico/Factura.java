package logico;

import java.util.ArrayList;

public class Factura {
	
	private String codigo;
	private Cliente miCliente;
	private ArrayList<Producto> misProductos;
	private float valorTotal;
	private boolean esACredito;
	public static int cod = 1;
	
	public Factura(String codigo, Cliente miCliente) {
		super();
		this.codigo = codigo;
		this.miCliente = miCliente;
		this.misProductos = new ArrayList<Producto>();
		this.valorTotal = 0;
		esACredito = false;
		Factura.cod++;
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
		return calcPrecioFactura();
	}
	
	public boolean isEsACredito() {
		return esACredito;
	}

	public void setEsACredito(boolean esACredito) {
		this.esACredito = esACredito;
	}

	public void agregarProductos(ArrayList<Producto> productos) {
		misProductos.addAll(productos);
	}
	
	public float calcPrecioFactura() {
		
		if (valorTotal > 0) {
			return valorTotal;
		}else {
			int total = 0;
			
			for (Producto producto : misProductos) {
				total += producto.getPrecio();
			}
			valorTotal = total;
			return valorTotal;
		}
		
	}
}
