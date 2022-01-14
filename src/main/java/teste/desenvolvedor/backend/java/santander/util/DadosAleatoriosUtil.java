package teste.desenvolvedor.backend.java.santander.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.temporal.ChronoUnit.DAYS;

public class DadosAleatoriosUtil {

    public static LocalDate dataInicial = LocalDate.of(1900, Month.JANUARY, 1);

    public static LocalDate datafinal = LocalDate.of(2000, Month.DECEMBER, 31);

    private static MathContext mc = new MathContext(2); // Precisão duas casas decimais

    public static BigDecimal valorInicial = new BigDecimal(0, mc);

    public static BigDecimal valorFinal = new BigDecimal(1000000, mc);

    private Random r = new Random();

    public static LocalDate getDataAleatoria() {

	long dias = DAYS.between(dataInicial, datafinal);

	return dataInicial.plusDays(ThreadLocalRandom.current().nextLong(dias + 1));

    }

    public static BigDecimal getValorAleatorio() {

	return valorInicial.add(new BigDecimal(Math.random(), mc).multiply(valorFinal.subtract(valorInicial)));

    }

}
