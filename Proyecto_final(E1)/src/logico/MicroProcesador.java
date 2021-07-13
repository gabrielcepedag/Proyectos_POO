package logico;

public class MicroProcesador extends Producto{
	
	private String modelo;
	private String socket;
	private float velocidadProcesamiento;
	
	public MicroProcesador(String numSerie, int cantidad, float precio, String marca, int dispMin, int dispMax, String modelo, String socket,
			float velocidadProcesamiento) {
		super(numSerie, cantidad, precio, marca, dispMin, dispMax);
		this.modelo = modelo;
		this.socket = socket;
		this.velocidadProcesamiento = velocidadProcesamiento;
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
	
	public float getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}
	public void setVelocidadProcesamiento(float velocidadProcesamiento) {
		this.velocidadProcesamiento = velocidadProcesamiento;
	}
	
}
