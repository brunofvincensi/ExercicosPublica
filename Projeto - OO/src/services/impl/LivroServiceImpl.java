package services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import enums.TipoGenero;
import exceptions.LivroNotFoundException;
import models.Autor;
import models.Livro;
import services.CrudGenericService;

public class LivroServiceImpl implements CrudGenericService<Livro> {

	private static List<Livro> livros = new ArrayList<>();

	@Override
	public List<Livro> findAll() {

		return livros;
	}

	@Override
	public void save(Livro livro) {

		if(!livros.contains(livro)) {	
		livros.add(livro);
		}
		else {
			throw new RuntimeException("Livro já existe");
		}
	}

	@Override
	public void delete(String nome) {

		boolean existe = false;
		
		for(Livro l : livros) {
			if (l.getNome().equals(nome)) {
				livros.remove(l);
				existe = true;
				break;
			}
		}
		if(!existe) {
			throw new LivroNotFoundException();
		}

	}

	@Override
	public void update(String nome, Livro livro) {

		for(int i = 0; i < livros.size(); i++) {
			if(livros.get(i).getNome().equals(nome)) {
				
				livros.set(i, livro);
				break;
			}
		}
	}

	@Override
	public Optional<Livro> findBy(String nome) {
		for (Livro l : livros) {

			if (l.getNome().equals(nome)) {

				return Optional.of(l);
			}
		}

		return Optional.empty();
	}
}
