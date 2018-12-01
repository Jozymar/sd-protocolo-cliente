import connect.ClientAccess;
import model.TextMessage;

import java.io.IOException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao chat!");
        System.out.println("Informe seu nome:");
        String nome = scanner.nextLine();

        System.out.println("Informe o caminho do seu inbox(pasta local):");
        String inbox = scanner.nextLine();

        System.out.println("Informe o caminho seu outbox(pasta montada):");
        String outbox = scanner.nextLine();

        ClientAccess cliente = new ClientAccess(nome, inbox, outbox);
        System.out.println("Abrindo o chat...");

        cliente.start();
        System.out.println("Chat iniciado, você já pode escrever suas mensagens...");

        while (true) {
            String mensagem = scanner.nextLine();
            cliente.sendMessage(new TextMessage(mensagem));
        }
    }
}
