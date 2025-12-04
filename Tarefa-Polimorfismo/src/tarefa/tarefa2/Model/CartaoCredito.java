package tarefa.tarefa2.Model;

public class CartaoCredito implements MetodoPagamento{
    private String numeroCartao;
    private String nomeTitular;
    private String validade;

    public CartaoCredito() {
    }

    public CartaoCredito(String numeroCartao, String nomeTitular, String validade) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if(valor>0){
            System.out.println("Pagamento com cartao de credito processado");
            return true;
        }
        else{
            System.out.println("Pagamento com cartao de credito nao processado o valor deve ser positivo");
            return false;
        }
    }
}
