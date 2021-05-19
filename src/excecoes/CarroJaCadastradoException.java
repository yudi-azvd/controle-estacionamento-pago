package excecoes;

public class CarroJaCadastradoException extends RuntimeException {
  
	public CarroJaCadastradoException() {
		super("Placa já registrada!");
	}

	public CarroJaCadastradoException(String mensagem) {
		super(mensagem);
	}

}
