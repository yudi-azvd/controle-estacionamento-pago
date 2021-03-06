package pagamento;

// import java.time.LocalDateTime;
import cadastro.Acesso;

public class PagamentoPorMinuto extends PagamentoPorFracao {
  public double executar(Acesso acessoEntrada, Acesso acessoSaida) {
    int diferenca = acessoEntrada.diferencaDeTempoEmMinutosEntre(acessoSaida);
    int dias = acessoEntrada.diferencaDeTempoEmDiasEntre(acessoSaida);
    double custo = calcularCustoDeEstadia(diferenca, dias);
    return custo;
  }

  private double calcularCustoDeEstadia(int diferencaDeTempoEmMinutos, int diferencaDeTempoEmDias) {
    double preco = 0;
    int periodoEstacionamentoFechadoEmMinutos = 600;
    double precoPorMinuto = 0.5;
    double precoPorNoite = 30;

    if (diferencaDeTempoEmDias != 0) {
      diferencaDeTempoEmMinutos = diferencaDeTempoEmMinutos - (diferencaDeTempoEmDias* periodoEstacionamentoFechadoEmMinutos); 
    }
    
    preco = diferencaDeTempoEmMinutos * precoPorMinuto;
    // double desconto  = super.calcularDesconto(diferencaDeTempoEmMinutos);
    double desconto  = super.calcularDesconto(diferencaDeTempoEmMinutos);
    preco = preco - desconto + (diferencaDeTempoEmDias*precoPorNoite);
    return preco;
  }

//   public static void main(String[] args) {
//     PagamentoPorMinuto pagamento = new PagamentoPorMinuto();
//     Acesso login = new Acesso(LocalDateTime.of(2017,2,13,15,0),"abc5");
//     Acesso logout = new Acesso(LocalDateTime.of(2017,2,13,15,5),"abc5"); 
//     System.out.println(pagamento.executar(login, logout));
//   } 
}
