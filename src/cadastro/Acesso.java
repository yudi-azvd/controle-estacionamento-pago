package cadastro;

import java.time.LocalDateTime;

public class Acesso implements Comparable<Acesso> {
  private LocalDateTime dataHora;
  private String placaDoCarro;

  public Acesso(LocalDateTime dataHora, String placaDoCarro){
    this.dataHora = dataHora;
    this.placaDoCarro = placaDoCarro;
  }
  
  public int diferencaDeTempoEmMinutosEntre(Acesso outroAcesso) {
    int horaEntrada = this.dataHora.getHour();
    int horaSaida = outroAcesso.dataHora.getHour();
    int difHoraEmMinutos = horaSaida * 60 - horaEntrada * 60;
    int minutos = difHoraEmMinutos +  (outroAcesso.dataHora.getMinute() - this.dataHora.getMinute());
    int dias = this.diferencaDeTempoEmDiasEntre(outroAcesso);
    
    while (dias > 0) {
      minutos += 1440;
      dias --;
    }
    
    return minutos;
  }
  
  public int diferencaDeTempoEmDiasEntre(Acesso outroAcesso) {
    return outroAcesso.dataHora.getDayOfYear() - this.dataHora.getDayOfYear();
  }

  public int diferencaDeTempoEmMesesEntre(Acesso outroAcesso) {
    return outroAcesso.dataHora.getMonthValue()- this.dataHora.getMonthValue();
  }

  public String getPlacaDoCarro() {
    return placaDoCarro;
  }
    
  public LocalDateTime getDataHora() {
    return dataHora;
  }
  
  public String toString() {
    String lista =""+placaDoCarro+": "+ dataHora.getDayOfMonth()+"/"+dataHora.getMonthValue()+" "+dataHora.getHour()+"h"+dataHora.getMinute() ;
    return lista; 
  }

  public int compareTo(Acesso outroAcesso){
    return this.dataHora.compareTo(outroAcesso.dataHora);
  }
}
