package services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import enums.Nivel;
import exceptions.UsuarioNotFoundException;
import models.Usuario;
import services.CrudGenericService;
import services.LoginService;

public class UsuarioServiceImpl extends LoginService implements CrudGenericService<Usuario>{

	private static List<Usuario> usuarios = new ArrayList<>();
	
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
				
				if(usuarios.get(i).getNivel() == Nivel.GERENTE) {
					
					usuario.setNivel(Nivel.GERENTE);
					
				}else if(usuarios.get(i).getNivel() == Nivel.ADMIN) {
					
					usuario.setNivel(Nivel.ADMIN);					
				}
				
				usuarios.set(i, usuario);
				break;
			}

		}
	}

	@Override
	public void delete(String login) {
		Usuario u = 
				findBy(login)
				.orElseThrow(() -> new UsuarioNotFoundException());
		
		usuarios.remove(u);

	}

	// ---------------------------------------------

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
	public Optional<Usuario> findBy(String login) {

		for (Usuario u : usuarios) {

			if (u.getLogin().equals(login)) {

				return Optional.of(u);
			}
		}

		return Optional.empty();
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
}
