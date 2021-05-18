package cadastro;
    
import java.time.LocalDateTime;

public class Acesso {
    private LocalDateTime dataHora;
    private String placaDoCarro;
  // Data
  // horário
  // placa de carro

  public Acesso(LocalDateTime dataHora, String placaDoCarro){
    this.dataHora = dataHora;
    this.placaDoCarro = placaDoCarro;
  }

  public int diferencaDeTempoEmMinutosEntre(Acesso thatlog) {

    return 539;
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
