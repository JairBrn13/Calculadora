package calc3docs.example.calc3;
// Se crea la clase operaciones, con los metodos de las 4 operaciones basicas de la calculadora
public class Operaciones {

    private int a;
    private int b;

    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int suma() {
        return a + b;
    }

    public int resta() {
        return a - b;
    }

    public int mult() {
        return a * b;
    }

    public double division() {
        return (double) a / b;
    }
}