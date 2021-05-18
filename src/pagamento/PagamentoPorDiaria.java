/*
package pagamento;

import cadastro.Acesso;

public class PagamentoPorDiaria extends PagamentoPorHora {
  
  public double executar(Acesso login, Acesso logout) {
    double custo = calcularCustoDeEstadia(diferenca);
    return custo;
  }

  private double calcularCustoDeEstadia(int diferencaDeTempoEmMinutos) {
    double diaria = 110;
    if data_login != data_logout{
      diferenca = diferenca - 600;  // desconto de 10 horas do estacionamento fechado
    }
    if (diferenca > 540){
      diferenca = diferenca - 540;
      diaria = diaria + (diferenca * 0.2);
    }
    return diaria;
  }
}
*/