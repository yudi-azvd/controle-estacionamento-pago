package excecoes;

public class PeriodoInvalidoException extends Exception {
	
	public PeriodoInvalidoException() {
		super("Periodo invalido");
	}

	public PeriodoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
