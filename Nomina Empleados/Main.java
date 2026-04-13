public class Main {
    public static void main(String[] args) {

        // Crear empleados
        Empleado emp1 = new EmpleadoAsalariado("Roiber Castro", 5000000, 10);
        Empleado emp2 = new EmpleadoPorHoras("Alexandra Rojas", 45, 20000);
        Empleado emp3 = new EmpleadoComision("Luis Rodriguez", 1500000, 25000000, 0.05);
        Empleado emp4 = new EmpleadoTemporal("Carolina Perez", 1200000);

        // Mostrar resultados
        emp1.mostrarResumen();
        emp2.mostrarResumen();
        emp3.mostrarResumen();
        emp4.mostrarResumen();
    }
}