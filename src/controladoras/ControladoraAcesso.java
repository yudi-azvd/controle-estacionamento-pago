package controladoras;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import cadastro.Acesso;
import cadastro.Carro;
import excecoes.CarroNaoExisteException;
import excecoes.EstacionamentoFechadoException;
import excecoes.PagamentoPendenteException;
import excecoes.PeriodoInvalidoException;
import repositorios.RepositorioDeAcessos;
import repositorios.RepositorioDeCarros;

public class ControladoraAcesso {
    private Scanner entradaDoTeclado;
    RepositorioDeAcessos repositorioDeAcessos = new RepositorioDeAcessos();
    RepositorioDeCarros repositorioDeCarros = new RepositorioDeCarros();

    public ControladoraAcesso(Scanner scanner) {
        entradaDoTeclado = scanner;
    }
    public void cadastrarAcesso() {
        System.out.print("\nDigite a placa do carro: ");
        String placa = entradaDoTeclado.nextLine();
        System.out.print("Digite o mês do acesso: ");
        int mes = entradaDoTeclado.nextInt();
        System.out.print("Digite o dia do acesso: ");
        int dia = entradaDoTeclado.nextInt();
        entradaDoTeclado.nextLine();
        System.out.print("Digite a hora do acesso: ");
        int hora = entradaDoTeclado.nextInt();
        entradaDoTeclado.nextLine();
        System.out.print("Digite o minuto do acesso: ");
        int minuto = entradaDoTeclado.nextInt();
        entradaDoTeclado.nextLine();

        Carro carro = repositorioDeCarros.buscarUmComPlaca(placa);
        boolean carroEncontrado = carro != null;
        if (!carroEncontrado) {
            throw new CarroNaoExisteException();
        }

        int anoPadrao=2020;
        LocalDateTime dateTime = LocalDateTime.of(anoPadrao, mes, dia, hora, minuto, 0);
        Acesso acesso = new Acesso(dateTime, placa);
        if (hora>20 || hora<6) {
            throw new EstacionamentoFechadoException();
        }

        ArrayList<Acesso> acessos = repositorioDeAcessos.buscarTodosComPlaca(placa);

        boolean esseCarroJaTemPeloMenosUmAcesso = acessos.size() > 0;
        if (esseCarroJaTemPeloMenosUmAcesso) {
            Acesso acessoDeEntrada = acessos.get(0);
            int diffTempoEmMin = acessoDeEntrada.diferencaDeTempoEmMinutosEntre(acesso);
            if (diffTempoEmMin <= 0)
                throw new PeriodoInvalidoException();
        }     
        boolean esseCarroJaTemDoisAcessos = acessos.size() > 1;
        if (esseCarroJaTemDoisAcessos) {
            throw new PagamentoPendenteException();
        }     

        repositorioDeAcessos.adicionarUm(acesso);
    }

    public void listarTodos() {
        int contador = 0;
        ArrayList<Acesso> lista = repositorioDeAcessos.buscarTodos();
        System.out.println("\nLista de Acessos:");

        for(Acesso acesso: lista){
            System.out.println("" + ++contador + ") " + acesso.toString());
        }
        System.out.println("\nPressione ENTER para continuar!");
        entradaDoTeclado.nextLine();
    }
}
