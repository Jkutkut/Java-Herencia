package dam.prog.examen_17_18;

import java.util.ArrayList;
import java.util.Scanner;

import dam.prog.examen_17_18.classes.CD_Audio;
import dam.prog.examen_17_18.classes.CD_Video;
import dam.prog.examen_17_18.classes.Libro;
import dam.prog.examen_17_18.classes.ObjetoBiblioteca;

public class ConsultorBiblioteca {
	
	private static Scanner sc;
	
	private static final String VISUALIZAR = "V";
	private static final String ALQUILAR = "A";
	private static final String DEVOLVER = "D";
	private static final String EXIT = "S";
	
	private static final String MENU = "\n¿Qué desea hacer?\n V - Visualizar\n A - Alquilar\n D - Devolver\n S - Salir\n";
	private static final String NOT_FOUND = "No te entiendo";
	
	private static ArrayList<ObjetoBiblioteca> prestamos;
	
	public static void main(String[] args) {
		prestamos = new ArrayList<ObjetoBiblioteca>();
		
		cargarLibreria();
		
		sc = new Scanner(System.in);
		
		String selected;
		boolean running = true;
		while (running) {
			selected = getString(MENU, 1, 1).toUpperCase();
			switch (selected) {
			case VISUALIZAR:
				visualizar();
				break;
			case ALQUILAR:
				alquilar();
				break;
			case DEVOLVER:
				devolver();
				break;
			case EXIT:
				running = false;
				break;
			default:
				System.out.println(NOT_FOUND);
				break;
			}
		}
		System.out.println("Ejecución terminada");
		sc.close();
	}
	
	private static void visualizar() {
		System.out.println("\nElementos de la biblioteca:\n");
		for (ObjetoBiblioteca e : prestamos) {
			System.out.println(e + "\n");
		}
		
	}

	private static void alquilar() {
		ObjetoBiblioteca p = getPrestamo("Nombre del elemento a prestar: ");
		if (p.prestamo())
			System.out.println("Prestamo realizado correctamente.");
		else
			System.out.println("Prestamo imposible: no hay unidades disponibles.");
		
	}

	private static void devolver() {
		ObjetoBiblioteca p = getPrestamo("Nombre del elemento a devolver: ");
		if (p.devolucion())
			System.out.println("Devolución satisfactoria.");
		else
			System.out.println("Imposible devolución: ya están todas las unidades en la biblioteca.");
		
	}
	
	private static ObjetoBiblioteca getPrestamo(String question) {
		ObjetoBiblioteca p;
		while (true) {
			p = find(question);
			if (p == null)
				System.out.println("No he encontrado lo que me has pedido. Inténtalo de nuevo.");
			else
				return p;
		}
	}
	
	private static ObjetoBiblioteca find(String question) {
		String identificador = getString(question);
		for (ObjetoBiblioteca e : prestamos) {
			if (identificador.equalsIgnoreCase(e.getIdentificador())) {
				return e;
			}
		}
		return null;
	}

	private static void cargarLibreria() {
		// Libros
		prestamos.add(new Libro(
			4,
			2,
			"El Señor de los Anillos",
			"J.R.R. Tolkien",
			1368	
		));
		prestamos.add(new Libro(
			4,
			0,
			"Díez Negritos",
			"Agatha Christie",
			256
		));
		
		// CDs
		prestamos.add(new CD_Audio(
			1,
			9,
			"Thriller",
			42.3,
			3
		));
		
		prestamos.add(new CD_Audio(
			3,
			3,
			"Back in Black",
			41.9,
			10
		));
		
		// CD video
		prestamos.add(new CD_Video(
			4,
			3,
			"Episodio VI - El Retorno del Jedi",
			128.0,
			"Aventuras"
		));
		
		prestamos.add(new CD_Video(
			3,
			1,
			"Tierra",
			100.0,
			"Documental"
		));
	}
	

	// GETTERS

/**
	 * Selector of a element from a array.
	 * @param question Question to ask
	 * @param arr Array to use
	 * @return Element selected.
	 */
	public static Object getObjectIn(String question, Object[] arr) {
		String q = question;
		for (int i = 0; i < arr.length; i++) {
			q += arr[i] + "\n";
		}
		return arr[getIntInRange(q, 1, arr.length) - 1];
	}
	
	/**
	 * @param question - Question to show using System.out.print
	 * @return boolean given by Scanner
	 */
	public static boolean getBoolean(String question) {
		String r;
		while (true) {
			System.out.print(question);
			r = sc.nextLine();
			
			if (r.matches("[Yy][Ee][Ss]|[Ss][Iií]"))
				return true;
			else if (r.matches("[Nn][Oo]"))
				return false;
			else
				System.out.println("No entinedo. Sí o no?");
		}
	}
	
	/**
	 * @param question - Question to show using System.out.print
	 * @return Double given by Scanner
	 */
	public static double getDouble(String question) {
		while (true) {
			try {
				System.out.print(question);
				return Double.parseDouble(sc.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("El valor no es un número decimal válido.\n");
			}
		}
	}
	
	/**
	 * @param question - Question to show using System.out
	 * @return Integer greater or equal to 0
	 */
	public static double getNaturalDouble(String question) {
		double n = 0d;
		boolean isNotNatural = true;
		while (isNotNatural) {
			n = getDouble(question);
			
			if (n >= 0d) {
				isNotNatural = false;
			}
			else {
				System.out.println("El número tiene que ser un natural -> [0, inf)\n");
			}
		}
		return n;
	}
	
	/**
	 * @param question - Question to show using System.out
	 * @param minLen - min length of String
	 * @param maxLen - max length of String
	 * @return Response given by the scanner meeting the criteria.
	 */
	public static String getString(String question, int minLen, int maxLen) {
		String str;
		while (true) {
			System.out.print(question);
			str = sc.nextLine();
			
			if (str.length() < minLen) {
				System.out.println("La longitud mínima es de " + minLen + " caracteres\n");
			}
			else if (str.length() > maxLen) {
				System.out.println("La longitud máxima es de " + maxLen + " caracteres.\n");
			}
			else {
				return str;
			}
		}
	}
	
	public static String getString(String question) {
		System.out.print(question);
		return sc.nextLine();
	}
	
	/**
	 * @param question - Question to show using System.out
	 * @return Integer greater or equal to 0
	 */
	public static int getNatural(String question) {
		int n = 0;
		boolean isNotNatural = true;
		while (isNotNatural) {
			n = getInt(question);
			
			if (n >= 0) {
				isNotNatural = false;
			}
			else {
				System.out.println("El número tiene que ser un natural -> [0, inf)\n");
			}
		}
		return n;
	}
	
	/**
	 * @param question - Question to show using System.out.print
	 * @return Integer given by Scanner
	 */
	public static int getInt(String question) {
		while (true) {
			try {
				System.out.print(question);
				return Integer.parseInt(sc.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("El valor no es un número entero válido.\n");
			}
		}
	}
	
	/**
	 * @param question - Question to show using System.out
	 * @param min - min value of the desired int
	 * @param max - max value of the desired int
	 * @return Integer inside the interval [min, max]
	 */
	public static int getIntInRange(String question, int min, int max) {
	if (min > max) {
		int swap = min;
		min = max;
		max = swap;
	}
	
	int n = 0;
	boolean isNotValid = true;
	while (isNotValid) {
		n = getInt(question);
		
		if (n >= min && n <= max) {
			isNotValid = false;
		}
		else {
			System.out.printf(
				"El número tiene que ser un natural en el rango [%d, %d]\n\n",
				min, max
			);
		}
	}
	return n;
}
}
