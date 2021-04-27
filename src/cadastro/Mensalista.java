package cadastro;

import java.util.ArrayList;

public class Mensalista {
    private String nome;
    private String endereco;
    private String celular;
    private String telefone;
    private int cnh;
    private ArrayList<Carro> carros;
    
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
