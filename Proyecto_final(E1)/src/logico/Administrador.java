package logico;

import java.util.ArrayList;

public class Administrador extends Empleado {

	private ArrayList<Vendedor> misVendedores;
	
	public Administrador(String username, String password, String nombre, String cedula, String telefono, String direccion) {
		super(username, password, nombre, cedula, telefono, direccion);
		this.misVendedores = new ArrayList<Vendedor>();
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
