package cadastro;


public class Carro{
    public String modelo;
    public String placa;
    public String marca;

    public Carro(String _modelo, String _placa, String _marca){
        modelo = _modelo;
        placa = _placa;
        marca = _marca;
    };

    public String getModelo() {
        return modelo;
    }
    
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }
}