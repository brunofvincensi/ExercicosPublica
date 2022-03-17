package sections;

import java.util.List;
import javax.swing.JOptionPane;

import models.LivroComprado;
import models.Livro;
import models.Usuario;
import services.impl.LivroCompradoServiceImpl;
import services.impl.LivroServiceImpl;
import services.impl.UsuarioServiceImpl;

public class ClienteSection {

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
				sair = true;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}

	}

	private void comprarLivro(Usuario usuario) {
		List<Livro> livros = livroService.findAll();
		
		livros.forEach(l -> System.out.println(l));

		String lista = "";
		for (int i = 0; i < livros.size(); i++) {

			lista += "( " + i + " ) -> " + livros.get(i) + " \n";
		}

		lista += "Insira o código do livro que desaja comprar";

		int numeroLivro = Integer.parseInt(JOptionPane.showInputDialog(lista));
		
		Livro livro = livros.get(numeroLivro);
		
		LivroComprado lc = new LivroComprado(usuario, livro);
		
		livroCompradoService.save(lc);
		
		JOptionPane.showMessageDialog(null, "Livro comprado");
		
	}


	  private void meusLivros(Usuario ususario) {
	  
		List<LivroComprado> meusLivros = livroCompradoService
				.findAll()
				.stream().filter(lc -> lc.getUsuario().getLogin().equals(ususario.getLogin()))
				.toList();
		
		meusLivros.forEach(m -> System.out.println(m));
		
		String lista = "";
		
		for(LivroComprado lc : meusLivros) {
			lista += lc.getLivro() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, lista);
	  
	}
	 
	
	private void alterarConta(String login) {
		
		String novoNome = JOptionPane.showInputDialog("Insira o novo nome");
		String novoEmail = JOptionPane.showInputDialog("Insira o novo email");
		String novoLogin = JOptionPane.showInputDialog("Insira o novo login");
		if((usuarioService.findBy(novoLogin).isPresent()) && (!novoLogin.equals(login))) {
			
			throw new RuntimeException("Login de usuário já existe");
		}
		
		String novaSenha = JOptionPane.showInputDialog("Insira a nova senha");
		String novaPerguntaSecreta = JOptionPane.showInputDialog("Insira a nova pergunta secreta");
		String novaResposta = JOptionPane.showInputDialog("Insira a nova resposta");
		int novaIdade =  Integer.parseInt(JOptionPane.showInputDialog("Insira a nova idade"));

		usuarioService.update(novoLogin, new Usuario(novoNome, novoEmail, novoLogin, novaSenha, novaPerguntaSecreta, novaResposta, novaIdade));
		
	}

	private String menu() {

		String menu = "(1) Comprar livro \n";
		menu += "(2) Meus livros \n";
		menu += "(3) Alterar conta \n";
		menu += "(4) Sair";

		return menu;
	}

}
