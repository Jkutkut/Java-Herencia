package dam.prog.actividad_8_2.empresa.model;

public class EmpleadoDistribucion extends Empleado {
	private String zona;

	public EmpleadoDistribucion(String nombre, String dni, double salario,
			String zona) {
		super(nombre, dni, salario);
		this.zona = zona;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format(
			" - Zona: %s", zona
		);
	}
}
