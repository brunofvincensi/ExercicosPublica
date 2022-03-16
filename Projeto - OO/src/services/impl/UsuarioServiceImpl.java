package services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import models.Usuario;
import services.LoginService;
import services.UsuarioService;

public class UsuarioServiceImpl implements LoginService, UsuarioService {

	public static List<Usuario> usuarios = new ArrayList<>();

	@Override
	public List<Usuario> findAllUsuarios() {
		return usuarios;
	}

	@Override
	public void updateUsuario(String login, Usuario usuario) {
		
		

	}

	@Override
	public void deleteUsuario(String login) {
		// TODO Auto-generated method stub

	}

	// ---------------------------------------------

	@Override
	public boolean autenticar(String login, String senha) {
		
		Usuario u = findByLogin(login).orElseThrow(() -> new RuntimeException("Usuario não existe"));

		if (u.getSenha().equals(senha)) {
			return true;
		}

		else {
			return false;
		}

	}

	@Override
	public String esqueciMinhaSenha(String login, String email) {

		Usuario u = findByLogin(login).orElseThrow(() -> new RuntimeException("Usuario não existe"));

		if (u.getEmail().equals(email)) {

			return u.getPerguntaSecreta();
		}

		else {

			throw new RuntimeException("Email incorreto");
		}

	}

	private Optional<Usuario> findByLogin(String login) {

		for (Usuario u : usuarios) {

			if (u.getLogin().equals(login)) {

				return Optional.of(u);
			}
		}

		return Optional.empty();
	}

	@Override
	public void cadastrar(Usuario usuario) {

		usuarios.add(usuario);

	}

	@Override
	public boolean checarResposta(String login, String resposta) {

		Usuario u = findByLogin(login).get();

		if (u.getRespostaPergunta().equals(resposta)) {

			return true;
		} else {
			return false;
		}
	}

	public void alterarSenha(String login, String novaSenha) {

		for (int i = 0; i < usuarios.size(); i++) {

			if (usuarios.get(i).getLogin().equals(login)) {

				usuarios.get(i).setSenha(novaSenha);
				break;
			}

		}

	}

}
