package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import enums.Estado;
import enums.Nivel;
import exceptions.UsuarioNotFoundException;
import models.Usuario;

public abstract class UsuarioService implements CrudGenericService<Usuario>, LoginService{

	protected static List<Usuario> usuarios = new ArrayList<>();

	
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
		Usuario usuario = 
				findBy(login)
				.orElseThrow(() -> new UsuarioNotFoundException());
		
		usuarios.remove(usuario);

	}
	
	@Override
	public Optional<Usuario> findBy(String login) {

		for (Usuario usuario : usuarios) {

			if (usuario.getLogin().equals(login)) {

				return Optional.of(usuario);
			}
		}

		return Optional.empty();
	}
	
	public void validarEmail(String emalil) {
	}
}
