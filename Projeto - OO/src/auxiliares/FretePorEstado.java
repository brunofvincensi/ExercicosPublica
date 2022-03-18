package auxiliares;
import java.util.HashMap;
import java.util.Map;

import enums.Estado;

// Classe para determinar o frete por estado
public class FretePorEstado {

	private static Map<Estado, Double> estadoFrete = new HashMap<>();
	
	static {
		estadoFrete.put(Estado.SC, 20.00);
		estadoFrete.put(Estado.RS, 12.50);
		estadoFrete.put(Estado.RJ, 32.00);
		estadoFrete.put(Estado.PR, 10.00);
		estadoFrete.put(Estado.SP, 26.00);
	}
	
	public static Map<Estado, Double> getFretes() {
		return estadoFrete;
	}	
	
}
