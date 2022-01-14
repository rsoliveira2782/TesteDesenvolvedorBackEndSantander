package teste.desenvolvedor.backend.java.santander.exceptions;

public class ValorNegativoOuZeroException extends RuntimeException {

    public ValorNegativoOuZeroException(final String pMensagem) {
	super(pMensagem);
    }

}
