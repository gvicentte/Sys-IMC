package org.ex1.Principal;


import org.ex1.Model.Aluno;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aprovado=0, reprovado=0;
        double media=0;
        Aluno alunos[] = new Aluno[10];
        for(int i = 0; i<10; i++){
            System.out.print("Digite o nome do aluno: ");
            alunos[i].setNome(scanner.nextLine());
            System.out.print("Digite a nota do aluno(Use virgula para casa decimal): ");
            alunos[i].setNota(scanner.nextDouble());
            if(alunos[i].getNota() >= 60){
                aprovado++;
            }
            else{
                reprovado++;
            }
            media+= alunos[i].getNota();
            scanner.nextLine();
        }
        media=media/10;
        System.out.println();
        System.out.println("A media da turma foi: " + media);
        System.out.println("Alunos aprovados: " + aprovado);
        System.out.println("Alunos reprovados: " + reprovado);
        System.out.println();
        for(int i = 0; i<alunos.length;i++){
            if(alunos[i].getNota()>=60){
                System.out.println("Aluno: " + alunos[i].getNome() + " Aprovado");
            }
            else{
                System.out.println("Aluno: " + alunos[i].getNome() + " Reprovado");
            }
        }
    }
}