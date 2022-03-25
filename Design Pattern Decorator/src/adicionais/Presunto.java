package adicionais;

import abstracts.Pao;
import abstracts.PaoDecorator;

public class Presunto extends PaoDecorator {
	
	public Presunto(Pao pao, int quantidade) {
		super(pao, quantidade);
		peso = 30;
	}
	
	
	@Override
	public String getDescricao() {
		return pao.getDescricao() + ", presunto";
	}
	
	@Override
	public double getTotalPrice() {
		return super.getTotalPrice() + pao.getTotalPrice();
	}
}
