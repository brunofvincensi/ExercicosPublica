package exercicio2;

import java.util.HashMap;
import java.util.Map;

public class ValorMoedas {

	public static Map<String, Double> valorMoedas = new HashMap<>();

	static {
		valorMoedas.put("Dolar", 5.50);
		valorMoedas.put("Euro", 6.15);
		valorMoedas.put("Libra", 4.60);
		valorMoedas.put("Iene japones", 3.30);
		valorMoedas.put("Peso argentino", 0.4);
	}
}
