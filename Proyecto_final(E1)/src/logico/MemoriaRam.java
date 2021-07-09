package logico;

public class MemoriaRam extends Producto{
	
	private int capacidad;
	private String tipoMemoria;
	public MemoriaRam(String numSerie, int cantidad, float precio, String marca, int capacidad, String tipoMemoria) {
		super(numSerie, cantidad, precio, marca);
		this.capacidad = capacidad;
		this.tipoMemoria = tipoMemoria;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getTipoMemoria() {
		return tipoMemoria;
	}
	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}

}
