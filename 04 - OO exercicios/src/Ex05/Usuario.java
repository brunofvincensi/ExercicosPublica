package Ex05;

public class Usuario {

	private String login;
	private String senha;
	private int role;

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, int role) {
		super();
		this.login = login;
		this.senha = senha;
		this.role = role;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", role=" + role + "]";
	}

}
