package adicionais;

import abstracts.Pao;
import abstracts.PaoDecorator;

public class Salada extends PaoDecorator{
	
	public Salada(Pao pao, int quantidade) {
		super(pao, quantidade);
		peso = 30;
	}
	
	
	@Override
	public String getDescricao() {
		return pao.getDescricao() + ", salada";
	}
	
	@Override
	public double getTotalPrice() {
		return super.getTotalPrice() + pao.getTotalPrice();
	}
}
