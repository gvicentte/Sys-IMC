package tarefa.tarefa1.Model;

public class Triangulo extends Forma{
    private double base;
    private double altura;

    public Triangulo() {
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double calcularArea(){
        return (this.getBase() * this.getAltura())/2;
    }

    @Override
    public void desenhar(){
        System.out.println("O Triangulo esta sendo imprimido");
    }

}
