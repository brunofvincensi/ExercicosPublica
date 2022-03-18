package models;

import enums.Estado;
import enums.Nivel;

public class Usuario extends Pessoa{
		
	private Nivel nivel;		
	private String login;
	private String senha;
	private String perguntaSecreta;	
	private String respostaPergunta;
	
	public Usuario() {
		nivel = Nivel.CLIENTE;
	}
	
	public Usuario(String nome, String email, String login, String senha,
			String perguntaSecreta, String respostaPergunta, int idade, Estado estado) {
		super(nome, email, idade, estado);
		this.nivel = Nivel.CLIENTE;;
		this.login = login;
		this.senha = senha;
		this.perguntaSecreta = perguntaSecreta;
		this.respostaPergunta = respostaPergunta;
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerguntaSecreta() {
		return perguntaSecreta;
	}
	public void setPerguntaSecreta(String perguntaSecreta) {
		this.perguntaSecreta = perguntaSecreta;
	}
	public String getRespostaPergunta() {
		return respostaPergunta;
	}
	public void setRespostaPergunta(String respostaPergunta) {
		this.respostaPergunta = respostaPergunta;
	}

	@Override
	public String toString() {
		return "Usuario [nivel=" + nivel + ", login=" + login + ", senha=" + senha + ", perguntaSecreta="
				+ perguntaSecreta + ", respostaPergunta=" + respostaPergunta + ", " + super.toString() + "]";
	}

	
}
