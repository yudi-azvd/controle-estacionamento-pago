package pagamento;

import cadastro.Acesso;

public class PagamentoPorFracao extends PagamentoPorHora {

  public double executar(Acesso login, Acesso logout) {
    int diferenca = login.diferencaDeTempoEmMinutosEntre(logout);
    double desconto = calcularDesconto(diferenca);
    return desconto;
  }
 
  protected double calcularDesconto(int diferencaDeTempoEmMinutos) {
    int diferenca = diferencaDeTempoEmMinutos;
    double desconto = 0;
    while(diferenca >= 15){
      diferenca = diferenca - 15;
      desconto = desconto + 0.5;
    }
    desconto = desconto + super.calcularDesconto(diferencaDeTempoEmMinutos);
    return desconto;
  }
}
