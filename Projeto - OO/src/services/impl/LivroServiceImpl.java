package services.impl;

import java.util.ArrayList;
import java.util.List;
import models.Livro;
import services.LivroService;

public class LivroServiceImpl implements LivroService {

	public static List<Livro> livros = new ArrayList<>();

	@Override
	public List<Livro> findAllLivros() {

		return livros;
	}

	@Override
	public void insertLivro(Livro livro) {

		livros.add(livro);
	}

	@Override
	public void deleteLivro(String nome) {

		livros.forEach(l -> {
			if (l.getNome().equals(nome)) {
				livros.remove(l);
			}
		});

	}

	@Override
	public void updateLivro(String nome, Livro livro) {

	}

}
