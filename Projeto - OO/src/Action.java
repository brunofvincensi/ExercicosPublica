import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import enums.Nivel;
import models.Autor;
import models.Livro;
import models.Usuario;
import services.LoginService;
import services.impl.UsuarioServiceImpl;

public class Action {
	ArrayList<Usuario> usuarios = new ArrayList<>();

	List<Autor> autores = new ArrayList<>();

	List<Livro> livros = new ArrayList<>();

	UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();

	int senhasErradas = 0;

	int respostasErradas = 0;

	public Action() {

		criarAdmin();

		int opcao = 0;

		try {
			do {

				opcao = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal()));

				realizarAcao(opcao);

			} while (opcao != 4);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void criarAdmin() {
		Usuario admin = new Usuario("Bruno Ferrari", "bruno@gmail.com", "bvincensi", "12345",
				"qual é meu esporte favorito?", "basket", 18);

		admin.setNivel(Nivel.Administrador);
		usuarioService.cadastrar(admin);

	}

	private String menuPrincipal() {

		String menu = "(1) Fazer login \n";
		menu += "(2) Cadastrar \n";
		menu += "(3) Esqueci minha senha \n";
		menu += "(4) Sair";

		return menu;
	}

	private void realizarAcao(int opcao) {

		try {
			switch (opcao) {
			case 1 -> fazerLogin();

			case 2 -> cadastrar();

			case 3 -> esqueciMinhaSenha();

			case 4 -> JOptionPane.showMessageDialog(null, "Sistema finalizado, obrigado!");

			default -> throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	private void cadastrar() {

		String nome = JOptionPane.showInputDialog("Insira seu nome: ");

		String email = JOptionPane.showInputDialog("Insira seu e-mail: ");

		int idade = Integer.parseInt(JOptionPane.showInputDialog("Insira sua idade: "));

		String login = JOptionPane.showInputDialog("Crie um login: ");

		String senha = JOptionPane.showInputDialog("Crie uma senha: ");

		String perguntaSecreta = JOptionPane.showInputDialog("Crie uma pergunta secreta: ");

		String resposta = JOptionPane.showInputDialog("Resposta da pergunta secreta: ");

		usuarioService.cadastrar(new Usuario(nome, email, login, senha, perguntaSecreta, resposta, idade));
	}

	private void esqueciMinhaSenha() throws InterruptedException {

		String login = JOptionPane.showInputDialog("Login: ");

		String email = JOptionPane.showInputDialog("Email: ");

		String pergunta = usuarioService.esqueciMinhaSenha(login, email);

		boolean acertou = false;
		while (!acertou) {

			if (respostasErradas <= 3) {

				String resposta = JOptionPane.showInputDialog(pergunta);

				if (usuarioService.checarResposta(login, resposta)) {

					String novaSenha = JOptionPane.showInputDialog("Nova senha: ");
					usuarioService.alterarSenha(login, novaSenha);
					respostasErradas = 0;
					acertou = true;

				} else {

					JOptionPane.showMessageDialog(null, "Resposta errada");
					respostasErradas++;
				}

			}

			else {

				acertou = true;
				respostasErradas = 0;

				setTimeOut(6);


			}
		}
	}

	private void fazerLogin() {

		boolean acertou = false;
		
		
		String login = JOptionPane.showInputDialog("Login: ");

		String senha = JOptionPane.showInputDialog("Senha: ");

		while (!acertou) {

			if (senhasErradas <= 3) {

				if (usuarioService.autenticar(login, senha)) {

					System.out.println("Autenticado");
					acertou = true;
				} else {
					
					
					senha = JOptionPane.showInputDialog("Senha incorreta, tente novamente: ");
					senhasErradas++;
					setTimeOut(6);

				}

			} else {
				
				acertou = true;
				senhasErradas = 0;

				

			}

		}	
		

	}
	
	
	private static void setTimeOut(int segundos) {
		LocalDateTime fim = LocalDateTime.now().plusSeconds(segundos);

		JOptionPane.showMessageDialog(null, "Você foi bloqueado, aguarde 5 segundos");

		while (LocalDateTime.now().isBefore(fim)) {

		}
	}
	
	
	
	
}
