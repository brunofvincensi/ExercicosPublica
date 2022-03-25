package adicionais;

import abstracts.Pao;
import abstracts.PaoDecorator;

public class Queijo extends PaoDecorator{
	
	public Queijo(Pao pao, int quantidade) {
		super(pao, quantidade);
		peso = 70;
	}
	
	
	@Override
	public String getDescricao() {
		return pao.getDescricao() + ", queijo";
	}
	
	@Override
	public double getTotalPrice() {
		return super.getTotalPrice() + pao.getTotalPrice();
	}

}
