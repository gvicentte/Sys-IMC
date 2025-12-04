package tarefa.tarefa1.Model;

public class Circulo extends Forma{
    private double raio;
    private static final double pi = 3.14;

    public Circulo() {
    }

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea(){
        return pi * (this.getRaio() * this.getRaio());
    }

    @Override
    public void desenhar(){
        System.out.println("O Circulo esta sendo imprimida");
    }
}
