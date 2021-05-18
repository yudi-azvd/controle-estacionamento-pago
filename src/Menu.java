import java.util.Scanner;

import controladoras.ControladoraCadastro;
import controladoras.ControladoraPagamento;

public class Menu{

    public void executa(){

        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        ControladoraCadastro controladoraCadastro = new ControladoraCadastro(sc);
        ControladoraPagamento controladoraPagamento = new ControladoraPagamento(sc);

        do{
            System.out.println("Para sair digite 0.\nPara cadastrar um mensalista/carro digite 1.");
            opcao = Integer.parseInt(sc.nextLine());
            //System.out.print(opcao);
            switch (opcao){
                case 0:
                    System.out.println("Obrigado por usar nosso programa!");
                    sc.close();
                    break;
                case 1:
                    controladoraCadastro.cadastrarMensalistaECarro();
                    break;
                case 10:
                    controladoraPagamento.cobrarPagamentoDeUmCarro();
                    break;
                case 11:
                    controladoraPagamento.cobrarPagamentoDeMensalista();
                    break;
            }

            
        }while(opcao!=0);

        
    }
}