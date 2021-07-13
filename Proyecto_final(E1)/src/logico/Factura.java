package logico;

import java.util.ArrayList;

public class Factura {
	
	private String codigo;
	private Cliente miCliente;
	private Vendedor miVendedor;
	private ArrayList<Producto> misProductos = new ArrayList<Producto>();
	private float precioTotal;
	private boolean esACredito;
	public static int cod = 1;
	
	public Factura(String codigo, Vendedor miVendedor, Cliente miCliente, ArrayList<Producto> misProductos) {
		super();
		this.codigo = codigo;
		this.miVendedor = miVendedor;
		this.miCliente = miCliente;
		this.misProductos = misProductos;
		this.precioTotal = 0;
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

	public Vendedor getMiVendedor() {
		return miVendedor;
	}
	public void setMiVendedor(Vendedor miVendedor) {
		this.miVendedor = miVendedor;
	}

	public void setMisProductos(ArrayList<Producto> misProductos) {
		this.misProductos = misProductos;
	}

	public float getPrecioTotal() {
		return calcPrecioFactura();
	}
	
	public boolean isEsACredito() {
		return esACredito;
	}

	public void setEsACredito(boolean esACredito) {
		this.esACredito = esACredito;
	}
	
	public float calcPrecioFactura() {
		if (precioTotal > 0) {
			return precioTotal;
		}else {
			float total = 0;
			
			for (Producto producto : misProductos) {
				total += producto.getPrecio();
			}
			this.precioTotal = total;
			return precioTotal;
		}
	}
}
