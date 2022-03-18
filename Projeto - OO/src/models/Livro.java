package models;

import enums.TipoGenero;

public class Livro {
	
	private String nome;
	private int numPaginas;
	private TipoGenero genero;
	private double valor;
	private Autor autor;
	
	public Livro() {
	}
	
	public Livro(String nome, int numPaginas, TipoGenero genero, double valor, Autor autor) {
		super();
		this.nome = nome;
		this.numPaginas = numPaginas;
		this.genero = genero;
		this.valor = valor;
		this.autor = autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", numPaginas=" + numPaginas + ", genero=" + genero + ", valor=R$" + valor
				+ ", autor=" + autor + "]";
	}
	
	
	
}
