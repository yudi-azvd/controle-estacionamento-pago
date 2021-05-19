
package pagamento;

import cadastro.Acesso;

public class PagamentoPorDiaria{
  
  public double executar(Acesso login, Acesso logout) {
    int diferenca = login.diferencaDeTempoEmMinutosEntre(logout);
    int dias = login.diferencaDeTempoEmDiasEntre(logout);
    double custo = calcularCustoDeEstadia(diferenca,dias);
    return custo;
  }

  private double calcularCustoDeEstadia(int diferencaDeTempoEmMinutos, int diferencaDeTempoEmDias) {
    int diferenca = diferencaDeTempoEmMinutos;
    double diaria;
    int periodoEstacionamentoFechadoEmMinutos = 600;
    int minutosEmUmaDiaria = 540;
    double precoPorNoite = 30;
    double precoPorDiaria = 110;
    double precoPorMinutoExtra = 0.2;

    if (diferencaDeTempoEmDias != 0) {
      diferenca = diferenca - (diferencaDeTempoEmDias* periodoEstacionamentoFechadoEmMinutos); 
    }
    else {
      diferenca -= minutosEmUmaDiaria;
      return precoPorDiaria + diferenca*precoPorMinutoExtra;
    }

    diferenca = diferenca - (diferencaDeTempoEmDias*minutosEmUmaDiaria);
    diaria = (diferencaDeTempoEmDias*precoPorNoite)+(diferencaDeTempoEmDias*precoPorDiaria) + (diferenca * precoPorMinutoExtra);
    return diaria;
  }
}