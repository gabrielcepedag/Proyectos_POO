package logico;

import java.util.ArrayList;

public class MotherBoard extends Producto{
	
	private String modelo;
	private String socket;
	private String tipoRam;
	private ArrayList<String> conexionesHD;
	
	public MotherBoard(String numSerie, int cantidad, float precio, String marca, String modelo, String socket,
			String tipoRam, ArrayList<String> conexionesHD) {
		super(numSerie, cantidad, precio, marca);
		this.modelo = modelo;
		this.socket = socket;
		this.tipoRam = tipoRam;
		this.conexionesHD = conexionesHD;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public String getTipoRam() {
		return tipoRam;
	}
	public void setTipoRam(String tipoRam) {
		this.tipoRam = tipoRam;
	}
	public ArrayList<String> getConexionesHD() {
		return conexionesHD;
	}
	public void setConexionesHD(ArrayList<String> conexionesHD) {
		this.conexionesHD = conexionesHD;
	}
	
}
