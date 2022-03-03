package dam.prog.actividad_8_2.estudio_arquitectura.model;

public class Habitacion extends Estancia {
	private int numPuertasArm;
	private boolean accesoBanio;
	
	public Habitacion(String nombre, double metrosCuad, int numPuertas, int numVentanas,
			int numPuertasArm, boolean accesoBanio) {
		super(nombre, metrosCuad, numPuertas, numVentanas);
		this.numPuertasArm = numPuertasArm;
		this.accesoBanio = accesoBanio;
	}
	
	public String toString() {
		return super.toString() + String.format(
			", numPuertasArm %d, %s acceso baño",
			numPuertasArm,
			(accesoBanio)? "con" : "sin"
		);
	}
}
