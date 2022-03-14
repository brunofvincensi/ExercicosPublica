package exemplo03;

public class Pessoa {

	/**
	 * DEFAULT   : Atributos e métodos viciveis apenas no mesmo pacote
	 * PUBLIC    : Atributos e metodos visiveis em todo projeto
	 * PRIVATE   : Atributos e métodos visiveis apenas na classe onde são criados 
	 * PROTECTED : Atributos e métodos visíveis nas classes onde são criados ou herdados
	 */
	String nome;
	public int idade;
	private double peso;
	protected double altura;
	
	// Get e Set
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	

}
