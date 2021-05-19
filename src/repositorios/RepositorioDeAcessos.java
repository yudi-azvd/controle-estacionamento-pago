package repositorios;

import java.util.ArrayList;

import cadastro.Acesso;


public class RepositorioDeAcessos {
    static private ArrayList<Acesso> acessos = new ArrayList<Acesso>();
    
    public ArrayList<Acesso> buscarTodosComPlaca (String placa) {
        ArrayList<Acesso> listaDeAcesso = new ArrayList<Acesso>();
        for(Acesso ac: acessos){
            if (ac.getPlacaDoCarro().equals(placa)) {
                listaDeAcesso.add(ac);
            }
        }
        return listaDeAcesso;
    }

    public ArrayList<Acesso> buscarTodos () {
        ArrayList<Acesso> listaDeAcesso = new ArrayList<Acesso>();
        for(Acesso ac: acessos){
            listaDeAcesso.add(ac);
        }
        return listaDeAcesso;
    }

    public void adicionarUm(Acesso acesso) {
        acessos.add(acesso);
    }

    public void apagarTodosComPlaca(String placa){
        ArrayList <Integer> posicoesASeremRemovidas = new ArrayList<>();
        int posicao = 0;
        for (Acesso acesso : acessos){
            if (acesso.getPlacaDoCarro().equals(placa)) {
                posicoesASeremRemovidas.add(posicao);
                posicao--;
            }
            posicao++;
        }
        for (int pos : posicoesASeremRemovidas){
            acessos.remove(pos);
        }
    }
}
