package controladoras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import cadastro.Acesso;
import cadastro.Carro;
import cadastro.Mensalista;
import excecoes.MensalistaNaoExisteException;
import pagamento.PagamentoPorDiaria;
import pagamento.PagamentoPorMinuto;
import repositorios.RepositorioDeAcessos;
import repositorios.RepositorioDeCarros;
import repositorios.RepositorioDeMensalistas;

public class ControladoraPagamento {
  private Scanner entradaDoTeclado;
  
  private RepositorioDeCarros repositorioDeCarros = new RepositorioDeCarros();
  private RepositorioDeAcessos repositorioDeAcessos = new RepositorioDeAcessos();
  private RepositorioDeMensalistas repositorioDeMensalistas = new RepositorioDeMensalistas();
  
  public ControladoraPagamento(Scanner scanner) {
    this.entradaDoTeclado = scanner;
  }
  
  public void cobrarPagamentoDeUmCarro() {
    System.out.print("\nDigite a placa do carro: ");
    String placa = entradaDoTeclado.nextLine();
    
    Carro carro = repositorioDeCarros.buscarUmComPlaca(placa);
    
    if (carro == null) {
      System.out.println("Carro não foi encontrado");
      return; 
    }
    
    boolean carroPertenceMensalista = carro.getMensalistaCnh() != 0;
    if (carroPertenceMensalista) {
      System.out.println("\nEscolha a opção \"cobrar pagamento de um mensalista\" no menu principal.");
      System.out.println("Pressione ENTER para continuar.");
      entradaDoTeclado.nextLine();
      return;
    }
    
    ArrayList<Acesso> acessos = repositorioDeAcessos.buscarTodosComPlaca(placa);
    Acesso acessoEntrada = acessos.get(0), acessoSaida = acessos.get(1);
    double custo = 0;
    int diferencaDeTempoEmMinutos = acessoEntrada.diferencaDeTempoEmMinutosEntre(acessoSaida);
    int diferencaDeTempoEmDias = acessoEntrada.diferencaDeTempoEmDiasEntre(acessoSaida);
    int periodoEstacionamentoFechadoEmMinutos = 600;
    
    if (diferencaDeTempoEmDias != 0){
      diferencaDeTempoEmMinutos = diferencaDeTempoEmMinutos - (diferencaDeTempoEmDias * periodoEstacionamentoFechadoEmMinutos); 
    }
    
    if (diferencaDeTempoEmMinutos >= 540){
      PagamentoPorDiaria pagamentoPorDiaria = new PagamentoPorDiaria();
      custo = pagamentoPorDiaria.executar(acessoEntrada, acessoSaida);
    }
    else{
      PagamentoPorMinuto pagamentoPorMinuto = new PagamentoPorMinuto();
      custo = pagamentoPorMinuto.executar(acessoEntrada, acessoSaida);
    }
    repositorioDeAcessos.apagarTodosComPlaca(placa);
    
    // calcularPagamento(diferencaDeTempoEmMinutos);
    System.out.println("O custo é de R$" + custo);
    System.out.println("\nPressione ENTER para voltar ao Menu Principal.");
    entradaDoTeclado.nextLine();
  }
  
  public void cobrarPagamentoDeMensalista() {
    double custo=0;
    final double precoPorMes = 500;
    System.out.print("\nDigite a CNH do mensalista: ");
    int cnh = entradaDoTeclado.nextInt(); entradaDoTeclado.nextLine();
    Mensalista mensalista = repositorioDeMensalistas.buscarUmComCnh(cnh);
    ArrayList<Carro> carrosDoMensalista = repositorioDeCarros.buscarTodosComCnh(cnh);

    ArrayList<String> placasDosCarros = new ArrayList<>();
    for (Carro carro : carrosDoMensalista){
      placasDosCarros.add(carro.getPlaca());
    }

    ArrayList<Acesso> acessosDeUmMensalista = new ArrayList<>();
    for (String placa : placasDosCarros) {
      acessosDeUmMensalista.addAll(repositorioDeAcessos.buscarTodosComPlaca(placa));
    }
    List <Acesso> acessos = acessosDeUmMensalista;
    Collections.sort(acessos);
    Acesso acessoAntigo = acessos.get(0);
    Acesso acessoRecente = acessos.get(acessos.size() - 1 );
    int diferencaDeTempoEmMeses = acessoAntigo.diferencaDeTempoEmMesesEntre(acessoRecente);

    if (mensalista == null) {
      throw new MensalistaNaoExisteException();
    }
    else {
      int contador = 0;
      System.out.println("Acessos:");
      for (Acesso acesso : acessos) {
        System.out.println("  " + ++contador + ") " + acesso);      
      }  
      custo = precoPorMes + precoPorMes * diferencaDeTempoEmMeses; 
      System.out.format("\n%s, o preço é de R$ %.2f", mensalista.getNome() , custo);
    }
    
    System.out.println("\nPressione ENTER para voltar ao Menu Principal.");
    entradaDoTeclado.nextLine();
  }
}
