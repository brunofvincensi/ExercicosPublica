package sections;

import java.util.List;
import javax.swing.JOptionPane;

import auxiliares.ListarEstados;
import enums.Estado;
import enums.Nivel;
import exceptions.UsuarioNotFoundException;
import models.LivroComprado;
import models.Usuario;
import services.impl.LivroCompradoServiceImpl;
import services.impl.UsuarioServiceImpl;

// classe para abrir a secao do administrador
public class AdminSection extends ListarEstados {

	UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
	LivroCompradoServiceImpl livroCompradoService = new LivroCompradoServiceImpl();

	public AdminSection(Usuario usuario) {

		boolean sair = false;

		while (!sair) {

			int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));

			switch (opcao) {
			case 1: gerenciarUsuarios(usuario);
			break;
			case 2: gerenciarLivraria();
			break;
			case 3: listarCompras();
			break;
			case 4: sair = true;
			break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}

		}

	}
	
	private void listarCompras() {
		
		List<LivroComprado> livrosComprados = livroCompradoService.findAll();
		
		String lista = "";
		
		for(LivroComprado lc : livrosComprados) {
			
			lista += lc + "\n";
		}
			JOptionPane.showMessageDialog(null, lista);	
		
	}

	private void gerenciarUsuarios(Usuario usuario) {
		
		boolean sair = false;
		
		while(!sair) {
			try {
			
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(menuUsuarios()));
			
			switch (opcao) {
			case 1: listarUsuarios();
			break;
			case 2: alterarUsuario();
			break;
			case 3: deletarUsuario(usuario);
			break;
			case 4: inserirGerente();
			break;
			case 5: sair = true;
			break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}			
		}		
	}	

	private String menuUsuarios() {
		
		String menu = "(1) Listar usuarios\n";
		menu += "(2) Alterar usuario\n";
		menu += "(3) Deletar usuario\n";
		menu += "(4) Inserir gerente\n";
		menu += "(5) Sair";
		
		return menu;
	}
	
	private void listarUsuarios() {
		
		List<Usuario> usuarios = usuarioService.findAll();
		
		String lista = "";
		for(Usuario u : usuarios) {
			lista += u + " \n";
		}
		
		Usuario u = new Usuario();

		
		JOptionPane.showMessageDialog(null, lista);
	}
	
	private void inserirGerente() {

		String nome = JOptionPane.showInputDialog("Insira o nome: ");

		String email = JOptionPane.showInputDialog("Insira o e-mail: ");
		
		usuarioService.validarEmail(email);

		int idade = Integer.parseInt(JOptionPane.showInputDialog("Insira a idade: "));

		Estado estado = listarEstados();
		
		String login = JOptionPane.showInputDialog("Crie o login: ");
		
        if(!usuarioService.findBy(login).isEmpty()) {
        	throw new RuntimeException("Usuario já existe");
        }

		String senha = JOptionPane.showInputDialog("Crie a senha: ");

		String perguntaSecreta = JOptionPane.showInputDialog("Crie uma pergunta secreta: ");

		String resposta = JOptionPane.showInputDialog("Resposta da pergunta secreta: ");

		
		
		Usuario gerente = new Usuario(nome, email, login, senha, perguntaSecreta, resposta, idade, estado);
		gerente.setNivel(Nivel.GERENTE);
		
		usuarioService.save(gerente);
		
	}
	
	
	private void deletarUsuario(Usuario usuario) {
		
		String login = JOptionPane.showInputDialog("Insira o login do usuario");
		
		if(login.equals(usuario.getLogin())) {
			throw new RuntimeException("Não pode deletar a conta admin");
		}
		
		usuarioService.delete(login);
		
		
	}
	
	private void alterarUsuario() {
		
		String login = JOptionPane.showInputDialog("Insira o login do usuario");
		
		if(usuarioService.findBy(login).isEmpty()) {
        	throw new UsuarioNotFoundException();
        }

		
		String novoNome = JOptionPane.showInputDialog("Insira o novo nome: ");

		String novoEmail = JOptionPane.showInputDialog("Insira o novo e-mail: ");
		usuarioService.validarEmail(novoEmail);
		
		int novaIdade = Integer.parseInt(JOptionPane.showInputDialog("Insira a nova idade: "));

		Estado estado = listarEstados();
		
		String novoLogin = JOptionPane.showInputDialog("Insira o novo login: ");
		
        if(!usuarioService.findBy(novoLogin).isEmpty()) {
        	throw new RuntimeException("Usuario já existe");
        }

		String novaSenha = JOptionPane.showInputDialog("Insira a nova senha: ");

		String novaPerguntaSecreta = JOptionPane.showInputDialog("Insira a nova pergunta secreta: ");

		String novaResposta = JOptionPane.showInputDialog("Insira a nova reposta: ");
		
		
		Usuario novoUsuario = new Usuario(novoNome, novoEmail, novoLogin, novaSenha,
				novaPerguntaSecreta, novaResposta, novaIdade, estado);
		
		usuarioService.update(login, novoUsuario);
		
	}
	
	private void gerenciarLivraria() {
		
		LivrariaSection ls = new LivrariaSection();
	
	}

	private String menu() {

		String menu = "(1) Gerenciar usuarios \n";
		menu += "(2) Gerenciar livraria \n";
		menu += "(3) Listar compras dos livros \n";
		menu += "(4) Sair";

		return menu;
	}
}
