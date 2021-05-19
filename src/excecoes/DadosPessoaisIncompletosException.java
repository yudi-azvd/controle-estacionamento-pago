package excecoes;

public class DadosPessoaisIncompletosException extends Exception {
  
	public DadosPessoaisIncompletosException() {
		super("Dados pessoais incompletos");
	}

	public DadosPessoaisIncompletosException(String mensagem) {
		super(mensagem);
	}

}
