/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this teaplate file, choose Tools | Teaplates
 * and open the teaplate in the editor.
 */
package repositorios;

import java.util.ArrayList;

import cadastro.Acesso;

/**
 *
 * @author pablo
 */
public class RepositorioDeAcessos {
    private ArrayList<Acesso> acessos = new ArrayList<Acesso>();
    
    public ArrayList<Acesso> buscarTodosComPlaca (String placa) {
        ArrayList<Acesso> a = new ArrayList<Acesso>();
        a = null;
        for(Acesso ac: acessos){
            if (ac.getPlacaDoCarro().equals(placa)) {
                a.add(ac);
            }
        }
        
        return a;
    }

    public  Acesso adicionarUm(Acesso acesso) {
        acessos.add(acesso);
        return null;
    }
}
