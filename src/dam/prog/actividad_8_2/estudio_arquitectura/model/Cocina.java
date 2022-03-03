package dam.prog.actividad_8_2.estudio_arquitectura.model;

public class Cocina extends Estancia {
	private boolean tendedero;
	private double m2Tend;
	
	public Cocina(String nombre, double metrosCuad, int numPuertas, int numVentanas,
					boolean tendedero, double m2Tend) {
		super(nombre, metrosCuad, numPuertas, numVentanas);
		this.tendedero = tendedero;
		this.m2Tend = m2Tend;
	}
	
	public boolean isTendedero() {
		return tendedero;
	}
	
	public double getM2Tend() {
		return m2Tend;
	}
	
	public String toString() {
		return super.toString() + String.format(
					", %s tiene tendedero, m2tend %.2f",
					(isTendedero())? "SI":"NO",
					getM2Tend()
				);
	}
}
