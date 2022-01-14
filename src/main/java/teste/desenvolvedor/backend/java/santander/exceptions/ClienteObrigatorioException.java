package teste.desenvolvedor.backend.java.santander.exceptions;

public class ClienteObrigatorioException extends RuntimeException {

    public ClienteObrigatorioException(final String pMensagem) {
	super(pMensagem);
    }

}
