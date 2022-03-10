package arrays.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Contato> contatos = new ArrayList<>();

		boolean sair = false;

		while (!sair) {

			System.out.println();
			System.out.println("Cadastrar (1)");
			System.out.println("Listar (2)");
			System.out.println("Pesquisar (3)");
			System.out.println("Alterar (4)");
			System.out.println("Remover (5)");
			System.out.println("Sair (6)");
			System.out.println();

			char selectedNumber = sc.next().charAt(0);

			try {
				switch (selectedNumber) {
				case '1' -> {

					System.out.println("Insira o nome: ");
					String nome = sc.next();

					System.out.println("Insira a idade: ");
					int idade = sc.nextInt();

					System.out.println("Insira o e-mail: ");
					String email = sc.next();

					System.out.println("Insira o telefone: ");
					String telefone = sc.next();

					System.out.println("Insira a cidade: ");
					String cidade = sc.next();

					Contato p = new Contato(nome, idade, email, telefone, cidade);

					contatos.add(p);
				}
				case '2' -> contatos.forEach(c -> System.out.println(c));

				case '3' -> {
					System.out.println("Insira o nome do contato");
					String nome = sc.next();
					Contato contato = contatos.stream().filter(c -> c.getNome().equals(nome)).findFirst()
							.orElseThrow(() -> new RuntimeException("Nome não existe"));

					System.out.println(contato.toString());
				}
				case '4' -> {
					System.out.println("Insira o nome do contato");
					String nome = sc.next();
					List<Contato> contatosUpdate = contatos.stream().filter(c -> c.getNome().equals(nome)).toList();

					int indice = 0;

					if (contatosUpdate.isEmpty()) {
						throw new RuntimeException("Nome não existe");
					} else if (contatosUpdate.size() > 1) {

						System.out.println("Ha mais de um contato com esse nome, digite o numero de qual você deseja");

						for (int i = 1; i <= contatosUpdate.size(); i++) {

							System.out.println(i + "º " + contatosUpdate.get(i - 1));
						}
						int n = sc.nextInt();

						Contato contadoSelecinado = contatosUpdate.get(n - 1);

						indice = contatos.indexOf(contadoSelecinado);

					} else {
						indice = contatos.indexOf(contatosUpdate.get(0));
					}

					System.out.println("Insira o novo nome");
					String novoNome = sc.next();

					System.out.println("Insira a nova idade");
					int novaIdade = sc.nextInt();

					System.out.println("Insira o novo email");
					String novoEmail = sc.next();

					System.out.println("Insira o novo telefone");
					String novoTelefone = sc.next();

					System.out.println("Insira a nova cidade");
					String novaCidade = sc.next();

					contatos.set(indice, new Contato(novoNome, novaIdade, novoEmail, novoTelefone, novaCidade));
					System.out.println("Contato alterado");
				}
				case '5' -> {
					System.out.println("Insira o nome do contato");
					String nome = sc.next();
					List<Contato> contatosDelete = contatos.stream().filter(c -> c.getNome().equals(nome)).toList();

					if (contatosDelete.isEmpty()) {
						throw new RuntimeException("Nome não existe");
					} else if (contatosDelete.size() > 1) {

						System.out.println("Ha mais de um contato com esse nome, digite o numero de qual você deseja");

						for (int i = 1; i <= contatosDelete.size(); i++) {

							System.out.println(i + "º " + contatosDelete.get(i - 1));
						}
						int n = sc.nextInt();

						contatos.remove(contatosDelete.get(n - 1));
						System.out.println("Contato excluido");
					} else {
						contatos.remove(contatosDelete.get(0));
						System.out.println("Contato excluido");
					}

				}
				case '6' -> {
					sair = true;
					System.out.println("Aplicação encerrada");
				}
				default -> throw new IllegalArgumentException("Unexpected value: " + selectedNumber);
				}

			} catch (Exception e) {
				System.out.print(e);
			}

		}
		sc.close();

	}

}
