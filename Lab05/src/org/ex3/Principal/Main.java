package org.ex3.Principal;

import org.ex3.Model.DiaTemperatura;

public class Main {
    public static void main(String[] args) {
        DiaTemperatura diaTemperaturas[] = {new DiaTemperatura("Segunda-Feira", 31.5F),
        new DiaTemperatura("Terca-Feira",27.3F),
        new DiaTemperatura("Quarta-Feira",40.5F),
        new DiaTemperatura("Quinta-Feira",-15.7F),
        new DiaTemperatura("Sexta-Feira",4.5F),
        new DiaTemperatura("Sabado",27.9F),
        new DiaTemperatura("Domingo",28.1F)};
        float max = -1000, min = 1000,media = 0;
        int idMax = 0, idMin = 0;
        for(int i = 0; i<diaTemperaturas.length;i++){
            media+=diaTemperaturas[i].getTemperatura();
            if(diaTemperaturas[i].getTemperatura()>max){
                max=diaTemperaturas[i].getTemperatura();
                idMax=i;
            }
            if(diaTemperaturas[i].getTemperatura()<min){
                min=diaTemperaturas[i].getTemperatura();
                idMin=i;
            }
        }
        media=media/7;
        System.out.printf("Temperatura media da semana: %.2f%n", media);
        System.out.println();
        for(int i = idMax;i<=idMax;i++){
            System.out.println("Dia da semana com maior temperatura: " + diaTemperaturas[i].getDiaSemana());
            System.out.println("Temperatura maxima: " + max);
        }
        for (int i = idMin;i<=idMin;i++){
            System.out.println("Dia da semana com menor temperatura: " + diaTemperaturas[i].getDiaSemana());
            System.out.println("Temperatura minima: " + min);
        }
    }
}
