package cadastro;


public class Carro{
    private String modelo;
    private String placa;
    private String marca;
    private int mensalistaCnh;

    public Carro(String _modelo, String _placa, String _marca, int cnh){
        modelo = _modelo;
        placa = _placa;
        marca = _marca;
        mensalistaCnh = cnh;
    }

    public String getModelo() {
        return modelo;
    }
    
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public int getMensalistaCnh() {
        return mensalistaCnh;
    }
    public void setCnh(int cnh) {
        mensalistaCnh = cnh;
    }

    public String toString() {
        String str = placa + ", " + modelo + ", " + marca;
        return str + (mensalistaCnh == 0 ? "" : ", associado a um mensalista.");
    }
}