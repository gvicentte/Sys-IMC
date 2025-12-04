package Ex2.Principal;

import Ex2.Model.Pedido;
import Ex2.Model.ProcessadorPedidos;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProcessadorPedidos processador = new ProcessadorPedidos();
        processador.gerarRelatorioCompleto();
    }
}