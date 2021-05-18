import java.util.Scanner;

import controladoras.ControladoraCadastro;
import controladoras.ControladoraPagamento;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ControladoraCadastro controladoraCadastro = new ControladoraCadastro(sc);
    ControladoraPagamento controladoraPagamento = new ControladoraPagamento(sc);

    public void executa() {
        int opcao = 0;

        do {
            try {
                mostrarOpcoes();
                opcao = Integer.parseInt(sc.nextLine());
                lidarComOpcao(opcao);
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (opcao != 0);
    }

    public void mostrarOpcoes() {
        System.out.println();
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar um mensalista/carro");
        System.out.println("2 - Cadastrar um carro");
        System.out.println("3 - Cobrar pagamento de um carro");
        System.out.println("4 - Cobrar pagamento de um mensalista");
        System.out.print("\nEscolha uma opção: ");
    }

    public void lidarComOpcao(int opcao) {
        switch (opcao) {
            case 0:
                System.out.println("\nObrigado por usar nosso programa! Até mais :)");
                sc.close();
                break;
            case 1:
                controladoraCadastro.cadastrarMensalistaECarro();
                break;
            case 2:
                controladoraCadastro.cadastrarCarro();
                break;    
            case 3:
                controladoraPagamento.cobrarPagamentoDeUmCarro();
                break;
            case 4:
                controladoraPagamento.cobrarPagamentoDeMensalista();
                break;
        }
    }
}