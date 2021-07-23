package logico;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String cedula;
	private String nombre;
	private String direccion;
	private String telefono;
	private float credito;
	private int cantCompras; //Verificar que se esté actualizando ese valor en HacerFactura
	
	public Cliente(String cedula, String nombre, String direccion, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.credito = 0;
		this.cantCompras = 0;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	
	public float getCredito() {
		return credito;
	}
	public void setCredito(float credito) {
		this.credito = credito;
	}

	public int getCantCompras() {
		return cantCompras;
	}
	public void setCantCompras(int cantCompras) {
		this.cantCompras = cantCompras;
	}
}
