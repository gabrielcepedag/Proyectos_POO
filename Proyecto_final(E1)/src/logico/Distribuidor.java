package logico;

public class Distribuidor {
	
	private String nombre;
	private String direccion;
	private String telefono;
	private String id;
	public static int codDistribuidor = 1;
	
	public Distribuidor(String nombre, String direccion, String telefono, String id) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.id = id;
		Distribuidor.codDistribuidor++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
