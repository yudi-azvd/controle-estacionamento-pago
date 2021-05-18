package controladoras;

import cadastro.Mensalista;
import cadastro.Carro;
import java.util.Scanner;


public class ControladoraCadastro {
    private Scanner sc;
   
    public ControladoraCadastro(Scanner scanner) {
        sc = scanner;
    }
    
    public void cadastrarMensalistaECarro(){
        //mensalista        
        System.out.println("Digite o nome");
        String nome = (sc.nextLine());
        System.out.println("Digite o endereco");
        String endereco = (sc.nextLine());
        System.out.println("Digite o celular");
        String celular = (sc.nextLine());
        System.out.println("Digite o telefone");
        String telefone = (sc.nextLine());
        System.out.println("Digite sua CNH");
        int cnh = (sc.nextInt());
        System.out.println("Cadastro de mensalista concluído!");
        System.out.println("");
        System.out.println("Cadastre as informações do carro");
        
        //carro
        System.out.println("");
        sc.nextLine();
        System.out.println("Digite o modelo:");
        String modelo = sc.nextLine();
        System.out.println("Digite a placa");
        String placa = (sc.nextLine());
        System.out.println("Digite o marca");
        String marca = (sc.nextLine());

        Mensalista mensalista = new Mensalista(nome, endereco, celular, telefone, cnh);
        Carro carro = new Carro(modelo, placa, marca);

    }
}
