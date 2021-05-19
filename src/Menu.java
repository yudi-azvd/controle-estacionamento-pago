import java.util.Scanner;

import controladoras.ControladoraAcesso;
import controladoras.ControladoraCadastro;
import controladoras.ControladoraPagamento;

public class Menu {
    Scanner entradaDoTeclado = new Scanner(System.in);
    ControladoraCadastro controladoraCadastro = new ControladoraCadastro(entradaDoTeclado);
    ControladoraPagamento controladoraPagamento = new ControladoraPagamento(entradaDoTeclado);
    ControladoraAcesso controladoraAcesso = new ControladoraAcesso(entradaDoTeclado);

    public void executa() {
        int opcao = 0;

        do {
            try {
                mostrarOpcoes();
                opcao = lerOpcao();
                lidarComOpcao(opcao);
            } catch (RuntimeException e) {
                System.out.println("\n######################");
                System.out.println("# " + e.getMessage() + "!");
                System.out.println("#");
                System.out.println("# Pressione ENTER para continuar");
                System.out.println("######################");
                entradaDoTeclado.nextLine();

                // System.out.println(e);
                // System.out.println(e.getStackTrace());
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
        System.out.println("5 - Registrar acesso de carro");
        System.out.println("6 - Listar todos os acessos");
        System.out.println("7 - Listar todos os carros");
        System.out.print("\nEscolha uma opção: ");
    }

    public int lerOpcao() {
        int opcao = Integer.parseInt(entradaDoTeclado.nextLine());
        return opcao;
    }

    public void lidarComOpcao(int opcao) {
        switch (opcao) {
            case 0:
                System.out.println("\nObrigado por usar nosso programa! Até mais :)");
                entradaDoTeclado.close();
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
            case 5:
                controladoraAcesso.cadastrarAcesso();
                break;
            case 6:
                controladoraAcesso.listarTodos();
                break;
            case 7:
                controladoraCadastro.mostrarCarros();
                break;
        }
    }
}