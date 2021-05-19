package cadastro;

import java.time.LocalDateTime;

public class Acesso {
  private LocalDateTime dataHora;
  private String placaDoCarro;

  public Acesso(LocalDateTime dataHora, String placaDoCarro){
    this.dataHora = dataHora;
    this.placaDoCarro = placaDoCarro;
  }
  
  public int diferencaDeTempoEmMinutosEntre(Acesso outroAcesso) {
    int horaEntrada = this.dataHora.getHour();
    int horaSaida = outroAcesso.getDataHora().getHour();
    int difHoraEmMinutos = horaSaida * 60 - horaEntrada * 60;
    int minutos = difHoraEmMinutos +  (outroAcesso.getDataHora().getMinute() - this.dataHora.getMinute());
    int dias = this.diferencaDeTempoEmDiasEntre(outroAcesso);
    
    while (dias > 0) {
      minutos += 1440;
      dias --;
    }
    
    return minutos;
  }
  
  public int diferencaDeTempoEmDiasEntre(Acesso outroAcesso) {
    
    return outroAcesso.getDataHora().getDayOfMonth() - this.dataHora.getDayOfMonth();
    

  }

  // public int diferencaDeTempoEmMeses(Acesso outroAcesso) {

  //   return outroAcesso.getDataHora().get() - this.dataHora.getDayOfMonth();
  // }

  // public int diferencaDeTempoEmAnos(Acesso outroAcesso) {

  //   return 
  // }
  
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

  public String toString() {
    String lista =""+placaDoCarro+": "+ dataHora.getDayOfMonth()+"/"+dataHora.getMonth()+" "+dataHora.getHour()+"h"+dataHora.getMinute() ;
    return lista; 
  }

  // public static void main(String[] args) {
  //   LocalDateTime dateTime1 = LocalDateTime.of(2020, 5, 17, 10, 1, 0);
  //   LocalDateTime datasaida = LocalDateTime.of(2020, 5, 18, 10, 1, 0);
  //   Acesso acesso1 = new Acesso(dateTime1, "Abc1234");
  //   Acesso acesso2 = new Acesso(datasaida, "Abc1234");
    
  //   System.out.println("diferença: " + acesso1.diferencaDeTempoEmDiasEntre(acesso2));
  //   System.out.println("diferença: " + acesso1.diferencaDeTempoEmMinutosEntre(acesso2));
    
  // }
}
