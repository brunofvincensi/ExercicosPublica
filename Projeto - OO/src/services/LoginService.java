package services;

import services.impl.UsuarioServiceImpl;

public interface LoginService {

	UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
	
	public boolean autenticar(String login, String senha);
	
	public String esqueciMinhaSenha(String login, String email);
	
	public boolean checarResposta(String login, String resposta);
	
	public void alterarSenha(String login, String novaSenha);
}
