package models;

import java.util.List;

public class Autor extends Pessoa{
	
	private List<Livro> livros;
	
	
	public Autor() {
		super();
	}

	public Autor(String nome, int idade, String telefone, String email, List<Livro> livros) {
		super(nome, email, idade );
		
		this.livros = livros;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
