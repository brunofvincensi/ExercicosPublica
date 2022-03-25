package adicionais;

import abstracts.Pao;
import abstracts.PaoDecorator;

public class Frango extends PaoDecorator{

	public Frango(Pao pao, int quantidade) {
		super(pao, quantidade);
		peso = 100;
	}
	
	
	@Override
	public String getDescricao() {
		return pao.getDescricao() + ", frango";
	}
	
	@Override
	public double getTotalPrice() {
		// TODO Auto-generated method stub
		return super.getTotalPrice() + pao.getTotalPrice();
	}
}
