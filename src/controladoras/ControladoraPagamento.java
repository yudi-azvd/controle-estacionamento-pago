package controladoras;

import java.util.ArrayList;
import java.util.Scanner;

import cadastro.Acesso;
import cadastro.Carro;
import cadastro.Mensalista;
import repositorios.RepositorioDeAcessos;
import repositorios.RepositorioDeCarros;
import repositorios.RepositorioDeMensalistas;

public class ControladoraPagamento {
  private Scanner sc;

  private RepositorioDeCarros repositorioDeCarros = new RepositorioDeCarros();
  private RepositorioDeAcessos repositorioDeAcessos = new RepositorioDeAcessos();
  private RepositorioDeMensalistas repositorioDeMensalistas = new RepositorioDeMensalistas();

  public ControladoraPagamento(Scanner scanner) {
    this.sc = scanner;
  }

  public void cobrarPagamentoDeUmCarro() {
    System.out.print("Digite a placa do carro: ");
    String placa = sc.nextLine();

    Carro carro = repositorioDeCarros.buscarUmComPlaca(placa);

    if (carro == null) {
      // lançar exceção?
    }

    // verificar se o dno do carro é mensalista
    // se sim, escolha a opção de pagamento para mensalistas
    // return;
    
    ArrayList<Acesso> acessos = repositorioDeAcessos.buscarTodosComPlaca(placa);

    int diferencaDeTempoEmMinutos = acessos.get(0).diferencaDeTempoEmMinutosEntre(acessos.get(1));

    double custo = 0;
    // calcularPagamento(diferencaDeTempoEmMinutos);
    System.out.println("O custo é R$" + custo);
  }

  public void cobrarPagamentoDeMensalista() {
    System.out.print("Digite a cnh do mensalista: ");
    int cnh = sc.nextInt(); sc.nextLine();
    Mensalista mensalista = repositorioDeMensalistas.buscarUmComCnh(cnh);

    if (mensalista == null) {
      System.out.println("Mensalista não encontrado");
    }
    else {
      System.out.println("Nome do mensalista é " + mensalista.getNome());
    }
  }
}
