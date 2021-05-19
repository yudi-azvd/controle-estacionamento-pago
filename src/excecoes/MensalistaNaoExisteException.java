package excecoes;

public class MensalistaNaoExisteException extends RuntimeException {
	public MensalistaNaoExisteException() {
		super("Mensalista não existe!");
	}

	public MensalistaNaoExisteException(String mensagem) {
		super(mensagem);
	}
}
