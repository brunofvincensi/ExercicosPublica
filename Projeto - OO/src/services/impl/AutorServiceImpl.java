package services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exceptions.AutorNotFoundException;
import exceptions.LivroNotFoundException;
import models.Autor;
import models.Livro;
import models.Usuario;
import services.CrudGenericService;

public class AutorServiceImpl implements CrudGenericService<Autor> {

	private static List<Autor> autores = new ArrayList<>();
	LivroServiceImpl livroService = new LivroServiceImpl();

	@Override
	public List<Autor> findAll() {
		return autores;
	}

	@Override
	public void save(Autor autor) {
		autores.add(autor);

	}

	@Override
	public void delete(String nome) {
		boolean existe = false;

		for (Autor a : autores) {

			if (a.getNome().equals(nome)) {

				if (!livroService.findAll().stream().filter(l -> l.getAutor().equals(a)).toList().isEmpty()) {

					throw new RuntimeException("Não pode ser deletado, existe livros deste autor cadastrado");
				}

				autores.remove(a);
				existe = true;
				break;
			}
		}
		if (!existe) {
			throw new AutorNotFoundException();
		}

	}

	@Override
	public void update(String nome, Autor autor) {
		
		for(int i = 0; i < autores.size(); i++) {
			
			Autor a = autores.get(i);
			
			if(a.getNome().equals(nome)){				
							
				List<Livro> livros = livroService.findAll();
				
				for(int j = 0; j < livros.size(); j++) {
					
					if(livros.get(i).getAutor().equals(a)){
						
						Livro livro = livros.get(i);
						
						livro.setAutor(autor);
						
						livroService.update(livro.getNome(), livro);
						
					}
					
				}
				
				autores.set(i, autor);
				break;
			}
		}
		
	}

	@Override
	public Optional<Autor> findBy(String nome) {
		for (Autor a : autores) {

			if (a.getNome().equals(nome)) {

				return Optional.of(a);
			}
		}

		return Optional.empty();
	}

}
