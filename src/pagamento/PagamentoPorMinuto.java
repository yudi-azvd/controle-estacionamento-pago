package pagamento;
import java.time.LocalDateTime;
import cadastro.Acesso;

public class PagamentoPorMinuto extends PagamentoPorFracao {

  public double executar(Acesso login, Acesso logout) {
    int diferenca = login.diferencaDeTempoEmMinutosEntre(logout);
    double custo = calcularCustoDeEstadia(diferenca);
    return custo;
  }

  private double calcularCustoDeEstadia(int diferencaDeTempoEmMinutos) {
    int diferenca = diferencaDeTempoEmMinutos;
    double preco = 0;
    preco = diferenca * 0.5;
    preco = preco - super.calcularDesconto(diferencaDeTempoEmMinutos);
    return preco;
  }
  public static void main(String[] args) {
    PagamentoPorMinuto pagamento = new PagamentoPorMinuto();
    Acesso login = new Acesso(LocalDateTime.of(2017,2,13,15,0),"abc5");
    Acesso logout = new Acesso(LocalDateTime.of(2017,2,13,15,5),"abc5"); 
    System.out.println(pagamento.executar(login, logout));

  } 

}
