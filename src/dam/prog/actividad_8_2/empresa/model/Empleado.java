package dam.prog.actividad_8_2.empresa.model;

import dam.prog.actividad_8_2.empresa.exception.InvalidDataException;

public class Empleado {
	
	public static final int PRODUCCION = 1;
	public static final int DISTRIBUCION = 2;
	public static final String[] EMPLEADOS = {"Empleado de producción", "Empleado de distribución"};
	public static final String validDNI = "[0-9]{9}[A-Z]";
	
	protected String nombre;
	protected String dni;
	protected double salario;
	
	public Empleado(String nombre, String dni, double salario) {
		this.nombre = nombre;
		this.dni = dni;
		this.salario = salario;
	}
	
	public void setDni(String dni) {
		dni = dni.toUpperCase();
		if (!dni.matches(validDNI))
			throw new InvalidDataException("El DNI no es válido");
		this.dni = dni;
	}
	
	public String getDni() {
		return dni;
	}
	
	public double getSalario() {
		return salario;
	}
	
	@Override
	public String toString() {
		return String.format(
			"Empleado:\n - Nombre: %s\n - DNI: %s\n - Salario: %.2f\n",
			nombre, dni, salario
		);
	}
}
