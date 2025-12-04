package tarefa.tarefa2.Principal;

import tarefa.tarefa2.Model.Boleto;
import tarefa.tarefa2.Model.CartaoCredito;
import tarefa.tarefa2.Model.MetodoPagamento;
import tarefa.tarefa2.Model.Pix;


public class Main {

    public void realizarPagamento(MetodoPagamento metodoPagamento,double valor){
        metodoPagamento.processarPagamento(valor);
    }

    public static void main(String[] args) {
        CartaoCredito cartaoCredito = new CartaoCredito("5502","Renatinho","15/10/2025");
        Boleto boleto = new Boleto("5325238","15/10/2026");
        Pix pix = new Pix("gvicentte10@gmail.com");
        Main main = new Main();
        main.realizarPagamento(cartaoCredito, 10);
        main.realizarPagamento(boleto,500);
        main.realizarPagamento(pix,60);
        main.realizarPagamento(cartaoCredito, -10);
        main.realizarPagamento(boleto,-500);
        main.realizarPagamento(pix,-60);
    }
}