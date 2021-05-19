package excecoes;

public class DadosVeiculosIncompletosException extends Exception {

	public DadosVeiculosIncompletosException() {
		super("Dados do veiculo incompletos");
	}

	public DadosVeiculosIncompletosException(String mensagem) {
		super(mensagem);
	}
  
}
