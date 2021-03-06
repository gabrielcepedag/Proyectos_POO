package logico;

import java.io.Serializable;

public class Vendedor extends Empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	private float totalVendido;
	private float comision;

	public Vendedor(String username, String password, String nombre, String cedula, String telefono, String direccion) {
		super(username, password, nombre, cedula, telefono, direccion);
		this.totalVendido = 0;
		this.comision = 0;
	}

	public float getTotalVendido() {
		return totalVendido;
	}
	public void setTotalVendido(float totalVendido) {
		this.totalVendido = (getTotalVendido() + totalVendido);
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = (getComision() + comision);
	}
	
}
