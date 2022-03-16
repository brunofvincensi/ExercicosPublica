package services;

import java.util.List;
import models.Livro;

public interface LivroService {
	
	public List<Livro> findAllLivros();
	
	public void insertLivro(Livro livro);
	
	public void deleteLivro(String nome);
	
	public void updateLivro(String nome, Livro livro);
	
	
}
