
package repositorios;

import java.util.ArrayList;
import cadastro.Mensalista;

public class RepositorioDeMensalistas {
    static private ArrayList<Mensalista> mensalistas = new ArrayList<Mensalista>();
    
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
