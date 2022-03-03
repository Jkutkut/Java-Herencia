package dam.prog.actividad_8_2.estudio_arquitectura.model;

import java.util.ArrayList;

public class Casa {
	private ArrayList<Estancia> listaEstancias;
	private String direccion;
	
	
	public Casa(String direccion) { 
		this.direccion = direccion;
		this.listaEstancias = new ArrayList<Estancia>();
	}
	
	public ArrayList<Estancia> getListaEstancias() {
		return listaEstancias;
	}
	
	public void addInstancia(Estancia e) {
		this.listaEstancias.add(e);
	}
	
	public double calcularTotalM2() {
		double totalM2 = 0d;
		for (Estancia e : listaEstancias) {
			totalM2 += e.getMetrosCuad();
			if (e instanceof Salon && ((Salon) e).isTieneTerraza())
				totalM2 += ((Salon) e).getM2Terr();
		}
		return totalM2;
	}
	
	public String toString() {
		String estancias = "";
		for (int i = 0; i < this.listaEstancias.size(); i++)
			estancias += "\n\t" + listaEstancias.get(i);
		return String.format(
			"Casa en \"%s\".\nEstancias:%s",
			this.direccion, estancias
		);
	}
}
