package dam.prog.actividad_8_2.estudio_arquitectura.model;

public class Hall extends Estancia {

	private boolean puertaBlindada;

	public Hall(String nombre, double metrosCuad, int numPuertas, int numVentanas, boolean puertaBlindada) {
		super(nombre, metrosCuad, numPuertas, numVentanas);
		this.puertaBlindada = puertaBlindada;
	}
	
	public String toString() {
		return super.toString() +
			", puertaBlindada: " +
			((puertaBlindada)? "SI" : "NO");
	}
}
