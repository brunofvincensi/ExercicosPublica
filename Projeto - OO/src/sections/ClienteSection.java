package sections;

import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import auxiliares.FretePorEstado;
import auxiliares.ListarEstados;
import enums.Estado;
import models.LivroComprado;
import models.Livro;
import models.Usuario;
import services.impl.LivroCompradoServiceImpl;
import services.impl.LivroServiceImpl;
import services.impl.UsuarioServiceImpl;

// classe para abrir a secao do cliente
public class ClienteSection extends ListarEstados {

	UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
	LivroServiceImpl livroService = new LivroServiceImpl();
	LivroCompradoServiceImpl livroCompradoService = new LivroCompradoServiceImpl();

	public ClienteSection(Usuario ususario) {

		boolean sair = false;

		while (!sair) {

			int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));

			try {
				switch (opcao) {
				case 1:
					comprarLivro(ususario);
					break;
				case 2:
					meusLivros(ususario);
					break;
				case 3:
					alterarConta(ususario.getLogin());
					break;
				case 4:
					deletarMinhaConta(ususario.getLogin());
					break;
				case 5:
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

	/**
	 * seleciona o livro e a quantidade que deseja comprar, gerando um boleto
	 * posteriormente
	 * 
	 * @param usuario logado
	 */
	private void comprarLivro(Usuario usuario) {
		List<Livro> livros = livroService.findAll();

		livros.forEach(l -> System.out.println(l));

		String lista = "";
		for (int i = 0; i < livros.size(); i++) {

			lista += "( " + i + " ) -> " + livros.get(i) + " \n";
		}

		lista += "Insira o código do livro que desaja comprar";

		int numeroLivro = Integer.parseInt(JOptionPane.showInputDialog(lista));

		if (numeroLivro > livros.size() - 1 || numeroLivro > 0) {
			throw new RuntimeException("Código não existe");
		}

		Livro livro = livros.get(numeroLivro);

		int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade deste livro"));

		if (quantidade < 1) {
			throw new RuntimeException("Quantidade não pode ser 0 ou menor");
		}

		LivroComprado livroComprado = new LivroComprado(usuario, livro, quantidade);

		livroCompradoService.save(livroComprado);

		double frete = FretePorEstado.getFretes().get(livroComprado.getUsuario().getEstado());

		double precoComFrete = frete + livroComprado.getTotalPrice();

		try {

			Document document = new Document();
			try {

				PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\publica\\Desktop\\PDF_Boleto"));
				document.open();

				// adicionando um parágrafo no documento
				document.add(new Paragraph("Bradesco                 " + gerarCodigoBoleto()));
				document.add(new Paragraph("--------------------------------------------------------"));
				document.add(new Paragraph("Valor: " + precoComFrete));
				document.add(new Paragraph("Nome do livro: " + livro.getNome()));

				document.add(new Paragraph(usuario.getNome()));

				document.add(new Paragraph("Dia de expedição: " + livroComprado.getHorarioDaCompra().toLocalDate()));
				document.add(new Paragraph(
						"Dia de expiração: " + livroComprado.getHorarioDaCompra().plusDays(5).toLocalDate()));
			} catch (Exception de) {
				System.err.println(de.getMessage());
			}
			document.close();

			String boleto = "----------Boleto----------\n";
			boleto += "\nCódigo: " + gerarCodigoBoleto() + "\n";
			boleto += "Valor: " + precoComFrete + "\n";
			boleto += "\nNome do livro: " + livro.getNome() + "\n";
			boleto += "\n" + usuario.getNome();
			boleto += "\n Dia de expedição" + livroComprado.getHorarioDaCompra().toLocalDate();
			boleto += "\nDia de expiração" + livroComprado.getHorarioDaCompra().plusDays(5).toLocalDate();

			JOptionPane.showMessageDialog(null, boleto);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
		}

	}

	private String gerarCodigoBoleto() {

		String codigo = "";
		for (int i = 0; i < 48; i++) {
			codigo += (int) Math.floor((Math.random() * 10));
		}

		return codigo;
	}

	/**
	 * Mostra todos os livros comprados do cliente
	 * 
	 * @param ususario
	 */
	private void meusLivros(Usuario ususario) {

		List<LivroComprado> meusLivros = livroCompradoService.findAll().stream()
				.filter(lc -> lc.getUsuario().getLogin().equals(ususario.getLogin())).toList();

		meusLivros.forEach(m -> System.out.println(m));

		String lista = "";

		for (LivroComprado lc : meusLivros) {
			lista += lc.getLivro() + "\n";
		}

		JOptionPane.showMessageDialog(null, lista);

	}

	private void alterarConta(String login) {

		String novoNome = JOptionPane.showInputDialog("Insira o novo nome");
		String novoEmail = JOptionPane.showInputDialog("Insira o novo email");
		usuarioService.validarEmail(novoEmail);

		int novaIdade = Integer.parseInt(JOptionPane.showInputDialog("Insira a nova idade"));
		Estado estado = listarEstados();

		String novoLogin = JOptionPane.showInputDialog("Insira o novo login");
		if ((usuarioService.findBy(novoLogin).isPresent()) && (!novoLogin.equals(login))) {

			throw new RuntimeException("Login de usuário já existe");
		}

		String novaSenha = JOptionPane.showInputDialog("Insira a nova senha");
		String novaPerguntaSecreta = JOptionPane.showInputDialog("Insira a nova pergunta secreta");
		String novaResposta = JOptionPane.showInputDialog("Insira a nova resposta");

		usuarioService.update(login, new Usuario(novoNome, novoEmail, novoLogin, novaSenha, novaPerguntaSecreta,
				novaResposta, novaIdade, estado));

	}

	private void deletarMinhaConta(String login) {

		usuarioService.delete(login);

	}

	private String menu() {

		String menu = "(1) Comprar livro \n";
		menu += "(2) Meus livros \n";
		menu += "(3) Alterar conta \n";
		menu += "(4) Remover minha cont \n";
		menu += "(5) Sair";

		return menu;
	}

}
