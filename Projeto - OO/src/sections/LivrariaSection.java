package sections;

import java.util.List;
import javax.swing.JOptionPane;
import enums.TipoGenero;
import models.Autor;
import models.Livro;
import services.impl.AutorServiceImpl;
import services.impl.LivroServiceImpl;

public class LivrariaSection {

	LivroServiceImpl livroService = new LivroServiceImpl();
	AutorServiceImpl autorService = new AutorServiceImpl();

	public LivrariaSection() {
		
		

		boolean sair = false;

		while (!sair) {

			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));

				switch (opcao) {
				case 1:
					inserirLivro();
					break;
				case 2:
					listarLivros();
					break;
				case 3:
					deletarLivro();
					break;
				case 4:
					alterarLivro();
					break;
				case 5:
					inserirAutor();
					break;
				case 6:
					listarAutores();
					break;
				case 7:
					deletarAutor();
					break;
				case 8:
					alterarAutor();
					break;
				case 9:
					sair = true;
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcao);
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	private String menu() {

		String menu = "(1) Inserir livro \n";
		menu += "(2) Listar livros \n";
		menu += "(3) Deletar livro \n";
		menu += "(4) Alterar livro \n";
		menu += "(5) Inserir autor \n";
		menu += "(6) Listar autores \n";
		menu += "(7) Deletar autor \n";
		menu += "(8) Alterar autor \n";
		menu += "(9) Sair \n";

		return menu;
	}

	private String listaGenero() {

		String lista = "(1) Acao \n";
		lista += "(2) Romance \n";
		lista += "(3) Terror \n";
		lista += "(4) Suspense \n";
		lista += "(5) Ficcão cientifica \n";

		return lista;
	}

	private void inserirLivro() {

		String nome = JOptionPane.showInputDialog("Insira o nome: ");

		int numPaginas = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero de páginas: "));

		TipoGenero genero;

		int opcaoGenero = Integer.parseInt(JOptionPane.showInputDialog(listaGenero()));

		switch (opcaoGenero) {
		case 1:
			genero = TipoGenero.ACAO;
			break;
		case 2:
			genero = TipoGenero.ROMANCE;
			break;
		case 3:
			genero = TipoGenero.TERROR;
			break;
		case 4:
			genero = TipoGenero.SUSPENSE;
			break;
		case 5:
			genero = TipoGenero.FICCAO_CIENTIFICA;
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + opcaoGenero);
		}

		double valor = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor: "));

		String nomeAutor = JOptionPane.showInputDialog("Insira o nome do autor: ");

		Autor autor = autorService.findBy(nomeAutor).orElseThrow(() -> new RuntimeException("Autor não existe"));

		Livro livro = new Livro(nome, numPaginas, genero, valor, autor);

		livroService.save(livro);

	}

	private void listarLivros() {
		List<Livro> livros = livroService.findAll();

		String lista = "";

		for (Livro a : livros) {

			lista += a + "\n";
		}

		JOptionPane.showMessageDialog(null, lista);

	}

	private void deletarLivro() {

		String nomeLivro = JOptionPane.showInputDialog("Insira o nome do livro a ser excluido");

		livroService.delete(nomeLivro);
		JOptionPane.showMessageDialog(null, "Livro excluido");
		
		
	}

	private void alterarLivro() {
		
		String nomeLivro = JOptionPane.showInputDialog("Insira o nome do livro a ser alterado");
		
		if(livroService.findBy(nomeLivro).isEmpty()) {
			throw new RuntimeException("Livro não existe");
		}

		String nome = JOptionPane.showInputDialog("Insira o novo nome: ");

		int numPaginas = Integer.parseInt(JOptionPane.showInputDialog("Insira o novo numero de páginas: "));

		TipoGenero genero;

		int opcaoGenero = Integer.parseInt(JOptionPane.showInputDialog(listaGenero()));

		switch (opcaoGenero) {
		case 1:
			genero = TipoGenero.ACAO;
			break;
		case 2:
			genero = TipoGenero.ROMANCE;
			break;
		case 3:
			genero = TipoGenero.TERROR;
			break;
		case 4:
			genero = TipoGenero.SUSPENSE;
			break;
		case 5:
			genero = TipoGenero.FICCAO_CIENTIFICA;
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + opcaoGenero);
		}

		double valor = Double.parseDouble(JOptionPane.showInputDialog("Insira o novo valor: "));

		String nomeAutor = JOptionPane.showInputDialog("Insira o novo nome do autor: ");

		Autor autor = autorService.findBy(nomeAutor).orElseThrow(() -> new RuntimeException("Autor não existe"));
		
		livroService.update(nomeLivro, new Livro(nome, numPaginas, genero, valor, autor));
		
		JOptionPane.showMessageDialog(null, "Livro alterado");
	}

	// --------------------------------------------

	
	private void inserirAutor() {

		String nome = JOptionPane.showInputDialog("Insira o nome: ");

		String email = JOptionPane.showInputDialog("Insira o e-mail: ");

		int idade = Integer.parseInt(JOptionPane.showInputDialog("Insira a idade: "));

		autorService.save(new Autor(nome, idade, email));
	}

	private void listarAutores() {

		List<Autor> autores = autorService.findAll();

		String lista = "";

		for (Autor a : autores) {

			lista += a + "\n";
		}

		JOptionPane.showMessageDialog(null, lista);
	}
	
	private void deletarAutor() {
		String nome = JOptionPane.showInputDialog("Insira o nome do autor a ser excluido");	
		autorService.delete(nome);
	}
	
	private void alterarAutor() {
		
		String nome = JOptionPane.showInputDialog("Insira o nome do autor a ser alterado");
		
		Autor autor = autorService.findBy(nome).orElseThrow();
			
		String novoNome = JOptionPane.showInputDialog("Insira o novo nome: ");

		String novoEmail = JOptionPane.showInputDialog("Insira o novo e-mail: ");

		int novaIdade = Integer.parseInt(JOptionPane.showInputDialog("Insira a nova idade: "));
		
		
		autorService.update(nome, new Autor(novoNome, novaIdade, novoEmail));
	}
}
