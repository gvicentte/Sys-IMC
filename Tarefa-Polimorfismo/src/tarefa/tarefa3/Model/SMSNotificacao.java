package tarefa.tarefa3.Model;

public class SMSNotificacao implements Notificacao{
    private String numeroTelefone;

    public SMSNotificacao() {
    }

    public SMSNotificacao(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS para " + this.getNumeroTelefone() + ": " + mensagem);
    }
}
