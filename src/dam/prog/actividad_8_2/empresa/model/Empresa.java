package dam.prog.actividad_8_2.empresa.model;

import java.util.ArrayList;

import dam.prog.actividad_8_2.empresa.model.Empleado;

public class Empresa {
	private ArrayList<Empleado> lstEmpleado;
	private String nombre;
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		this.lstEmpleado = new ArrayList<Empleado>();
	}
	
	public Empresa(String nombre, ArrayList<Empleado> lst) {
		this.nombre = nombre;
		this.lstEmpleado = lst;
	}
	
	public ArrayList<Empleado> getLstEmpleado() {
		return lstEmpleado;
	}
	
	public void addEmpleado(Empleado e) {
		this.lstEmpleado.add(e);
	}
	
	public double calcularTotalSalarios() {
		double r = 0d;
		for (Empleado e : lstEmpleado)
			r += e.getSalario();
		return r;
	}
	
	public boolean containsDNI(String dni) {
		for (Empleado e : lstEmpleado)
			if (e.getDni().equalsIgnoreCase(dni))
				return true;
		return false;
	}
	
	@Override
	public String toString() {
		String str = String.format("Empresa %s:\nEmpleados:\n", nombre);
		for (Empleado e : lstEmpleado)
			str += "  - " + e.toString();
		str += "\n";
		return str;
	}
}
