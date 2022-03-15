package Ex05;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import static Ex05.UsuarioDAO.*;
import static Ex05.LivroDAO.*;

public class Main {

	public static void gerenciarBiblioteca() throws IOException {

		String menuBiblioteca = "(1) Adicionar livro \n(2) Listar livros \n"
				+ "(3) Alterar livro \n(4) Remover Livro \n(5) Sair";

		Scanner sc = new Scanner(System.in);

		boolean sair = false;

		while (!sair) {
			try {

				System.out.println(menuBiblioteca);

				int numSelected = sc.nextInt();

				switch (numSelected) {
				case 1 -> {

					System.out.println("Insira o nome do livro: ");
					String nomeLivro = sc.next();

					System.out.println("Insira o numero de paginas: ");
					int numPaginas = sc.nextInt();

					System.out.println("Insira o preço: ");
					double precoLivro = sc.nextDouble();

					gravarLivro(new Livro(nomeLivro, numPaginas, precoLivro));

				}
				case 2 -> {

					List<Livro> livros = lerLivros();

					livros.forEach(l -> System.out.println(l));

				}
				case 3 -> {

					System.out.println("Insira o nome do livro a ser alterado");
					String nomeUpdate = sc.next();

					if (!livroExiste(nomeUpdate)) {
						throw new RuntimeException("Livro não existe");
					}

					System.out.println("Livro existe");
					System.out.println();
					System.out.println("Insira o novo nome do livro: ");
					String nomeLivro = sc.next();

					System.out.println("Insira o novo numero de paginas: ");
					int numPaginas = sc.nextInt();

					System.out.println("Insira o novo preço: ");
					double precoLivro = sc.nextDouble();

					alterarLivro(nomeUpdate, new Livro(nomeLivro, numPaginas, precoLivro));

				}
				case 4 -> {
					System.out.println("Insira o nome do livro a ser deletado: ");
					String nome = sc.next();
					
					deletarLivro(nome);
				}

				case 5 -> sair = true;

				default -> throw new IllegalArgumentException("Unexpected value: " + numSelected);
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		sc.close();

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Sistema de biblioteca");
		System.out.println();
		boolean sairSistema = false;

		while (!sairSistema) {
			try {
				System.out.println("(1) Fazer login");
				System.out.println("(2) Criar usuario");
				System.out.println("(3) Sair do Sistema");
				int nivel = sc.nextInt();

				switch (nivel) {
				case 1 -> {

					System.out.println("Login: ");
					String login = sc.next();

					System.out.println("Senha: ");
					String senha = sc.next();

					try {
						int nivelUsuario = logar(login, senha);

						if (nivelUsuario == -1) {
							throw new RuntimeException("usuario não existe");
						}

						int itemSelecionado;

						if (nivelUsuario == 1) {

							boolean sairAdmin = false;

							while (!sairAdmin) {

								System.out.println("(1) biblioteca");
								System.out.println("(2) Gerenciar usuários");
								System.out.println("(3) Sair");
								itemSelecionado = sc.nextInt();

								switch (itemSelecionado) {
								case 1 -> {

									gerenciarBiblioteca();

								}

								case 2 -> {

									boolean sair = false;

									while (!sair) {

										System.out.println("(1) Listar");
										System.out.println("(2) Alterar");
										System.out.println("(3) Remover");
										System.out.println("(4) Sair");
										int numberSelected = sc.nextInt();

										switch (numberSelected) {

										case 1 -> {
											try {
												List<Usuario> usuarios = lerUsuarios();
												usuarios.forEach(u -> System.out.println(u));

											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
										case 2 -> {
											System.out.println("Insira o login do usuario: ");
											String loginInput = sc.next();

											System.out.println("Insira o novo login: ");
											String novoLogin = sc.next();

											System.out.println("Insira a nova senha: ");
											String novaSenha = sc.next();

											System.out.println("Insira o novo nivel: (1)admin (2)cliente");
											int novoRole = sc.nextInt();

											if (novoRole != 1 && novoRole != 2) {
												throw new RuntimeException("nivel não existe");
											}

											try {
												alterarUsuario(loginInput, new Usuario(novoLogin, novaSenha, novoRole));
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}

										}
										
										case 3 -> {
											System.out.println("Insira o login do usuario: ");
											String loginInput = sc.next();
											
											deletarUsuario(loginInput);
										}

										case 4 -> sair = true;

										}
									}
								}
								case 3 -> sairAdmin = true;

								default -> throw new IllegalArgumentException("Unexpected value: " + itemSelecionado);
								}

							}
						}

						else {

							boolean sairGerente = false;

							while (!sairGerente) {

								System.out.println("(1) biblioteca");
								System.out.println("(2) Alterar senha");
								System.out.println("(3) Sair");
								itemSelecionado = sc.nextInt();

								switch (itemSelecionado) {
								case 1 -> {
									gerenciarBiblioteca();
								}

								case 2 -> {
									System.out.println("Insira a nova senha: ");
									String novaSenha = sc.next();
									
									alterarSenha(login, novaSenha);
								}

								case 3 -> sairGerente = true;

								default -> throw new IllegalArgumentException("Unexpected value: " + itemSelecionado);
								}

							}

						}

					} catch (IOException e) {

						System.out.println(e);
					}

				}

				case 2 -> {
					System.out.println("Insira o login: ");
					String login = sc.next();

					System.out.println("Insira a senha: ");
					String senha = sc.next();

					System.out.println("Insira o nivel: (1)admin (2)cliente");
					int role = sc.nextInt();

					if (role != 1 && role != 2) {
						throw new RuntimeException("nivel não existe");
					}

					try {
						gravarUsuario(new Usuario(login, senha, role));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				case 3 -> sairSistema = true;
				default -> throw new IllegalArgumentException("Unexpected value: " + nivel);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		System.out.println("Sistema finalizado");
		sc.close();

	}

	
}
