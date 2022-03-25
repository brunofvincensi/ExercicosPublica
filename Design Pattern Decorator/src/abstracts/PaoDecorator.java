package abstracts;

public abstract class PaoDecorator extends Pao{

	protected Pao pao;
	
	public PaoDecorator(Pao pao, int quantidade) {
		this.quantidade = quantidade;
		this.pao = pao;
	}


	abstract public String getDescricao();
	
	@Override
	public double getTotalPrice() {
		// TODO Auto-generated method stub
		return super.getTotalPrice();
	}

	
	

}
