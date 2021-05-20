package excecoes;

public class OpcaoInvalidaException extends RuntimeException {
	public OpcaoInvalidaException() {
		super("Opção inválida");
	}

	public OpcaoInvalidaException(String mensagem) {
		super(mensagem);
	}
}
