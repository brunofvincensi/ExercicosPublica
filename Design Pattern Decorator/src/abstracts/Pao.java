package abstracts;
public abstract class Pao extends Comida{

	protected String descricao;
	
	public String getDescricao() {
		return descricao;
	}

	protected Pao() {
		descricao = "";
		peso = 80;
	}
	
	
	@Override
	public double getTotalPrice() {
		return super.getTotalPrice();
	}
	
}
