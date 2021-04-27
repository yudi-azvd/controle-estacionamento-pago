package cadastro;

import java.util.ArrayList;

public class Mensalista {
    private String nome;
    private String endereco;
    private String celular;
    private String telefone;
    private int cnh;
    private ArrayList<Carro> carros;

    public Mensalista(String _nome, String _endereco, String _celular, String _telefone, int _cnh){
        nome = _nome;
        endereco = _endereco;
        celular = _celular;
        telefone = _telefone;
        cnh = _cnh;
        carros = new ArrayList<Carro>();
    };

    public void adicionarCarro(Carro carro){
        carros.add(carro);
    };
    
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getCelular() {
        return celular;
    }
    public String getTelefone() {
        return telefone;
    }
    public int getCnh() {
        return cnh;
    }
    public ArrayList<Carro> getCarros() {
        return carros;
    }
}
