package dam.prog.examen_17_18.classes;

public abstract class ObjetoBiblioteca {
	private int numEjemplares;
	private int ejemplaresPrestados;
	
	
	public ObjetoBiblioteca(int numEjemplares, int ejemplaresPrestados) {
		this.numEjemplares = numEjemplares;
		this.ejemplaresPrestados = ejemplaresPrestados;
	}
	
	public boolean prestamo() {
		if (numEjemplares == ejemplaresPrestados) {
			return false;
		}
		ejemplaresPrestados++;
		return true;
	}
	
	public boolean devolucion() {
		if (ejemplaresPrestados == 0) {
			return false;
		}
		ejemplaresPrestados--;
		return true;
	}
	
	//GETTERS
	public abstract String getIdentificador();
	
	public abstract String mostrarDatos();
	
	protected String datosBiblioteca() {
		return String.format(
			"Números de ejemplares %d, Ejemplares prestados: %d",
			numEjemplares, ejemplaresPrestados
		);
	}
	
	@Override
	public String toString() {
		return this.mostrarDatos();
	}
}
