package arrays.ex01;

public class Contato {
	
	private String nome;
	private int idade;
	private String email;
	private String telefone;
	private String cidade;
	
	public Contato() {
		
	}
	
	public Contato(String nome, int idade, String email, String telefone, String cidade) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.telefone = telefone;
		this.cidade = cidade;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", email=" + email + ", telefone=" + telefone + ", cidade="
				+ cidade + "]";
	}
	
	

}
