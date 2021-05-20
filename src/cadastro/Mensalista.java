package cadastro;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Mensalista {
    private String nome;
    private String endereco;
    private String celular;
    private String telefone;
    private int cnh;
    private ArrayList<Carro> carros ;

    public Mensalista(String _nome, String _endereco, String _celular, String _telefone, int _cnh) {
        nome = _nome;
        endereco = _endereco;
        celular = _celular;
        telefone = _telefone;
        cnh = _cnh;
        carros = new ArrayList<>();
    };
    
    public String getNome() {
        return nome;
    }

    public int getCnh() {
        return cnh;
    } 
    
    public String toString() {
        return nome.toUpperCase() + ", CNH: " + cnh;
    } 
}
