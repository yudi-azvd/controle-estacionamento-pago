package repositorios;

import cadastro.Carro;

public class RepositorioDeCarros{
    private ArrayList<Carro> carros = new ArrayList<Carro>();
    public Carro buscarUmComPlaca (String placa){
        for(Carro c: carros){
            if (c.getPlaca().equals(placa))
            return c;
        }
        return null;
    }
}
