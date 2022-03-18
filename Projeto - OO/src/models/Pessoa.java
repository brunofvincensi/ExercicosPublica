package models;

import enums.Estado;

public class Pessoa {
	
	private String nome;	
	private String email;
	private int idade;
	private Estado estado;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String email, int idade, Estado estado) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.estado = estado;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", email=" + email + ", idade=" + idade + ", estado=" + estado;
	}
	
}
