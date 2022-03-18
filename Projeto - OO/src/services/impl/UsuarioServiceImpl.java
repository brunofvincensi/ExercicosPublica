package services.impl;

import java.util.List;
import enums.Nivel;
import exceptions.UsuarioNotFoundException;
import models.Usuario;
import services.UsuarioService;

public class UsuarioServiceImpl extends UsuarioService {

	@Override
	public void save(Usuario usuario) {

		usuarios.add(usuario);

	}

	@Override
	public List<Usuario> findAll() {
		return usuarios;
	}

	@Override
	public void update(String login, Usuario usuario) {

		for (int i = 0; i < usuarios.size(); i++) {

			if (usuarios.get(i).getLogin().equals(login)) {

				if (usuarios.get(i).getNivel() == Nivel.GERENTE) {

					usuario.setNivel(Nivel.GERENTE);

				} else if (usuarios.get(i).getNivel() == Nivel.ADMIN) {

					usuario.setNivel(Nivel.ADMIN);
				}

				usuarios.set(i, usuario);
				break;
			}

		}
	}

	@Override
	public void delete(String login) {
		Usuario u = findBy(login).orElseThrow(() -> new UsuarioNotFoundException());

		usuarios.remove(u);

	}

	/**
	 * pega o login e a senha para verificar se o usuario existe
	 */
	@Override
	public boolean autenticar(String login, String senha) {

		Usuario u = findBy(login).orElseThrow(() -> new RuntimeException("Usuario não existe"));

		if (u.getSenha().equals(senha)) {
			return true;
		}

		else {
			return false;
		}

	}

	/**
	 * checa se existe o usuario e retorna a pergunta secreta
	 */
	@Override
	public String esqueciMinhaSenha(String login, String email) {

		Usuario u = findBy(login).orElseThrow(() -> new RuntimeException("Usuario não existe"));

		if (u.getEmail().equals(email)) {

			return u.getPerguntaSecreta();
		}

		else {

			throw new RuntimeException("Email incorreto");
		}

	}
	
	@Override
	public boolean checarResposta(String login, String resposta) {

		Usuario u = findBy(login).get();

		if (u.getRespostaPergunta().equals(resposta)) {

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void alterarSenha(String login, String novaSenha) {

		for (int i = 0; i < usuarios.size(); i++) {

			if (usuarios.get(i).getLogin().equals(login)) {

				usuarios.get(i).setSenha(novaSenha);
				break;
			}

		}

	}

	@Override
	public void validarEmail(String email) {

		boolean temEspaco = false;
		boolean temCaracterEspecial = false;
		boolean temArroba = false;
		boolean charDepois = true;
		boolean charAntes = false;

		for (int i = 0; i < email.length(); i++) {

			char letra = email.charAt(i);

			if (letra == ' ') {
				temEspaco = true;
			}
			if (letra == '@') {
				temArroba = true;

				if (i != 0) {
					charAntes = true;
				}
				if ((i == email.length() - 1) || (i == email.length() - 2)) {
					charDepois = false;
				}
			}

			if (letra == 'ç' || letra == 'é' || letra == 'ã' || letra == '!' || letra == '?' || letra == '}') {

				temCaracterEspecial = true;
			}

		}

		if (!(!temEspaco && !temCaracterEspecial && temArroba && charDepois && charAntes)) {

			throw new RuntimeException("Email iválido");
		} 

	}
}
