package org.ex3.Model;

public class DiaTemperatura {
    private String diaSemana;
    private float temperatura;

    public DiaTemperatura() {
    }

    public DiaTemperatura(String diaSemana, float temperatura) {
        this.diaSemana = diaSemana;
        this.temperatura = temperatura;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
}
