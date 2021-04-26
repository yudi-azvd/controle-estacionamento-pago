package pagamento;

import util.Log;

public class PagamentoPorMinuto extends ModalidadeDePagamento {
  // placa do carro
  // checkin chekout

/**
logRepositorio.buscarLogsComPlaca(String placadoCarro);
 */

public double executar(Log login, Log logout) {
    int diferenca = login.diferencaDeTempoEmMinutosEntre(logout);
    double custo = calcularCustoDeEstadia(diferenca);
    return custo;
  }

  private double calcularCustoDeEstadia(int diferencaDeTempoEmMinutos) {
    return 0.0;
  }
}
