package excecoes;

public class MensalistaJaCadastradoException extends RuntimeException {
  
	public MensalistaJaCadastradoException() {
		super("CNH já registrada!");
	}

	public MensalistaJaCadastradoException(String mensagem) {
		super(mensagem);
	}

}
