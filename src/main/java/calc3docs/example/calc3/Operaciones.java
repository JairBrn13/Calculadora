package calc3docs.example.calc3;

public class Operaciones {

    private int a;
    private int b;

    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
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