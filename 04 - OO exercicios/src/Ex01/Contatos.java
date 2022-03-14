package Ex01;

import java.time.LocalDate;

public class Contatos {

	private String nome;
	private String email;
	private String telefone;
	private LocalDate nascimento;
	private String estado;
	private String cidade;
		
	public Contatos(){
		
	}
	
	public Contatos(String nome, String email, String telefone, LocalDate nascimento, String estado, String cidade) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.estado = estado;
		this.cidade = cidade;
	}
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Contatos [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", nascimento=" + nascimento
				+ ", estado=" + estado + ", cidade=" + cidade + "]";
	}
	
	
	
}
