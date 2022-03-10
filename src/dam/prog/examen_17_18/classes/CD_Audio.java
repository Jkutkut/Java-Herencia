package dam.prog.examen_17_18.classes;

public class CD_Audio extends CD {

	private int numeroCanciones;
	
	public CD_Audio(int numEjemplares, int ejemplaresPrestados, String nombre, double duracion, int numeroCanciones) {
		super(numEjemplares, ejemplaresPrestados, nombre, duracion);
		this.numeroCanciones = numeroCanciones;
	}

	@Override
	public String mostrarDatos() {
		return String.format(
			"CD audio:\nNombre %s, Duración %.2f, Número canciones %d, %s",
			nombre, duracion, numeroCanciones, this.datosBiblioteca()
		);
	}
}
