package excecoes;

public class PeriodoInvalidoException extends RuntimeException {
	public PeriodoInvalidoException() {
		super("Periodo invalido. Não é possível ficar menos tempo que 0 minuto");
	}

	public PeriodoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
