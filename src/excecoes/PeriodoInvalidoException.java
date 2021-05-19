package excecoes;

public class PeriodoInvalidoException extends RuntimeException {
	
	public PeriodoInvalidoException() {
		super("Periodo invalido");
	}

	public PeriodoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
