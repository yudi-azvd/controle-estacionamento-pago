package pagamento;

import cadastro.Acesso;

public class PagamentoPorHora extends ModalidadeDePagamento {

  public double executar(Acesso login, Acesso logout) {
    int diferenca = login.diferencaDeTempoEmMinutosEntre(logout);
    double desconto = calcularDesconto(diferenca);
    return desconto;
  }

  protected double calcularDesconto(int diferencaDeTempoEmMinutos) {
    int diferenca = diferencaDeTempoEmMinutos;
    double desconto = 0;
    while(diferenca >= 60){
      diferenca = diferenca - 60;
      desconto = desconto + 1;
    }

    return desconto;
  }
}
