import java.util.Scanner;

import controladoras.ControladoraCadastro;

public class Menu{

    public void executa(){

        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        ControladoraCadastro controladoraCadastro = new ControladoraCadastro();

        do{

            System.out.println("Para sair digite 0.\nPara cadastrar um mensalista/carro digite 1.");
            opcao = sc.nextInt();
            //System.out.print(opcao);
            switch (opcao){
                case 0:
                    System.out.println("Obrigado por usar nosso programa!");
                break;
                
                case 1:
                    controladoraCadastro.cadastrarMensalistaECarro();
                break;
            }

            
        }while(opcao!=0);

        sc.close();
    }
}