import java.util.Scanner;

import controladoras.ControladoraCadastro;

public class Menu{

    public void executa(){

        int opcao = 0;
        
        ControladoraCadastro controladoraCadastro = new ControladoraCadastro();

        do{
            Scanner sc = new Scanner(System.in);
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
                    sc.close();
                break;
            }

            
        }while(opcao!=0);

        
    }
}