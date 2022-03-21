package exercicio4;

public class Produto {
	
	private String nome;
	private String marca;
	private String segmento;
	private double valor;	
	
	public Produto() {

	}
	
	public Produto(String nome, String marca, String segmento, double valor) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.segmento = segmento;
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	

}
