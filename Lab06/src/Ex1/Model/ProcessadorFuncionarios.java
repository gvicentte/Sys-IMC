package Ex1.Model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessadorFuncionarios {
    // 2. Criação da Lista de Funcionários (com pelo menos 5)
    private List<Funcionario> funcionarios = Arrays.asList(
            new Funcionario("Alice", 35, 3500.00),
            new Funcionario("Bruno", 28, 2800.00),
            new Funcionario("Carlos", 41, 5200.50),
            new Funcionario("Diana", 22, 1950.00),
            new Funcionario("Eduardo", 32, 4100.25)
    );

    // Métodos filtrarPorIdade, mapearParaNomes, calcularSomaSalarios... (Omitidos por brevidade)
    public List<Funcionario> filtrarPorIdade() {
        // [cite: 19, 29]
        return funcionarios.stream()
                .filter(f -> f.getIdade() > 30) // Expressão lambda para filtrar a idade
                .collect(Collectors.toList());
    }

    /**
     * 3.2. Mapeamento: Cria uma nova lista contendo apenas os nomes dos funcionários.
     * Utiliza Stream e lambda (map).
     *
     * @return Lista de Strings contendo apenas os nomes.
     */
    public List<String> mapearParaNomes() {
        // [cite: 20, 29]
        return funcionarios.stream()
                .map(Funcionario::getNome) // Method reference (equivalente a f -> f.getNome())
                .collect(Collectors.toList());
    }

    /**
     * 3.3. Redução: Calcula a soma dos salários de todos os funcionários.
     * Utiliza Stream e operação de redução (mapToDouble + sum).
     *
     * @return Soma total dos salários.
     */
    public double calcularSomaSalarios() {
        // [cite: 21, 29]
        return funcionarios.stream()
                .mapToDouble(Funcionario::getSalario) // Converte para um DoubleStream
                .sum(); // Operação de redução para somar

        // Alternativa com reduce explícito:
    }

    // NOVO MÉTODO: Escreve uma string em um arquivo, sobrescrevendo se necessário.
    private void escreverEmArquivo(String caminhoArquivo, String conteudo) {
        // Usamos 'false' no FileWriter para SOBRESCREVER o arquivo a cada relatório (limpar o relatório anterior)
        try (FileWriter fw = new FileWriter(caminhoArquivo, false);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(conteudo);
            System.out.println("Relatório escrito em '" + caminhoArquivo + "' com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 4. Relatório Final: Implementa o método para exibir E salvar as informações.
     */
    public void gerarRelatorio() {

        // 1. Executa as operações
        List<Funcionario> maioresDe30 = filtrarPorIdade();
        List<String> listaNomes = mapearParaNomes();
        double somaSalarios = calcularSomaSalarios();

        // 2. Constrói o relatório como uma única String (StringBuilder é eficiente para isso)
        StringBuilder relatorio = new StringBuilder();
        String separador = "=================================================\n";

        // Seção 1: Funcionários > 30 anos
        relatorio.append(separador);
        relatorio.append(">>> REQUISITO: Funcionários com idade superior a 30 anos: <<<\n");
        maioresDe30.forEach(f -> relatorio.append(f.toString()).append("\n"));

        // Seção 2: Lista de Nomes
        relatorio.append("\n").append(separador);
        relatorio.append(">>> REQUISITO: Lista de nomes dos funcionários: <<<\n");
        relatorio.append(listaNomes.toString()).append("\n");

        // Seção 3: Soma Total
        relatorio.append("\n").append(separador);
        relatorio.append(">>> REQUISITO: Soma total dos salários: <<<\n");
        relatorio.append(String.format("R$ %.2f%n", somaSalarios));
        relatorio.append(separador);

        // 3. Imprime no Console (Opcional, mas útil para debug)
        System.out.println("\n--- Saída do Programa (Console) ---\n");
        System.out.print(relatorio.toString());

        // 4. Salva no Arquivo
        System.out.println("\n--- Salvando no Arquivo ---\n");
        String caminho = "C:\\Users\\Gabriel Vicentte\\Downloads\\saida.txt";
        String relatorioString = relatorio.toString();
        escreverEmArquivo(caminho, relatorioString);
    }
}