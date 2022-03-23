package valores;

import java.util.HashMap;
import java.util.Map;

import enums.TipoInvestimento;

public class TaxaInvestimento {

	public static Map<TipoInvestimento, Double> taxasMensais = new HashMap<>();

	static {
		// Foi feito um calculo préviamente para gerar o rendimento mensal de cada.
		taxasMensais.put(TipoInvestimento.POUPANCA, 0.5);
		taxasMensais.put(TipoInvestimento.CDB, 0.97);
		taxasMensais.put(TipoInvestimento.LCI, 0.97);
	}
}
