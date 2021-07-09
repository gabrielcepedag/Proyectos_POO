package logico;

import java.util.ArrayList;

public class Factura {
	
	private String codigo;
	private Cliente miCliente;
	private ArrayList<Producto> misComponentes;
	private float valorTotal;
	
	public Factura(String codigo, Cliente miCliente, ArrayList<Producto> misComponentes, float valorTotal) {
		super();
		this.codigo = codigo;
		this.miCliente = miCliente;
		this.misComponentes = misComponentes;
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

	public ArrayList<Producto> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Producto> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
}
