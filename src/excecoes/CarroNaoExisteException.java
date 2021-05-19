package excecoes;

public class CarroNaoExisteException extends RuntimeException {
	public CarroNaoExisteException() {
		super("Placa não cadastrada!");
	}

	public CarroNaoExisteException(String mensagem) {
		super(mensagem);
	}
}
