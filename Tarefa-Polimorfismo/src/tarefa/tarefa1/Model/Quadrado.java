package tarefa.tarefa1.Model;

public class Quadrado extends Forma{
    private double lado;

    public Quadrado() {
    }

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea(){
        return this.getLado() * this.getLado();
    }

    @Override
    public void desenhar(){
        System.out.println("O Quadrado esta sendo imprimido");
    }

}
