package logico;

public abstract class Empleado {

	protected String username;
	protected String password;
	protected String nombre;
	protected String cedula;
	protected String telefono;
	protected String direccion;
	
	public Empleado(String username, String password, String nombre, String cedula, String telefono, String direccion) {
		super();
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
/*
 * public void setPassword(String password) {
 *		this.password = password;
 *	}
 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}	
	
}
