package dam.prog.examen_17_18.classes;

public abstract class CD extends ObjetoBiblioteca {

	protected String nombre;
	protected double duracion;
	
	public CD(int numEjemplares, int ejemplaresPrestados, String nombre, double duracion) {
		super(numEjemplares, ejemplaresPrestados);
		this.nombre = nombre;
		this.duracion = duracion;
	}
	
	@Override
	public String getIdentificador() {
		return nombre;
	}
}
