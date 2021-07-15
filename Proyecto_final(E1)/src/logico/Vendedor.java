package logico;

public class Vendedor extends Empleado {

	private float totalVendido;

	public Vendedor(String username, String password, String nombre, String cedula, String telefono, String direccion) {
		super(username, password, nombre, cedula, telefono, direccion);
		this.totalVendido = 0;
	}

	public float getTotalVendido() {
		return totalVendido;
	}
	public void setTotalVendido(float totalVendido) {
		this.totalVendido = (getTotalVendido() + totalVendido);
	}
	
}
