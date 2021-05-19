package excecoes;

public class DadosPessoaisIncompletosException extends RuntimeException {
	public DadosPessoaisIncompletosException() {
		super("Dados pessoais incompletos");
	}

	public DadosPessoaisIncompletosException(String mensagem) {
		super(mensagem);
	}
}
