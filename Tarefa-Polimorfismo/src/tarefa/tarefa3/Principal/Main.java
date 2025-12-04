package tarefa.tarefa3.Principal;

import tarefa.tarefa3.Model.EmailNotificacao;
import tarefa.tarefa3.Model.Notificacao;
import tarefa.tarefa3.Model.PushNotificacao;
import tarefa.tarefa3.Model.SMSNotificacao;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Notificacao> notificacaos = new ArrayList<>();
        EmailNotificacao emailNotificacao = new EmailNotificacao("gvicentte10@gmail.com");
        SMSNotificacao smsNotificacao = new SMSNotificacao("62 99833-2981");
        PushNotificacao pushNotificacao = new PushNotificacao("2539 Samsung");
        notificacaos.add(emailNotificacao);
        notificacaos.add(smsNotificacao);
        notificacaos.add(pushNotificacao);
        for(int i = 0; i<notificacaos.size();i++){
            if (i == 0) {
                notificacaos.get(i).enviar("Ola Mundo!");
            }
            else if(i == 1){
                notificacaos.get(i).enviar("Gostaria de contratar voce!");
            }
            else {
                notificacaos.get(i).enviar("Token para seu dispositivo.");
            }
        }
    }
}
