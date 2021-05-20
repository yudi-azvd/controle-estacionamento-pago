package excecoes;

public class PagamentoPendenteException extends RuntimeException  {
    public PagamentoPendenteException() {
		super("Pagamento pendente, por favor pague o uso do estacionamento antes de usa-lo novamente!");
	}

	public PagamentoPendenteException(String mensagem) {
		super(mensagem);
	}
}
