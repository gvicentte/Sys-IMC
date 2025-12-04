package org.ex4.Model;

public class RegistroVenda {
    private int diaMes;
    private double valorVenda;

    public RegistroVenda() {
    }

    public RegistroVenda(int diaMes, double valorVenda) {
        this.diaMes = diaMes;
        this.valorVenda = valorVenda;
    }

    public int getDiaMes() {
        return diaMes;
    }

    public void setDiaMes(int diaMes) {
        this.diaMes = diaMes;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
