package tarefa.tarefa1.Principal;

import tarefa.tarefa1.Model.Circulo;
import tarefa.tarefa1.Model.Forma;
import tarefa.tarefa1.Model.Quadrado;
import tarefa.tarefa1.Model.Triangulo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Forma> formas = new ArrayList<>();
        Circulo circulo = new Circulo(2.5);
        Quadrado quadrado = new Quadrado(7);
        Triangulo triangulo = new Triangulo(5,4.5);
        formas.add(circulo);
        formas.add(quadrado);
        formas.add(triangulo);
        for(int i = 0; i<formas.size();i++){
            System.out.printf("Area = %.2f%n",formas.get(i).calcularArea());
            formas.get(i).desenhar();
        }
    }
}