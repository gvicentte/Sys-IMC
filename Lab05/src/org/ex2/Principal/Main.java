package org.ex2.Principal;

import org.ex2.Model.Produto;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Produto produtos[] = {new Produto("Samsung","3539KAFW124",10),
                              new Produto("Livro","572HH3",5),
                              new Produto("Kicks","214L",20),
                              new Produto("Regua","22CMD",30),
                              new Produto("Cubo Magico","2213MSF",2)};
        int fazer = 0;
        Scanner scanner = new Scanner(System.in);
        while (fazer!=2){
            System.out.println("Informe o que deseja fazer");
            System.out.println("1 - Pesquisar Produto.");
            System.out.println("2 - Sair do Programa.");
            fazer = scanner.nextInt();
            scanner.nextLine();
            switch(fazer){
                case 1:
                    System.out.println("Digite o nome ou o codigo do produto: ");
                    String produto = scanner.nextLine();
                    for(int i = 0;i< produtos.length;i++){
                        if(Objects.equals(produtos[i].getNome(), produto) || Objects.equals(produtos[i].getCodigo(), produto)){
                            System.out.println();
                            System.out.println("Produto encontrado!");
                            System.out.println("Nome do Produto: " + produtos[i].getNome());
                            System.out.println("Codigo do Produto: " + produtos[i].getCodigo());
                            System.out.println("Quantidade em estoque: " + produtos[i].getQntestoque());
                            if(produtos[i].getQntestoque() < 10){
                                System.out.println("Alerta: Esse produto precisa ser reabastecido!");
                            }
                            System.out.println();
                            i= produtos.length;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Saindo do Programa...");
                    break;
                default:
                    System.out.println("Codigo invalido digite novamente.");
                    System.out.println();
            }
        }
    }
}
