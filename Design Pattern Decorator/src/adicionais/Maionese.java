package adicionais;

import abstracts.Pao;
import abstracts.PaoDecorator;

public class Maionese extends PaoDecorator{

	public Maionese(Pao pao, int quantidade) {
		super(pao, quantidade);
		peso = 20;
	}
		
	@Override
	public String getDescricao() {
		return pao.getDescricao() + ", maionese";
	}
	
	@Override
	public double getTotalPrice() {
		return super.getTotalPrice() + pao.getTotalPrice();
	}
}
