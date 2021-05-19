package excecoes;

public class EstacionamentoFechadoException extends Exception {
  
	public EstacionamentoFechadoException() {
		super("Estacionamento fechado, por favor volte mais tarde");
	}

	public EstacionamentoFechadoException(String mensagem) {
		super(mensagem);
	}

}
