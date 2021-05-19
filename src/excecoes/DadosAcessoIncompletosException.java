package excecoes;

public class DadosAcessoIncompletosException extends RuntimeException {
	public DadosAcessoIncompletosException() {
		super("Dados de acesso incompletos");
	}

	public DadosAcessoIncompletosException(String mensagem) {
		super(mensagem);
	}
}
