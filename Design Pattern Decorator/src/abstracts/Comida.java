package abstracts;

public abstract class Comida {

	protected double peso;
	
	protected int quantidade = 1;
	
	public double getPesoTotal() {
		return peso * quantidade;
	}
	
	public double getTotalPrice() {
		return (getPesoTotal() / 1000) * 30;
	}
 
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
