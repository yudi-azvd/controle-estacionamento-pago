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

    public ArrayList <Carro> buscarTodosComCnh(int cnh){
        ArrayList<Carro> carrosDeUmMensalista = new ArrayList<>();
        for(Carro c: carros){
            if (c.getMensalistaCnh()==cnh){
                carrosDeUmMensalista.add(c);    
            }
        }
        return carrosDeUmMensalista;
    }

    public ArrayList<Carro> buscarTodos() {
        ArrayList<Carro> todosCarros = new ArrayList<>();
        for(Carro c: carros){
            todosCarros.add(c);
        }
        return todosCarros;
    }

    public void definirCnhParaOCarroComPlaca(int cnh, String placa) {
        Carro carro=null;
        int posicao=0;
        for(Carro c: carros){
            if (c.getPlaca().equals(placa)){
                carro = c;
                break;
            }
            posicao++;
        }
        carro.setCnh(cnh);
        carros.set(posicao, carro);
    }

    public void adicionarUm(Carro carro) {
        // checar se carro já existe?
        carros.add(carro);
    }
}
