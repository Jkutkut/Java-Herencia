package dam.prog.actividad_8_2.estudio_arquitectura.model;

public class Salon extends Estancia {
	private int numPuntosRed;
	private boolean tieneTerraza;
	private double m2Terr;
	
	public Salon(String nombre, double metrosCuad, int numPuertas, int numVentanas, int numPuntosRed,
			boolean tieneTerraza, double m2Terr) {
		super(nombre, metrosCuad, numPuertas, numVentanas);
		this.numPuntosRed = numPuntosRed;
		this.tieneTerraza = tieneTerraza;
		this.m2Terr = m2Terr;
	}
	
	public boolean isTieneTerraza() {
		return tieneTerraza;
	}
	
	public double getM2Terr() {
		return m2Terr;
	}
	
	public String toString() {
		return super.toString() + String.format(
			", números puntos de red %d, %s tiene terraza%s",
			numPuntosRed,
			(isTieneTerraza())? "SI" : "NO",
			(isTieneTerraza())? String.format(", metros2 terraza %.2f", getM2Terr()) : ""
		);
	}
}
