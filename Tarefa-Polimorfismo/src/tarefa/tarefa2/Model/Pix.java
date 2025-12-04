package tarefa.tarefa2.Model;

public class Pix implements MetodoPagamento{
    private String chavePix;

    public Pix() {
    }

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if(valor > 0){
            System.out.println("Pagamento com Pix realizado para a chave " + this.getChavePix());
            return true;
        }
        else{
            System.out.println("Pagamento nao realizado para a chave " + this.getChavePix() + " valor deve ser positivo");
            return false;
        }
    }
}
