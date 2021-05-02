/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.util.ArrayList;
import cadastro.Mensalista;
/**
 *
 * @author pablo
 */
public class RepositorioDeMensalistas {
    
    private ArrayList<Mensalista> mensalistas = new ArrayList<Mensalista>();
    public Mensalista buscarUmComCnh (int cnh){
        for(Mensalista m: mensalistas){
            if (m.getCnh() == cnh)
            return m;
        }
        return null;
    }
    public Mensalista adicionarUm(Mensalista m) {
        mensalistas.add(m);
        return null;
    }
    
}
