package controladoras;

import java.time.LocalDateTime;
import java.util.Scanner;

import cadastro.Acesso;
import repositorios.RepositorioDeAcessos;

public class ControladoraAcesso {
    private Scanner sc;
    RepositorioDeAcessos repositorioDeAcessos = new RepositorioDeAcessos();

    public ControladoraAcesso(Scanner scanner) {
        sc = scanner;
    }
    public void cadastrarAcesso() {
        System.out.println("\nDigite a placa do carro.");
        String placa = sc.nextLine();
        System.out.print("Digite o dia do acesso: ");
        int dia = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite a hora do acesso: ");
        int hora = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o minuto do acesso: ");
        int minuto = sc.nextInt();
        sc.nextLine();

        int anoPadrao=2020;
        int mesPadrao=5;
        LocalDateTime dateTime = LocalDateTime.of(anoPadrao, mesPadrao, dia, hora, minuto, 0);
        Acesso acesso = new Acesso(dateTime, placa);
        repositorioDeAcessos.adicionarUm(acesso);
    }
}
