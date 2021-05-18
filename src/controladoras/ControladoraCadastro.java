package controladoras;

import cadastro.Mensalista;
import repositorios.RepositorioDeCarros;
import repositorios.RepositorioDeMensalistas;
import cadastro.Carro;
import java.util.Scanner;


public class ControladoraCadastro {
    private Scanner sc;

    RepositorioDeMensalistas repositorioDeMensalistas = new RepositorioDeMensalistas();
    RepositorioDeCarros repositorioDeCarros = new RepositorioDeCarros();
   
    public ControladoraCadastro(Scanner scanner) {
        sc = scanner;
    }
    
    public void cadastrarMensalistaECarro() {
        //mensalista        
        System.out.println("\nCadastre as informações do cliente.\n");
        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Digite o endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Digite o celular: ");
        String celular = sc.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Digite sua CNH: ");
        int cnh = sc.nextInt();
        sc.nextLine(); // pegar '\n' do buffer

        
        //carro
        System.out.println("\nCadastre as informações do carro.");
        System.out.print("Digite o modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Digite a placa: ");
        String placa = sc.nextLine();
        System.out.print("Digite o marca: ");
        String marca = sc.nextLine();

        // Construtores podem lançar exceção se faltar informação.
        Mensalista mensalista = new Mensalista(nome, endereco, celular, telefone, cnh);
        Carro carro = new Carro(modelo, placa, marca);

        repositorioDeMensalistas.adicionarUm(mensalista);
        repositorioDeCarros.adicionarUm(carro);

        // Se tudo deu certo
        System.out.println("Cadastro de mensalista e carro concluído!\n");
    }
    public void cadastrarCarro() {
               
        //carro
        System.out.println("\nCadastre as informações do carro.");
        System.out.print("Digite o modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Digite a placa: ");
        String placa = sc.nextLine();
        System.out.print("Digite o marca: ");
        String marca = sc.nextLine();

        // Construtores podem lançar exceção se faltar informação.
        Carro carro = new Carro(modelo, placa, marca);

        repositorioDeCarros.adicionarUm(carro);

        // Se tudo deu certo
        System.out.println("Cadastro de carro concluído!\n");
    }
}
