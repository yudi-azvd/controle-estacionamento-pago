package excecoes;

public class EstacionamentoFechadoException extends RuntimeException {
	public EstacionamentoFechadoException() {
		super("Estacionamento fechado, por favor volte mais tarde");
	}

	public EstacionamentoFechadoException(String mensagem) {
		super(mensagem);
	}
}
