package dam.prog.actividad_8_2.estudio_arquitectura;

import java.util.Scanner;

import dam.prog.actividad_8_2.estudio_arquitectura.model.*;

public class GestionaArq {
	
	static Scanner sc;
	static Casa casa;
	static int[] contHabitaciones;
	static String addStanciaQuestion;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		contHabitaciones = new int[Estancia.ESTANCIAS.length];
		
		addStanciaQuestion = "\nSelecciona qué casa quieres añadir:\n";
		for (int i = 0; i < Estancia.ESTANCIAS.length; i++) {
			addStanciaQuestion += String.format(
				"%d - Añadir %s\n",
				i + 1,
				Estancia.ESTANCIAS[i]
			);
		}
		
		System.out.print("Introduce la direccion: ");		
		casa = new Casa(sc.nextLine());
		
		int opcion = 0;
		while(opcion != 3) {
			opcion = getIntInRange("\nIntroduce la accion que deseas realizar:" 
					+ "\n1 - Añadir estancia"
					+ "\n2 - Mostrar casa"
					+ "\n3 - Finalizar\n", 1, 3);
			
			switch (opcion) {
			case 1:
				addEstancia();
				break;
			case 2:
				System.out.println(casa);
				System.out.println("\nTotal m2: " + casa.calcularTotalM2());
				break;
			}
		}
		System.out.println("*Fin del proceso*");
		sc.close();
	}
	
	private static void addEstancia() {
		int tipo = getIntInRange(addStanciaQuestion, 1, Estancia.ESTANCIAS.length) - 1;
		switch (tipo) {
		case Estancia.HALL:
			addHall();
			break;
		case Estancia.COCINA:
			addCocina();
			break;
		case Estancia.SALON:
			addSalon();
			break;
		case Estancia.HABITACION:
			addHabitacion();
			break;
		case Estancia.BANIO:
			addBanio();
			break;
		}
	}

	private static void addHall() {
		Object[] args = pedirArgs(Estancia.HALL);
		casa.addInstancia(new Hall(
			(String) args[0],
			(double) args[1],
			(int) args[2],
			(int) args[3],
			(boolean) args[4]
		));
	}
	
	private static void addCocina() {
		Object[] args = pedirArgs(Estancia.COCINA);
		casa.addInstancia(new Cocina(
			(String) args[0],
			(double) args[1],
			(int) args[2],
			(int) args[3],
			(boolean) args[4],
			(double) args[5]
		));
	}

	private static void addSalon() {
		Object[] args = pedirArgs(Estancia.SALON);
		casa.addInstancia(new Salon(
			(String) args[0],
			(double) args[1],
			(int) args[2],
			(int) args[3],
			(int) args[4],
			(boolean) args[5],
			(double) args[6]
		));
	}

	private static void addHabitacion() {
		Object[] args = pedirArgs(Estancia.HABITACION);
		casa.addInstancia(new Habitacion(
			(String) args[0],
			(double) args[1],
			(int) args[2],
			(int) args[3],
			(int) args[4],
			(boolean) args[5]
		));
	}

	private static void addBanio() {
		Object[] args = pedirArgs(Estancia.BANIO);
		casa.addInstancia(new Banio(
			(String) args[0],
			(double) args[1],
			(int) args[2],
			(int) args[3],
			(boolean) args[4],
			(boolean) args[5]
		));
	}
	
	private static Object[] pedirArgs(int tipo) {
		int i = 0;
		Object[] args = new Object[8];
		System.out.println("Introduce los datos de la nueva estancia " + Estancia.ESTANCIAS[tipo]);
		args[i++] = Estancia.ESTANCIAS[tipo] + "_" + contHabitaciones[tipo]++;
		args[i++] = getNaturalDouble(" - Metros cuadrados: ");
		args[i++] = getNatural(" - Número puertas: ");
		args[i++] = getNatural(" - Número ventanas: ");
		
		switch (tipo) {
		case Estancia.HALL:
			args[i++] = getBoolean(" - Puerta blindada: ");
			break;
		case Estancia.COCINA:
			args[i++] = getBoolean(" - Tendedero: ");
			if ((boolean) args[i - 1])
				args[i++] = getNaturalDouble("    - Metros cuadrados: ");
			else
				args[i++] = 0d;
			break;
		case Estancia.SALON:
			args[i++] = getNatural(" - Puntos de red: ");
			args[i++] = getBoolean(" - Tiene terraza: ");
			if ((boolean) args[i - 1])
				args[i++] = getNaturalDouble("    - Metros cuadrados: ");
			else
				args[i++] = 0d;
			break;
		case Estancia.HABITACION:
			args[i++] = getNatural(" - Número puertas armario: ");
			args[i++] = getBoolean(" - Tiene acceso a baño: ");
			break;
		case Estancia.BANIO:
			args[i++] = getBoolean(" - Tiene ducha: ");
			args[i++] = getBoolean(" - Tiene bañera: ");
		default:
			System.out.println("Tipo no válido");
			return null;
		}
		return args;
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
