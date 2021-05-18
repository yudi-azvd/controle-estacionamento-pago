import java.util.Scanner;

import controladoras.ControladoraCadastro;
import controladoras.ControladoraPagamento;

public class Menu {
    public void executa() {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        ControladoraCadastro controladoraCadastro = new ControladoraCadastro(sc);
        ControladoraPagamento controladoraPagamento = new ControladoraPagamento(sc);

        do {
            System.out.println();
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar um mensalista/carro");
            System.out.println("2 - Cobrar pagamento de um carro");
            System.out.println("3 - Cobrar pagamento de um mensalista");
            System.out.print("\nEscolha uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 0:
                    System.out.println("\nObrigado por usar nosso programa! Até mais :)");
                    sc.close();
                    break;
                case 1:
                    controladoraCadastro.cadastrarMensalistaECarro();
                    break;
                case 2:
                    controladoraPagamento.cobrarPagamentoDeUmCarro();
                    break;
                case 3:
                    controladoraPagamento.cobrarPagamentoDeMensalista();
                    break;
            }
        } while (opcao != 0);
    }
}