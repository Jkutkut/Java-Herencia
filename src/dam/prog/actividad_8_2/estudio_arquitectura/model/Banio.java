package dam.prog.actividad_8_2.estudio_arquitectura.model;

public class Banio extends Estancia {
	private boolean ducha;
	private boolean banera;
	
	public Banio(String nombre, double metrosCuad, int numPuertas, int numVentanas, boolean ducha, boolean banera) {
		super(nombre, metrosCuad, numPuertas, numVentanas);
		this.ducha = ducha;
		this.banera = banera;
	}
	
	public String toString() {
		return super.toString() + String.format(
			", %stiene ducha, %stiene bañena",
			(ducha)?"":"no ",
			(banera)?"":"no "
		);
	}
}
