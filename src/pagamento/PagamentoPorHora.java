package pagamento;

import cadastro.Acesso;

public class PagamentoPorHora extends PagamentoPorFracao {
  // placa do carro
  // checkin chekout

/**
logRepositorio.buscarLogsComPlaca(String placadoCarro);
 */

public double executar(Acesso login, Acesso logout) {
    int diferenca = login.diferencaDeTempoEmHoraEntre(logout);
    double custo = calcularCustoDeEstadia(diferenca);
    return custo;
  }

  private double calcularCustoDeEstadia(int diferencaDeTempoEmMinutos) {
    return 0.0;
  }
}
