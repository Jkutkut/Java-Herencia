package dam.prog.actividad_8_2.empresa;

import java.util.Scanner;
import dam.prog.actividad_8_2.empresa.model.*;
import dam.prog.actividad_8_2.empresa.exception.*;

public class GestorEmpresa {
	
	private static Scanner sc;
	
	private static Empresa empresa;
	
	private static final int ADD = 1;
	private static final int RM = 2;
	private static final int SHOW = 3;
	private static final int EXIT = 4;
	
	private static final String MENU = "Selecciona una opción:\n1 - Añadir empleado\n2 - Eliminar empleado\n3 - Mostrar empresa\n4 - Salir\n -> ";
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		empresa = new Empresa(getString("Nombre de la empresa: ", 4, 40));
		
		int selected = -1;
		while (selected != EXIT) {
			selected = getIntInRange(MENU, 1, 4);
			switch (selected) {
			case ADD:
				addEmpleado();
				break;
			case RM:
				removeEmpleado();
				break;
			case SHOW:
				show();
				break;
			}
		}
	}
	
	private static void addEmpleado() {
		int selected = getIntInRange("Selecciona el tipo de empleado:\n", 1, Empleado.EMPLEADOS.length);
		
		switch (selected) {
		case Empleado.PRODUCCION:
//			empresa.addEmpleado(new EmpleadoProduccion(
//				nombre,
//				dni,
//				salario,
//				turno,
//				plusNoct
//			));
			break;
		case Empleado.DISTRIBUCION:
			
			break;
		}
	}
	
	private static Object[] getArgs(int tipo) {
		Object[] args = new Object[5];
		int i = 3;
		
		System.out.println("Introduce los datos del empleado:");
		while (true) {
			args[1] = getString(" - DNI: ");
			if (!((String) args[1]).matches(Empleado.validDNI))
				System.out.println("Eso no es un DNI");
			else if (empresa.containsDNI((String) args[2]))
				System.out.println("El DNI ya existe");
			else
				break;
		}
		args[0] = getString(" - Nombre: ");
		args[2] = getNaturalDouble(" - Salario: ");
		
//		TODO
		switch (tipo) {
		case Empleado.PRODUCCION:
//			args[i++] = 
			break;
		case Empleado.DISTRIBUCION:
			
			break;
		}
		return args;
	}

	private static void removeEmpleado() {
		// TODO Auto-generated method stub
		
	}

	private static void show() {
		// TODO Auto-generated method stub
		
	}

	//	GETTERS

	public static Object getObjectIn(String question, Object[] arr) {
		System.out.println(question);
		for (int i = 0; i < arr.length; i++) {
//			TODO
		}
		return arr[getIntInRange(question, 1, arr.length) - 1];
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
