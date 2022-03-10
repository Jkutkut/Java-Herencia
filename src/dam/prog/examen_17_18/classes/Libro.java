package dam.prog.examen_17_18.classes;

public class Libro extends ObjetoBiblioteca {
	
	private String titulo;
	private String autor;
	private int numPaginas;
	
	

	public Libro(int numEjemplares, int ejemplaresPrestados, String titulo, String autor, int numPaginas) {
		super(numEjemplares, ejemplaresPrestados);
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
	}

	@Override
	public String getIdentificador() {
		return this.titulo;
	}

	@Override
	public String mostrarDatos() {
		return String.format(
			"Libro:\nTítulo %s, Autor %s, Número páginas %d, %s",
			titulo, autor, numPaginas, this.datosBiblioteca()
		);
	}

}
