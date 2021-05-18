package repositorios;

import java.util.ArrayList;

import cadastro.Carro;

public class RepositorioDeCarros {
    static private ArrayList<Carro> carros = new ArrayList<Carro>();
    
    public Carro buscarUmComPlaca(String placa){
        for(Carro c: carros){
            if (c.getPlaca().equals(placa))
            return c;
        }
        return null;
    }

    public void adicionarUm(Carro carro) {
        // checar se carro já existe?
        carros.add(carro);
    }
}
