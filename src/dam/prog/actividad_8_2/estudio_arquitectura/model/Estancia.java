package dam.prog.actividad_8_2.estudio_arquitectura.model;

public class Estancia {

	public static final int HALL = 0;
	public static final int COCINA = 1;
	public static final int SALON = 2;
	public static final int HABITACION = 3;
	public static final int BANIO = 4;
	
	public static final String[] ESTANCIAS = {"Hall", "Cocina", "Salón", "Habitación", "Baño"};
	protected String nombre;
	protected double metrosCuad;
	protected int numPuertas;
	protected int numVentanas;
	
	
	
	public Estancia(String nombre, double metrosCuad, int numPuertas, int numVentanas) {
		this.nombre = nombre;
		this.metrosCuad = metrosCuad;
		this.numPuertas = numPuertas;
		this.numVentanas = numVentanas;
	}


	public double getMetrosCuad() {
		return this.metrosCuad;
	}
	
	public String toString() {
		return String.format(
			"Estancia %s, m^2 %.2f, número puertas %d, número ventanas %d",
			this.nombre, this.metrosCuad, this.numPuertas, this.numVentanas
		);
	}
}
