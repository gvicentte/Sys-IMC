package Ex2.Model;

import java.util.List;

public class Pedido {
    private String cliente;         // Atributo: String cliente
    private List<Item> itens;       // Atributo: List<Item> itens
    private boolean pago;           // Atributo: boolean pago
    private double valorTotal = 0.0; // Atributo para armazenar o valor calculado

    public Pedido(String cliente, List<Item> itens, boolean pago) {
        this.cliente = cliente;
        this.itens = itens;
        this.pago = pago;
    }

    // Getters
    public String getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return itens;
    }

    public boolean isPago() {
        return pago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    // Setter para o valor total (usado após o cálculo)
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente='" + cliente + '\'' +
                ", pago=" + pago +
                ", valorTotal=" + String.format("R$ %.2f", valorTotal) +
                '}';
    }
}
