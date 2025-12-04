package tarefa.tarefa3.Model;

public class EmailNotificacao implements Notificacao{
    private String enderecoEmail;

    public EmailNotificacao() {
    }

    public EmailNotificacao(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando e-mail para " + this.getEnderecoEmail() + ": "+ mensagem);
    }
}
