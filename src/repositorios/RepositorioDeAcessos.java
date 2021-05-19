/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this teaplate file, choose Tools | Teaplates
 * and open the teaplate in the editor.
 */
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
}
