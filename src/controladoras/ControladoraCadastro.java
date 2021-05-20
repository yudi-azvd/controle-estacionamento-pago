package controladoras;

import cadastro.Mensalista;
import excecoes.*;
import repositorios.RepositorioDeCarros;
import repositorios.RepositorioDeMensalistas;
import cadastro.Carro;

import java.util.ArrayList;
import java.util.Scanner;


public class ControladoraCadastro {
    private Scanner entradaDoTeclado;
    
    RepositorioDeMensalistas repositorioDeMensalistas = new RepositorioDeMensalistas();
    RepositorioDeCarros repositorioDeCarros = new RepositorioDeCarros();
    
    public ControladoraCadastro(Scanner scanner) {
        entradaDoTeclado = scanner;
    }
    
    public void cadastrarMensalistaECarro() {
        System.out.println("\nCadastre as informações do cliente.\n");
        
        System.out.print("Digite o nome do cliente: ");
        String nome = entradaDoTeclado.nextLine();
        
        System.out.print("Digite o endereço: ");
        String endereco = entradaDoTeclado.nextLine();
        
        System.out.print("Digite o celular: ");
        String celular = entradaDoTeclado.nextLine();
        
        System.out.print("Digite o telefone: ");
        String telefone = entradaDoTeclado.nextLine();
        
        System.out.print("Digite sua CNH: ");
        String saida = entradaDoTeclado.nextLine();	

        int cnh;
        try {
            cnh = Integer.valueOf(saida);	
        } catch (Exception e) {
            throw new DadosPessoaisIncompletosException();
        }
        
        if (nome == null || nome.length() == 0 || endereco == null || endereco.length() == 0
        || celular == null || celular.length() == 0 || telefone == null || telefone.length() == 0 
        || saida == null || saida.length() == 0) {
            throw new DadosPessoaisIncompletosException();
        }

        Mensalista mensalitaExistente=repositorioDeMensalistas.buscarUmComCnh(cnh);
        boolean mensalistaExiste = mensalitaExistente != null; 
        if (mensalistaExiste) {
            throw new CarroNaoExisteException();
        }
        
        Mensalista mensalista = new Mensalista(nome, endereco, celular, telefone, cnh);
        repositorioDeMensalistas.adicionarUm(mensalista);
        
        
        //carro
        System.out.println("\nCadastre as informações do carro.");
        
        System.out.print("Digite o modelo: ");
        String modelo = entradaDoTeclado.nextLine();
        
        System.out.print("Digite a placa: ");
        String placa = entradaDoTeclado.nextLine();
        
        System.out.print("Digite o marca: ");
        String marca = entradaDoTeclado.nextLine();
        
        boolean dadosDoCarroIncompletos = modelo == null || modelo.length() == 0 || placa== null || placa.length() == 0
        || marca == null || marca.length() == 0;
        if (dadosDoCarroIncompletos) {
            throw new DadosVeiculosIncompletosException();
        }

        Carro carroExistente=repositorioDeCarros.buscarUmComPlaca(placa);
        boolean carroExiste = carroExistente != null; 
        if (carroExiste) {
            throw new CarroJaCadastradoException();
        }
        
        Carro carro = new Carro(modelo, placa, marca, cnh );
        repositorioDeCarros.adicionarUm(carro);
        
        // Se tudo deu certo
        System.out.println("Cadastro de mensalista e carro concluído!\n");
    }
    
    public void cadastrarCarro() {
        //carro
        System.out.println("\nCadastre as informações do carro.");
        
        System.out.print("Digite o modelo: ");
        String modelo = entradaDoTeclado.nextLine();
        
        System.out.print("Digite a placa: ");
        String placa = entradaDoTeclado.nextLine();
        
        System.out.print("Digite o marca: ");
        String marca = entradaDoTeclado.nextLine();
        
        boolean dadosDoCarroIncompletos = modelo == null || modelo.length() == 0 || placa== null || placa.length() == 0
        || marca == null || marca.length() == 0;
        if (dadosDoCarroIncompletos) {
            throw new DadosVeiculosIncompletosException();
        }

        Carro carroExistente=repositorioDeCarros.buscarUmComPlaca(placa);
        boolean carroExiste = carroExistente != null; 
        if (carroExiste) {
            throw new CarroJaCadastradoException();
        }
        
        // Construtores podem lançar exceção se faltar informação.
        Carro carro = new Carro(modelo, placa, marca, 0);
        
        repositorioDeCarros.adicionarUm(carro);
        
        // Se tudo deu certo
        System.out.println("Cadastro de carro concluído!\n");
    }

    public void mostrarCarros() {
        ArrayList<Carro> carros = repositorioDeCarros.buscarTodos();

        System.out.println("\nOs carros cadastrados são:");
        int contador = 0;
        for (Carro carro : carros) {
            System.out.println("  " + ++contador + ") "+ carro);
        }

        System.out.println("\nPressione ENTER para voltar ao menu principal.");
        entradaDoTeclado.nextLine();
    }

    public void cadastrarCarroAMensalista(){
        System.out.print("Digite a placa do carro que deseja ser adicinada a mensalista: ");
        String placa = entradaDoTeclado.nextLine();
        Carro carroExistente=repositorioDeCarros.buscarUmComPlaca(placa);
        boolean carroExiste = carroExistente != null; 
        if (!carroExiste) {
            throw new CarroNaoExisteException();
        }
        System.out.print("Digite a CNH do mensalista: ");
        int cnh = entradaDoTeclado.nextInt();
        entradaDoTeclado.nextLine();
        Mensalista mensalistaExistente=repositorioDeMensalistas.buscarUmComCnh(cnh);
        boolean mensalistaExiste = mensalistaExistente != null; 
        if (!mensalistaExiste) {
            throw new MensalistaNaoExisteException();
        }
        repositorioDeCarros.definirCnhParaOCarroComPlaca(cnh, placa);
    }

    public void mostrarMensalistas() {
        ArrayList<Mensalista> mensalistas = repositorioDeMensalistas.buscarTodos();

        if (mensalistas.size() == 0) {
            System.out.println("Nenhum mensalista cadastrado.");
        }
        else {
            int contador = 0;
            System.out.println();
            for (Mensalista mensalista : mensalistas) {
                System.out.println("  " + ++contador + ") " + mensalista);
            }
        }

        System.out.println("\nPressione ENTER para voltar ao menu principal.");
        entradaDoTeclado.nextLine();
    }
}
