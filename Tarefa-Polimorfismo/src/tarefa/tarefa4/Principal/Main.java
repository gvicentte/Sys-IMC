package tarefa.tarefa4.Principal;

import jdk.javadoc.doclet.DocletEnvironment;
import tarefa.tarefa4.Model.Desenvolvedor;
import tarefa.tarefa4.Model.Estagiario;
import tarefa.tarefa4.Model.Funcionario;
import tarefa.tarefa4.Model.Gerente;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Gerente gerente = new Gerente("Luccas Klein","80115544",15000,5000);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Gabriel Vicentte","80117283",5000,7,"C#");
        Estagiario estagiario = new Estagiario("Sidrak Alves","80194900",1500);
        funcionarios.add(gerente);
        funcionarios.add(desenvolvedor);
        funcionarios.add(estagiario);
        for(int i = 0 ; i < funcionarios.size() ; i++){
            funcionarios.get(i).realizarTarefa();
            System.out.printf("Salario: R$%.2f%n",funcionarios.get(i).calcularSalario());
        }
    }
}