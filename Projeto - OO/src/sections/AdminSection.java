package sections;

import java.util.List;
import javax.swing.JOptionPane;
import enums.Nivel;
import exceptions.UsuarioNotFoundException;
import models.Usuario;
import services.impl.UsuarioServiceImpl;

public class AdminSection {

	UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();

	public AdminSection() {

		boolean sair = false;

		while (!sair) {

			int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));

			switch (opcao) {
			case 1: gerenciarUsuarios();
			break;
			case 2: gerenciarLivraria();
			break;
			case 3: sair = true;
			break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}

		}

	}
	
	private void gerenciarUsuarios() {
		
		boolean sair = false;
		
		while(!sair) {
			try {
			
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(menuUsuarios()));
			
			switch (opcao) {
			case 1: listarUsuarios();
			break;
			case 2: alterarUsuario();
			break;
			case 3: deletarUsuario();
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
		
		Usuario u =new Usuario();

		
		JOptionPane.showMessageDialog(null, lista);
	}
	
	private void inserirGerente() {

		String nome = JOptionPane.showInputDialog("Insira o nome: ");

		String email = JOptionPane.showInputDialog("Insira o e-mail: ");

		int idade = Integer.parseInt(JOptionPane.showInputDialog("Insira a idade: "));

		String login = JOptionPane.showInputDialog("Crie o login: ");
		
        if(!usuarioService.findBy(login).isEmpty()) {
        	throw new RuntimeException("Usuario já existe");
        }

		String senha = JOptionPane.showInputDialog("Crie a senha: ");

		String perguntaSecreta = JOptionPane.showInputDialog("Crie uma pergunta secreta: ");

		String resposta = JOptionPane.showInputDialog("Resposta da pergunta secreta: ");

		
		
		Usuario gerente = new Usuario(nome, email, login, senha, perguntaSecreta, resposta, idade);
		gerente.setNivel(Nivel.GERENTE);
		
		usuarioService.save(gerente);
		
	}
	
	
	private void deletarUsuario() {
		
		String login = JOptionPane.showInputDialog("Insira o login do usuario");
		
		usuarioService.delete(login);
		
		
	}
	
	private void alterarUsuario() {
		
		String login = JOptionPane.showInputDialog("Insira o login do usuario");
		
		if(usuarioService.findBy(login).isEmpty()) {
        	throw new UsuarioNotFoundException();
        }

		
		String novoNome = JOptionPane.showInputDialog("Insira o novo nome: ");

		String novoEmail = JOptionPane.showInputDialog("Insira o novo e-mail: ");

		int novaIdade = Integer.parseInt(JOptionPane.showInputDialog("Insira a nova idade: "));

		String novoLogin = JOptionPane.showInputDialog("Insira o novo login: ");
		
        if(!usuarioService.findBy(novoLogin).isEmpty()) {
        	throw new RuntimeException("Usuario já existe");
        }

		String novaSenha = JOptionPane.showInputDialog("Insira a nova senha: ");

		String novaPerguntaSecreta = JOptionPane.showInputDialog("Insira a nova pergunta secreta: ");

		String novaResposta = JOptionPane.showInputDialog("Insira a nova reposta: ");

		Usuario novoUsuario = new Usuario(novoNome, novoEmail, novoLogin, novaSenha, novaPerguntaSecreta, novaResposta, novaIdade);
		
		usuarioService.update(login, novoUsuario);
		
	}
	
	private void gerenciarLivraria() {
		
		LivrariaSection ls = new LivrariaSection();
	
	}

	private String menu() {

		String menu = "(1) Gerenciar usuarios \n";
		menu += "(2) Gerenciar livraria \n";
		menu += "(3) Sair";

		return menu;
	}
}
