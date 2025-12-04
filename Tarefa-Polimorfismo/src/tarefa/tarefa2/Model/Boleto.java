package tarefa.tarefa2.Model;

public class Boleto implements MetodoPagamento{
    private String codigoBarra;
    private String dataVencimento;

    public Boleto() {
    }

    public Boleto(String codigoBarra, String dataVencimento) {
        this.codigoBarra = codigoBarra;
        this.dataVencimento = dataVencimento;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if(valor>0){
            System.out.println("Pagamento com boleto gerado. Pague ate " + this.getDataVencimento());
            return true;
        }
        else{
            System.out.println("Pagamento com boleto nao gerado, valor negativo");
            return false;
        }
    }
}
