package logico;

import java.util.ArrayList;

public class Administrador extends Empleado {

	private ArrayList<Combo> misCombos;
	private ArrayList<OrdenCompra> misOrdenesPendientes;
	private ArrayList<OrdenCompra> misOrdenesProcesadas;
	private ArrayList<Vendedor> misVendedores;
	
	public Administrador(String username, String password, String nombre, String cedula, String telefono, String direccion) {
		super(username, password, nombre, cedula, telefono, direccion);
		this.misCombos = new ArrayList<Combo>();
		this.misOrdenesPendientes = new ArrayList<OrdenCompra>();
		this.misOrdenesProcesadas = new ArrayList<OrdenCompra>();
		this.misVendedores = new ArrayList<Vendedor>();
	}

	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}
	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}
	public void addCombo(Combo combo) {
		misCombos.add(combo);
	}
	public void eliminarCombo(Combo combo) {
		misCombos.remove(combo);
	}

	public ArrayList<OrdenCompra> getMisOrdenesPendientes() {
		return misOrdenesPendientes;
	}
	public void setMisOrdenesPendientes(ArrayList<OrdenCompra> misOrdenesPendientes) {
		this.misOrdenesPendientes = misOrdenesPendientes;
	}
	public void addOrdenPendiente(OrdenCompra orden) {
		misOrdenesPendientes.add(orden);
	}

	public ArrayList<OrdenCompra> getMisOrdenesProcesadas() {
		return misOrdenesProcesadas;
	}
	public void setMisOrdenesProcesadas(ArrayList<OrdenCompra> misOrdenesProcesadas) {
		this.misOrdenesProcesadas = misOrdenesProcesadas;
	}
	public void addOrdenProcesada(OrdenCompra orden) {
		misOrdenesProcesadas.add(orden);
	}
	
	public ArrayList<Vendedor> getMisVendedores() {
		return misVendedores;
	}
	public void setMisVendedores(ArrayList<Vendedor> misVendedores) {
		this.misVendedores = misVendedores;
	}
	public void addVendedor(Vendedor vendedor) {
		misVendedores.add(vendedor);
	}
	public void eliminarVendedor(Vendedor vendedor) {
		misVendedores.remove(vendedor);
	}
	
	
	
}
