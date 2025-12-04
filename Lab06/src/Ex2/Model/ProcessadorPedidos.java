package Ex2.Model;

import Ex2.Model.Pedido;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessadorPedidos {

    private List<Pedido> pedidos;

    public ProcessadorPedidos() {
        // Inicialização dos dados (mesmos dados de teste)
        Item item1 = new Item("Notebook", 2500.00);
        Item item2 = new Item("Mouse", 50.00);
        Item item3 = new Item("Teclado", 150.00);
        Item item4 = new Item("Monitor", 900.00);

        pedidos = Arrays.asList(
                new Pedido("Ana Silva", Arrays.asList(item1), true),
                new Pedido("João Souza", Arrays.asList(item2, item3), false),
                new Pedido("Maria Lima", Arrays.asList(item1, item4), true),
                new Pedido("Pedro Reis", Arrays.asList(item4), true),
                new Pedido("Lara Costa", Arrays.asList(item2, item3, item4), false)
        );
    }

    // Métodos de Processamento (filter, map, discount) - Omitidos por brevidade, mas devem estar na classe

    /**
     * Método VOID para escrever uma String em um arquivo.
     */
    private void escreverEmArquivo(String caminhoArquivo, String conteudo) {
        // Sobrescreve o arquivo (false)
        try (FileWriter fw = new FileWriter(caminhoArquivo, false);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(conteudo);
            System.out.println("\nRelatório de pedidos salvo em '" + caminhoArquivo + "' com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 4. Executa todas as etapas e gera o relatório final em console e arquivo.
     */
    public void gerarRelatorioCompleto() {

        // 1. Executa as operações
        calcularValorTotalPorPedido(); // Calcula e armazena o total em cada pedido
        aplicarDescontos();            // Aplica desconto em pedidos > 1000
        List<Pedido> pagos = filtrarPedidosPagos();
        List<String> clientesAltoValor = filtrarClientesAltoValor();

        // 2. Constrói o relatório
        StringBuilder relatorio = new StringBuilder();
        String separador = "\n=================================================\n";

        relatorio.append("### RELATÓRIO DE PROCESSAMENTO DE PEDIDOS ###").append(separador);

        // Seção: Pedidos Pagos
        relatorio.append(">>> 1. PEDIDOS QUE FORAM PAGOS: <<<\n");
        pagos.forEach(p -> relatorio.append(p.toString()).append("\n"));

        // Seção: Valores Finais (Pós-Desconto) de TODOS os pedidos
        relatorio.append(separador);
        relatorio.append(">>> 2. VALORES TOTAIS (PÓS-DESCONTO DE 10% EM PEDIDOS > R$1000,00): <<<\n");
        pedidos.forEach(p -> relatorio.append(p.toString()).append("\n"));

        // Seção: Clientes com Alto Valor
        relatorio.append(separador);
        relatorio.append(">>> 3. CLIENTES COM PEDIDOS > R$ 1500,00 (Pós-Desconto): <<<\n");
        relatorio.append(clientesAltoValor.toString()).append("\n");
        relatorio.append(separador);

        // 3. Imprime no Console (Para monitoramento)
        System.out.println(relatorio.toString());
        String caminhoCompleto = "C:\\Users\\Gabriel Vicentte\\Downloads\\saida_pedidos.txt";

        // 4. Salva no Arquivo
        escreverEmArquivo(caminhoCompleto, relatorio.toString());
    }


    // **********************************************
    // MÉTODOS DE PROCESSAMENTO (devem ser incluídos aqui)
    // **********************************************

    // 1. Filtrar Pedidos Pagos
    public List<Pedido> filtrarPedidosPagos() {
        return pedidos.stream()
                .filter(Pedido::isPago)
                .collect(Collectors.toList());
    }

    // 2. Calcular Valor Total (Modifica o estado do objeto)
    public void calcularValorTotalPorPedido() {
        pedidos.forEach(pedido -> {
            double total = pedido.getItems().stream()
                    .mapToDouble(Item::getValor)
                    .sum();
            pedido.setValorTotal(total);
        });
    }

    // 3. Aplicar Descontos
    public void aplicarDescontos() {
        double limiteDesconto = 1000.00;
        double taxaDesconto = 0.10;

        pedidos.stream()
                .filter(p -> p.getValorTotal() > limiteDesconto)
                .forEach(p -> {
                    double novoTotal = p.getValorTotal() * (1 - taxaDesconto);
                    p.setValorTotal(novoTotal);
                });
    }

    // 4. Filtrar Clientes com Pedidos Alto Valor
    public List<String> filtrarClientesAltoValor() {
        double limiteAltoValor = 1500.00;

        return pedidos.stream()
                .filter(p -> p.getValorTotal() > limiteAltoValor)
                .map(Pedido::getCliente)
                .collect(Collectors.toList());
    }
}