package services;

import java.util.List;

import models.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAllUsuarios();
	
	public void updateUsuario(String login, Usuario usuario);
	
	public void deleteUsuario(String login);
	
	void alterarSenha(String login, String novaSenha);
	
	// void fazerPedido(int[] codigosLivro);

}
