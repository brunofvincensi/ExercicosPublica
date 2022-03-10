package arrays.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.naming.NameNotFoundException;

public class Main {

	public static void main(String[] args) throws NameNotFoundException {

		Scanner sc = new Scanner(System.in);

		List<String[]> alunos = new ArrayList<>();

		boolean sair = false;

		while (!sair) {

			System.out.println();
			System.out.println("Cadastrar (1)");
			System.out.println("Listar (2)");
			System.out.println("Pesquisar (3)");
			System.out.println("Alterar (4)");
			System.out.println("Remover (5)");
			System.out.println("Estatísticas (6)");
			System.out.println("Sair (7)");
			System.out.println();
			char selectedNumber = sc.next().charAt(0);

			try {
				switch (selectedNumber) {

				case '1' -> {
					String[] aluno = new String[5];

					System.out.println("Insira o nome");
					aluno[0] = sc.next();

					System.out.println("Insira o gênero m(masculino) f(feminino)");
					aluno[1] = Character.toString(sc.next().charAt(0));

					System.out.println("Insira a primeira nota");
					aluno[2] = Double.toString(sc.nextDouble());

					System.out.println("Insira a segunda nota");
					aluno[3] = Double.toString(sc.nextDouble());

					System.out.println("Insira o turno m(matutino) n(noturno)");
					aluno[4] = Character.toString(sc.next().charAt(0));

					alunos.add(aluno);
				}
				case '2' -> {

					for (int i = 0; i < alunos.size(); i++) {

						System.out.print("Aluno " + (i + 1));
						System.out.print(" nome: " + alunos.get(i)[0]);
						System.out.print(", gênero: " + alunos.get(i)[1]);
						System.out.print(", nota 1: " + alunos.get(i)[2]);
						System.out.print(", nota 2: " + alunos.get(i)[3]);
						System.out.print(", turno: " + alunos.get(i)[4]);
						System.out.println();

					}

				}
				case '3' -> {
					System.out.println("Insira o nome do aluno");
					String nome = sc.next();

					List<String[]> filtroAlunos = alunos.stream().filter(a -> a[0].equals(nome)).toList();

					int indice = 0;

					if (filtroAlunos.isEmpty()) {
						throw new RuntimeException("Nenhum aluno encontrado");
					} else if (filtroAlunos.size() > 1) {
						System.out.println("Ha mais de um com esse nome, digite o numero do aluno de qual você deseja");
						for (int i = 0; i < filtroAlunos.size(); i++) {
							System.out.print(filtroAlunos.get(i)[0]);
							System.out.println(" nº " + (i + 1));
						}

						int n = sc.nextInt();
						indice = n - 1;
					}

					double nota1 = Double.parseDouble(filtroAlunos.get(indice)[2]);
					double nota2 = Double.parseDouble(filtroAlunos.get(indice)[3]);

					double media = (nota1 + nota2) / 2;

					System.out.println();
					System.out.print("nome: " + filtroAlunos.get(indice)[0]);
					System.out.print(", gênero: " + filtroAlunos.get(indice)[1]);
					System.out.print(", nota 1: " + nota1);
					System.out.print(", nota 2: " + nota2);
					System.out.print(", turno: " + filtroAlunos.get(indice)[4]);
					System.out.println(", media: " + media);
				}
				case '4' -> {
					System.out.println("Insira o nome do aluno");
					String nome = sc.next();

					List<String[]> filtroAlunos = alunos.stream().filter(a -> a[0].equals(nome)).toList();

					int indiceFiltro = 0;
					int indice = 0;

					if (filtroAlunos.isEmpty()) {
						throw new RuntimeException("Nenhum aluno encontrado");
					} else if (filtroAlunos.size() > 1) {
						System.out.println("Ha mais de um com esse nome, digite o numero do aluno de qual você deseja");
						for (int i = 0; i < filtroAlunos.size(); i++) {
							System.out.print(filtroAlunos.get(i)[0]);
							System.out.println(" nº " + (i + 1));
						}
						int n = sc.nextInt();
						indiceFiltro = n - 1;

					}

					indice = alunos.indexOf(filtroAlunos.get(indiceFiltro));

					String[] novoAluno = new String[5];

					System.out.println("Insira o novo nome");
					novoAluno[0] = sc.next();

					System.out.println("Insira o novo gênero m(masculino) f(feminino)");
					novoAluno[1] = sc.next();

					System.out.println("Insira a nova nota 1");
					novoAluno[2] = Character.toString(sc.next().charAt(0));

					System.out.println("Insira a nova nota 2");
					novoAluno[3] = Character.toString(sc.next().charAt(0));

					System.out.println("Insira o novo turno");
					novoAluno[4] = sc.next();

					alunos.set(indice, novoAluno);

				}
				case '5' -> {
					System.out.println("Insira o nome do aluno");
					String nome = sc.next();

					List<String[]> filtroAlunos = alunos.stream().filter(a -> a[0].equals(nome)).toList();

					int indiceFiltro = 0;
					int indice = 0;

					if (filtroAlunos.isEmpty()) {
						throw new RuntimeException("Nenhum aluno encontrado");
					} else if (filtroAlunos.size() > 1) {
						System.out.println("Ha mais de um com esse nome, digite o numero do aluno de qual você deseja");
						for (int i = 0; i < filtroAlunos.size(); i++) {
							System.out.print(filtroAlunos.get(i)[0]);
							System.out.println(" nº " + (i + 1));
						}
						int n = sc.nextInt();
						indiceFiltro = n - 1;

					}

					indice = alunos.indexOf(filtroAlunos.get(indiceFiltro));

					alunos.remove(indice);
				}
				case '6' -> {

					int cont = 0;
					int contMasculino = 0;
					int contFeminino = 0;
					int contTurnoMatutino = 0;
					int contTurnoNoturno = 0;
					int contAprovado = 0;
					int contReprovado = 0;

					for (String[] aluno : alunos) {

						if (aluno[1].equals("m")) {
							contMasculino++;
						} else {
							contFeminino++;
						}

						if (aluno[4].equals("m")) {
							contTurnoMatutino++;
						} else {
							contTurnoNoturno++;
						}

						double media = (Double.parseDouble(aluno[3]) + Double.parseDouble(aluno[3])) / 2;

						if (media >= 7) {
							contAprovado++;
						} else {
							contReprovado++;
						}

						cont++;
					}

					System.out.println("Quantidade de alunos cadastrados: " + cont);
					System.out.println("Quantidade de alunos no turno matutino: " + contTurnoMatutino);
					System.out.println("Quantidade de alunos no turno noturno: " + contTurnoNoturno);
					System.out.println("Quantidade de alunos masculinos: " + contMasculino);
					System.out.println("Quantidade de alunos femininos: " + contFeminino);
					System.out.println("Quantidade de alunos com média superior ou igual a 7: " + contAprovado);
					System.out.println("Quantidade de alunos com média inferior a 7: " + contReprovado);

				}
				case '7' -> {
					sair = true;
					System.out.println("Programa encerrado");
				}
				default -> throw new IllegalArgumentException("Unexpected value: " + selectedNumber);
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		sc.close();
	}

}
