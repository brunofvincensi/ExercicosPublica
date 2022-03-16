package services;

import models.Usuario;

public interface LoginService {

	boolean autenticar(String login, String senha);
	
	String esqueciMinhaSenha(String login, String email);
	
	boolean checarResposta(String login, String resposta);
	
	void cadastrar(Usuario usuario);
	
	
}
