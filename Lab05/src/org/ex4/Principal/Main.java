package org.ex4.Principal;

import org.ex4.Model.RegistroVenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistroVenda registroVendas[] = new RegistroVenda[30];
        double total = 0, media = 0;
        int valorMais=0,valorMenos=0;
        Scanner scanner = new Scanner(System.in);
        for (RegistroVenda registroVenda : registroVendas) {
            System.out.print("Digite o dia do mes: ");
            registroVenda.setDiaMes(scanner.nextInt());
            System.out.print("Digite o valor da venda(use virgula para casa decimal): ");
            registroVenda.setValorVenda(scanner.nextDouble());
            total += registroVenda.getValorVenda();
            media += registroVenda.getValorVenda();
            scanner.nextLine();
        }
        media = media/30;
        for(int i = 0;i < registroVendas.length;i++){
            if(registroVendas[i].getValorVenda()>=media){
                valorMais++;
            }
            else{
                valorMenos++;
            }
        }

        System.out.println();
        System.out.println("O total de vendas do mes foi de: " + total);

        System.out.println("Tivemos " + valorMais + " vendas acima da media mensal.");
        System.out.println("Tivemos " + valorMenos + " vendas abaixo da media mensal.");

        System.out.println();

        for (int i = 0;i< registroVendas.length;i++){
            if(registroVendas[i].getValorVenda()>=media){
                System.out.println("Dia " + registroVendas[i].getDiaMes() + " tivemos um valor acima da media, o valor foi de R$" + registroVendas[i].getValorVenda());
            }
            else {
                System.out.println("Dia " + registroVendas[i].getDiaMes() + " tivemos um valor abaixo da media, o valor foi de R$" + registroVendas[i].getValorVenda());
            }
        }

        System.out.println();
        System.out.println("A media do mes foi de: R$" + media);

        scanner.close();
    }
}