import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import auxiliares.ListarEstados;
import enums.Estado;
import enums.Nivel;
import enums.TipoGenero;
import models.Autor;
import models.Livro;
import models.LivroComprado;
import models.Usuario;
import sections.AdminSection;
import sections.ClienteSection;
import sections.LivrariaSection;
import services.impl.AutorServiceImpl;
import services.impl.LivroCompradoServiceImpl;
import services.impl.LivroServiceImpl;
import services.impl.UsuarioServiceImpl;

public class Action extends ListarEstados{
	ArrayList<Usuario> usuarios = new ArrayList<>();

	List<Autor> autores = new ArrayList<>();

	List<Livro> livros = new ArrayList<>();

	UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();
	LivroServiceImpl livroService = new LivroServiceImpl();
	AutorServiceImpl autorService = new AutorServiceImpl();
	LivroCompradoServiceImpl lcs = new LivroCompradoServiceImpl();

	int senhasErradas = 0;
	int respostasErradas = 0;

	public Action() {

		instanciarObjetos();

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

	private void instanciarObjetos() {
		
		Autor a1 = new Autor("Pedro", 40, "pedro@gmail.com", Estado.PR);

		autorService.save(a1);

		Livro l1 = new Livro("Hero", 40, TipoGenero.ACAO, 75, a1);
		Livro l2 = new Livro("Bruxa de Blair", 120, TipoGenero.TERROR, 49.99, a1);

		livroService.save(l1);
		livroService.save(l2);


		Usuario admin = new Usuario("Bruno Ferrari", "bruno@gmail.com", "bvincensi", "12345",
				"qual é meu esporte favorito?", "basket", 18, Estado.PR);
		
		admin.setNivel(Nivel.ADMIN);
		usuarioService.save(admin);
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

	/**
	 * cadastra um usuario com o nível de cliente
	 */
	private void cadastrar() {

		String nome = JOptionPane.showInputDialog("Insira seu nome: ");

		String email = JOptionPane.showInputDialog("Insira seu e-mail: ");

		usuarioService.validarEmail(email);

		int idade = Integer.parseInt(JOptionPane.showInputDialog("Insira sua idade: "));
		
		Estado estado = listarEstados();

		String login = JOptionPane.showInputDialog("Crie um login: ");

		String senha = JOptionPane.showInputDialog("Crie uma senha: ");

		String perguntaSecreta = JOptionPane.showInputDialog("Crie uma pergunta secreta: ");

		String resposta = JOptionPane.showInputDialog("Resposta da pergunta secreta: ");

		usuarioService.save(new Usuario(nome, email, login, senha, perguntaSecreta, resposta, idade, estado));
	}

	/**
	 * solicita o login e email para lancar a pergunta secreta, se errar tres vezes bloqueia por 10 minutos
	 */
	private void esqueciMinhaSenha() throws InterruptedException {

		String login = JOptionPane.showInputDialog("Login: ");
		String email = JOptionPane.showInputDialog("Email: ");

		String pergunta = usuarioService.esqueciMinhaSenha(login, email);
		String resposta = JOptionPane.showInputDialog(pergunta);
		boolean sair = false;
		while (!sair) {

			if (respostasErradas < 2) {

				if (usuarioService.checarResposta(login, resposta)) {

					String novaSenha = JOptionPane.showInputDialog("Nova senha: ");
					usuarioService.alterarSenha(login, novaSenha);
					respostasErradas = 0;
					sair = true;

				} else {

					char opcao = JOptionPane
							.showInputDialog("Resposta incorreta, deseja tentar novamente? s(sim) n(nao)").charAt(0);

					try {
						switch (opcao) {
						case 's': {
							resposta = JOptionPane.showInputDialog(pergunta);
							respostasErradas++;

						}
							break;
						case 'n': {
							respostasErradas++;
							sair = true;

						}
							break;

						default:
							throw new IllegalArgumentException("Unexpected value: " + opcao);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}

				}

			}

			else {

				setTimeOut(10);
				sair = true;
				respostasErradas = 0;

			}
		}
	}

	/**
	 * faz o login para entra na secao correspondente do usuario, se errar a senha por 
	 * tres vezes é bloqueado por 3 minuts
	 */
	private void fazerLogin() {

		boolean sair = false;

		String login = JOptionPane.showInputDialog("Login: ");

		String senha = JOptionPane.showInputDialog("Senha: ");

		while (!sair) {

			if (senhasErradas < 2) {

				if (usuarioService.autenticar(login, senha)) {
					System.out.println("Autenticado");
					Usuario usuario = usuarioService.findBy(login).get();
					Nivel nivel = usuario.getNivel();
					senhasErradas = 0;

					if (nivel == Nivel.ADMIN) {

						System.out.println("Admin");
						AdminSection adm = new AdminSection(usuario);

					} else if (nivel == Nivel.GERENTE) {

						System.out.println("Gerente");
						LivrariaSection gs = new LivrariaSection();

					} else {
						System.out.println("Cliente");
						ClienteSection cli = new ClienteSection(usuario);

					}

					sair = true;
				} else {

					char opcao = JOptionPane.showInputDialog("Senha incorreta, deseja tentar novamente? s(sim) n(nao)")
							.charAt(0);

					try {
						switch (opcao) {
						case 's': {
							senha = JOptionPane.showInputDialog("Insira a senha novamente");

							senhasErradas++;
						}
							break;
						case 'n': {
							senhasErradas++;
							sair = true;

						}
							break;

						default:
							throw new IllegalArgumentException("Unexpected value: " + opcao);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}

				}

			} else {
				setTimeOut(3);
				sair = true;
				senhasErradas = 0;

			}

		}

	}

	private static void setTimeOut(int minutos) {
		LocalDateTime fim = LocalDateTime.now().plusMinutes(minutos);

		JOptionPane.showMessageDialog(null, "Você foi bloqueado, aguarde " + minutos + " minutos");

		while (LocalDateTime.now().isBefore(fim)) {

		}
	}

}
