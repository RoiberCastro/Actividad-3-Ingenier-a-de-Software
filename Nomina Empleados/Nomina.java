// -------------------------
// Clase Abstracta Empleado
// -------------------------
abstract class Empleado {
    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    public double calcularDeducciones(double salarioBruto) {
        return salarioBruto * 0.04; // 4% salud y pensión
    }

    public void mostrarResumen() {
        double salarioBruto = calcularSalario();
        double deducciones = calcularDeducciones(salarioBruto);
        double salarioNeto = salarioBruto - deducciones;

        if (salarioNeto < 0) salarioNeto = 0;

        System.out.println("\nEmpleado: " + nombre);
        System.out.println("Salario Bruto: " + salarioBruto);
        System.out.println("Deducciones: " + deducciones);
        System.out.println("Salario Neto: " + salarioNeto);
    }
}

// -------------------------
// Empleado Asalariado
// -------------------------
class EmpleadoAsalariado extends Empleado {
    private int años;

    public EmpleadoAsalariado(String nombre, double salarioBase, int años) {
        super(nombre, salarioBase);
        this.años = años;
    }

    @Override
    public double calcularSalario() {
        double salario = salarioBase;

        if (años > 5) {
            salario += salario * 0.10;
        }

        salario += 1000000; // bono alimentación
        return salario;
    }
}

// -------------------------
// Empleado por Horas
// -------------------------
class EmpleadoPorHoras extends Empleado {
    private int horas;
    private double tarifa;

    public EmpleadoPorHoras(String nombre, int horas, double tarifa) {
        super(nombre, 0);
        this.horas = horas;
        this.tarifa = tarifa;
    }

    @Override
    public double calcularSalario() {
        if (horas < 0) {
            throw new IllegalArgumentException("Las horas no pueden ser negativas");
        }

        if (horas <= 40) {
            return horas * tarifa;
        } else {
            return (40 * tarifa) + ((horas - 40) * tarifa * 1.5);
        }
    }
}

// -------------------------
// Empleado por Comisión
// -------------------------
class EmpleadoComision extends Empleado {
    private double ventas;
    private double porcentaje;

    public EmpleadoComision(String nombre, double salarioBase, double ventas, double porcentaje) {
        super(nombre, salarioBase);
        this.ventas = ventas;
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularSalario() {
        if (ventas < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser negativas");
        }

        double salario = salarioBase + (ventas * porcentaje);

        if (ventas > 20000000) {
            salario += ventas * 0.03;
        }

        salario += 1000000; // bono alimentación
        return salario;
    }
}

// -------------------------
// Empleado Temporal
// -------------------------
class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }
}
