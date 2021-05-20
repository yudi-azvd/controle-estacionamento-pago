import java.util.Scanner;

import controladoras.ControladoraAcesso;
import controladoras.ControladoraCadastro;
import controladoras.ControladoraPagamento;
import excecoes.OpcaoInvalidaException;

public class Menu {
    Scanner entradaDoTeclado = new Scanner(System.in);
    ControladoraCadastro controladoraCadastro = new ControladoraCadastro(entradaDoTeclado);
    ControladoraPagamento controladoraPagamento = new ControladoraPagamento(entradaDoTeclado);
    ControladoraAcesso controladoraAcesso = new ControladoraAcesso(entradaDoTeclado);

    public void executa() {
        int opcao = -1;

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
            }
        } while (opcao != 0);
    }

    public void mostrarOpcoes() {
        System.out.println();
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar um mensalista/carro");
        System.out.println("2 - Cadastrar um carro");
        System.out.println("3 - Cadastrar acesso de carro");
        System.out.println("4 - Associar um carro a mensalista");
        System.out.println("5 - Cobrar pagamento de um carro");
        System.out.println("6 - Cobrar pagamento de um mensalista");
        System.out.println("7 - Listar todos os acessos");
        System.out.println("8 - Listar todos os carros");
        System.out.println("9 - Listar todos os mensalistas");
        System.out.print("\nEscolha uma opção: ");
    }

    public int lerOpcao() {
        int opcao = -1;
        try {
            opcao = Integer.parseInt(entradaDoTeclado.nextLine());
        } catch (NumberFormatException e) {
            throw new OpcaoInvalidaException();
        }
        boolean opcaoDentroDosLimites = 0 <= opcao && opcao <= 8;
        if (!opcaoDentroDosLimites) 
            throw new OpcaoInvalidaException();
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
                controladoraAcesso.cadastrarAcesso();
                break;
            case 4:
                controladoraCadastro.cadastrarCarroAMensalista();
                break;
            case 5:
                controladoraPagamento.cobrarPagamentoDeUmCarro();
                break;
            case 6:
                controladoraPagamento.cobrarPagamentoDeMensalista();
                break;
            case 7:
                controladoraAcesso.listarTodos();
                break;
            case 8:
                controladoraCadastro.mostrarCarros();
                break;
            case 9:
                controladoraCadastro.mostrarMensalistas();
                break;
        }
    }
}