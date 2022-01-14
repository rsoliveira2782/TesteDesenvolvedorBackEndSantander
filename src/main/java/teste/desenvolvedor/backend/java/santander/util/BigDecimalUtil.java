package teste.desenvolvedor.backend.java.santander.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    public static boolean ehMaiorOuIgualA(final BigDecimal pValor1, final BigDecimal pValor2) {

	return pValor1.compareTo(pValor2) >= 0;

    }

    public static boolean ehMaiorQue(final BigDecimal pValor1, final BigDecimal pValor2) {

	return pValor1.compareTo(pValor2) > 0;

    }

    public static boolean ehMenorOuIgualA(final BigDecimal pValor1, final BigDecimal pValor2) {

	return pValor1.compareTo(pValor2) <= 0;

    }

    public static boolean ehMenorQue(final BigDecimal pValor1, final BigDecimal pValor2) {

	return pValor1.compareTo(pValor2) < 0;

    }

    public static BigDecimal valorPercentual(BigDecimal base, BigDecimal porcentagem) {
	return base.multiply(porcentagem).divide(ONE_HUNDRED);
    }

}
