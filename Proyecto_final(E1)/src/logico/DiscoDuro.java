package logico;

import java.io.Serializable;

public class DiscoDuro extends Producto implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String modelo;
	private int capacidad;
	private String socket;
	
	public DiscoDuro(String numSerie, int cantidad, float precio, String marca, int dispMin, int dispMax, String modelo, int capacidad,
			String socket) {
		super(numSerie, cantidad, precio, marca, dispMin, dispMax);
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.socket = socket;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	
	
}
