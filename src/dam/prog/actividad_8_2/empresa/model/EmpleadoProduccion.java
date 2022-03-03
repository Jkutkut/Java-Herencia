package dam.prog.actividad_8_2.empresa.model;

public class EmpleadoProduccion extends Empleado {
	private String turno;
	private double plusNoct;
	
	public EmpleadoProduccion(String nombre, String dni, double salario,
			String turno, double plusNoct) {
		super(nombre, dni, salario);
		this.turno = turno;
		this.plusNoct = plusNoct;
	}
	
	public double getPlusNoct() {
		return plusNoct;
	}
	
	@Override
	public double getSalario() {
		return super.getSalario() + plusNoct;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(
			" - turno: %s\n - plusNoct: %.2f\n",
			turno, plusNoct
		);
	}
}
