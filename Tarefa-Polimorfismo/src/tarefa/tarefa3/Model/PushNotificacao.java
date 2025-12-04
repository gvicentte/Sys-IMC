package tarefa.tarefa3.Model;

public class PushNotificacao implements Notificacao{
    private String tokenDispositivo;

    public PushNotificacao() {
    }

    public PushNotificacao(String tokenDispositivo) {
        this.tokenDispositivo = tokenDispositivo;
    }

    public String getTokenDispositivo() {
        return tokenDispositivo;
    }

    public void setTokenDispositivo(String tokenDispositivo) {
        this.tokenDispositivo = tokenDispositivo;
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando notificacao push para o dispositivo " + this.getTokenDispositivo() + ": " + mensagem);
    }
}
