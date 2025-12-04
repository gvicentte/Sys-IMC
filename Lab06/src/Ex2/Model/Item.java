package Ex2.Model;

public class Item {
    private String nomeProduto; // Atributo: nomeProduto
    private double valor;       // Atributo: double valor

    public Item(String nomeProduto, double valor) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
