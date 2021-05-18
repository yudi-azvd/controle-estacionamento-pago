package controladoras;

import java.util.ArrayList;
import java.util.Scanner;

import cadastro.Acesso;
import cadastro.Carro;
import repositorios.RepositorioDeAcessos;
import repositorios.RepositorioDeCarros;

public class ControladoraPagamento {
  private Scanner sc;

  private RepositorioDeCarros repositorioDeCarros = new RepositorioDeCarros();

  private RepositorioDeAcessos repositorioDeAcessos = new RepositorioDeAcessos();

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
    int diferencaDeTempoEmDias = acessos.get(0).diferencaDeTempoEmDiasEntre(acessos.get(1));
    
    // if (diferencaDeTempoEmDias != 0){
    //    diferenca = diferenca - (diferencaDeTempoEmDias* periodoEstacionamentoFechadoEmMinutos); 
    // }
    
    // if (diferencaDeTempoEmMinutosEntre >= 540){
    //   manda pagamentoPorDiaria
    // }
    // else{
    //   manda pagamentoPorMinutos
    // }
    double custo = 0;
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
    System.out.print("o valor mensal de um mensalista é de 500 R$.");
   
  }
}
