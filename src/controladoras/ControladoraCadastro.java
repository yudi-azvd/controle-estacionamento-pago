package controladoras;

import cadastro.Mensalista;
import excecoes.*;
import repositorios.RepositorioDeCarros;
import repositorios.RepositorioDeMensalistas;
import cadastro.Carro;
import java.util.Scanner;


public class ControladoraCadastro {
    private Scanner entradaDoTeclado;

    RepositorioDeMensalistas repositorioDeMensalistas = new RepositorioDeMensalistas();
    RepositorioDeCarros repositorioDeCarros = new RepositorioDeCarros();
   
    public ControladoraCadastro(Scanner scanner) {
        entradaDoTeclado = scanner;
    }
    
	public void cadastrarMensalistaECarro() {


		try{
			//mensalista        

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
			
			if (nome == null || nome.length() == 0 || endereco == null || endereco.length() == 0
            || celular == null || celular.length() == 0 || telefone == null || telefone.length() == 0 
            || saida == null || saida.length() == 0) {
				throw new DadosAcessoIncompletosException();
			}

			int cnh = Integer.valueOf(saida);

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

            if (modelo == null || modelo.length() == 0 || placa== null || placa.length() == 0
            || marca == null || marca.length() == 0) {
				throw new DadosVeiculosIncompletosException();
			}

            // Construtores podem lançar exceção se faltar informação.
        
            Carro carro = new Carro(modelo, placa, marca, cnh );
            repositorioDeCarros.adicionarUm(carro);

            // Se tudo deu certo
            System.out.println("Cadastro de mensalista e carro concluído!\n");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}          
    }

	public void cadastrarCarro() {
               
		try {

            //carro
	        System.out.println("\nCadastre as informações do carro.");

            System.out.print("Digite o modelo: ");
	        String modelo = entradaDoTeclado.nextLine();

            System.out.print("Digite a placa: ");
	        String placa = entradaDoTeclado.nextLine();

            System.out.print("Digite o marca: ");
            String marca = entradaDoTeclado.nextLine();

            if (modelo == null || modelo.length() == 0 || placa== null || placa.length() == 0
            || marca == null || marca.length() == 0) {
				throw new DadosVeiculosIncompletosException();
			}

            // Construtores podem lançar exceção se faltar informação.
            Carro carro = new Carro(modelo, placa, marca, 0);

            repositorioDeCarros.adicionarUm(carro);

            // Se tudo deu certo
			System.out.println("Cadastro de carro concluído!\n");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
    }
}
