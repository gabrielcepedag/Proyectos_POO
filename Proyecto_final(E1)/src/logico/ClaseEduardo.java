package logico;

public class ClaseEduardo {

	private String nombre;
	private int edad;
	private int id;
	public static int numEduardo = 1;
	
	public ClaseEduardo(String nombre, int edad, int id) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.id = id;
		numEduardo++;
	}
}
