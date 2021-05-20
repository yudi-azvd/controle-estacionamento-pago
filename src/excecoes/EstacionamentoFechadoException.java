package excecoes;

public class EstacionamentoFechadoException extends RuntimeException {
	public EstacionamentoFechadoException() {
		super("Estacionamento fechado, por favor amanhã");
	}

	public EstacionamentoFechadoException(String mensagem) {
		super(mensagem);
	}
}
