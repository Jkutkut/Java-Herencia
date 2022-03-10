package dam.prog.examen_17_18.classes;

public class CD_Video extends CD {

	private String categoria;
	
	public CD_Video(int numEjemplares, int ejemplaresPrestados, String nombre, double duracion, String categoria) {
		super(numEjemplares, ejemplaresPrestados, nombre, duracion);
		this.categoria = categoria;
	}
	
	@Override
	public String mostrarDatos() {
		return String.format(
			"CD audio:\nNombre %s, Duración %.2f, Categoría %s, %s",
			nombre, duracion, categoria, this.datosBiblioteca()
		);
	}
}
