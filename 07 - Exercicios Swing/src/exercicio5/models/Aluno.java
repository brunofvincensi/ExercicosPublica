package exercicio5.models;

public class Aluno {
	
	private Integer id;
	private String nome;
	private int idade;
	private String genero;
	
	public Aluno() {

	}
	
	
	
	public Aluno(Integer id, String nome, int idade, String genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
