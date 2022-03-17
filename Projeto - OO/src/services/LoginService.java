package services;


// classe abstrata a ser implementada
public abstract class LoginService {

	public boolean autenticar(String login, String senha) {
		return false;
	}
	
	public String esqueciMinhaSenha(String login, String email) {
		return null;
	}
	
	public boolean checarResposta(String login, String resposta) {
		return false;
	}
	
	public void alterarSenha(String login, String novaSenha) {
	}
}
