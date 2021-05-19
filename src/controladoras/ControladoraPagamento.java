package controladoras;

import java.util.ArrayList;
import java.util.Scanner;

import cadastro.Acesso;
import cadastro.Carro;
import cadastro.Mensalista;
import pagamento.PagamentoPorDiaria;
import pagamento.PagamentoPorMinuto;
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
      System.out.println("Carro não foi encontrado");
      return; 
    }

    boolean carroPertenceMensalista = carro.getMensalistaCnh() != 0;
    if (carroPertenceMensalista) {
      System.out.println("Escolha a opção \"cobrar pagamento de um mensalista\" no menu principal.");
      return;
    }
    
    ArrayList<Acesso> acessos = repositorioDeAcessos.buscarTodosComPlaca(placa);
    Acesso login = acessos.get(0), logout = acessos.get(1);
    double custo = 0;
    int diferencaDeTempoEmMinutos = acessos.get(0).diferencaDeTempoEmMinutosEntre(acessos.get(1));
    int diferencaDeTempoEmDias = acessos.get(0).diferencaDeTempoEmDiasEntre(acessos.get(1));
    int periodoEstacionamentoFechadoEmMinutos = 600;

    if (diferencaDeTempoEmDias != 0){
       diferencaDeTempoEmMinutos = diferencaDeTempoEmMinutos - (diferencaDeTempoEmDias* periodoEstacionamentoFechadoEmMinutos); 
    }
    
    if (diferencaDeTempoEmMinutos >= 540){
      PagamentoPorDiaria pagamentoPorDiaria = new PagamentoPorDiaria();
      custo = pagamentoPorDiaria.executar(login, logout);
    }
    else{
      PagamentoPorMinuto pagamentoPorMinuto = new PagamentoPorMinuto();
      custo = pagamentoPorMinuto.executar(login, logout);
    }

    // calcularPagamento(diferencaDeTempoEmMinutos);
    System.out.println("O custo é R$" + custo);
  }
// 20hrs dia 17/05 =>  19hrs dia 18/05   23hrs => 1380
// pernoite, diaria, 240 minutos
// 30 + 110 + 48 = 188

// 20hrs dia 17/05 =>  19hrs dia 19/05   47hrs => 2820
// 1 pernoite, 1 diaria, 300 minutos, 1 pernoite, diaria, 240 minutos 
// 30 + 110 + 60 + 30 + 110 + 48 = 388;

// 20hrs dia 17/05 =>  7hrs dia 19/05   47hrs => 2820
// 1 pernoite, 1 diaria, 300 minutos, 1 pernoite, 60 minutos 
// 30 + 110 + 60 + 30 + 110 + 48 = 388;


  public void cobrarPagamentoDeMensalista() {
    System.out.print("Digite a cnh do mensalista: ");
    int cnh = sc.nextInt(); sc.nextLine();
    Mensalista mensalista = repositorioDeMensalistas.buscarUmComCnh(cnh);

    if (mensalista == null) {
      System.out.println("Mensalista não encontrado");
    }
    else {
      System.out.println(mensalista.getNome() + ", o preço mensal é de R$ 500");
    }
  }
}
