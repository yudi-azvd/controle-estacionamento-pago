package cadastro;
    
import java.time.LocalDateTime;

public class Acesso {
    private LocalDateTime dataHora;
    private String placaDoCarro;
  // Data
  // horário
  // placa de carro

  public int diferencaDeTempoEmMinutosEntre(Acesso thatlog) {

    return 0;
  }
  public int diferencaDeTempoEmDiasEntre(Acesso thatlog) {

    return 0;
  }
  public int diferencaDeTempoEmFracaoEntre(Acesso thatlog) {

    return 0;
  }
  public int diferencaDeTempoEmHoraEntre(Acesso thatlog) {

    return 0;
  }
  public int diferencaDeTempoEmPernoiteEntre(Acesso thatlog) {

    return 0;
  }
      public String getPlacaDoCarro() {
        return placaDoCarro;
    }

    public void setPlacaDoCarro(String placaDoCarro) {
        this.placaDoCarro = placaDoCarro;
    }


    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
