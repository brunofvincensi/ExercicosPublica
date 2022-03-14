package Ex02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<>();

		List<Prova> provas = new ArrayList<>();

		List<Notas> notas = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		boolean sair = false;

		
			while (!sair) {

				System.out.println("Cadastrar alunos (1)");
				System.out.println("Cadastrar prova (2)");
				System.out.println("Cadastrar notas (3)");
				System.out.println("Selecionar alunos (4)");
				System.out.println("Alterar alunos(5)");
				System.out.println("Alterar provas(6)");
				System.out.println("Alterar notas(7)");
				System.out.println("Remover alunos(8)");
				System.out.println("Remover provas(9)");
				System.out.println("Remover notas(10)");
				System.out.println("Sair (11)");
				int numSelected = sc.nextInt();

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				try {
				switch (numSelected) {
				case 1 -> {

					Aluno a = new Aluno();

					System.out.println("Insira o nome");
					a.setNome(sc.next());

					System.out.println("Insira a turma");
					a.setTurma(sc.next());

					System.out.println("Insira o telefone");
					a.setTelefone(sc.next());

					System.out.println("Insira o nascimento, exemplo(23/06/1999)");
					String inputNascimento = sc.next();

					LocalDate ld = LocalDate.parse(inputNascimento, formatter);

					a.setAniversario(ld);

					alunos.add(a);
				}
				case 2 -> {

					Prova p = new Prova();

					System.out.println("Inisira o nome");
					p.setNome(sc.next());

					System.out.println("Insira a materia");
					p.setMateria(sc.next());
					System.out.println();

					provas.add(p);
				}
				case 3 -> {

					if (provas.isEmpty() || alunos.isEmpty()) {
						throw new RuntimeException("sem provas ou alunos");
					}

					Notas n = new Notas();

					System.out.println("Insira o numero da prova");
					for (int i = 1; i <= provas.size(); i++) {

						System.out.println(i + " -> " + provas.get(i - 1));

					}

					int provasNum = sc.nextInt();

					System.out.println("Insira o numero do aluno");
					for (int i = 1; i <= alunos.size(); i++) {

						System.out.println(i + " -> " + alunos.get(i - 1));

					}

					int alunosNum = sc.nextInt();

					System.out.println("Insira a nota");
					n.setNota(sc.nextDouble());

					n.setAluno(alunos.get(alunosNum - 1));

					n.setProva(provas.get(provasNum - 1));

					notas.add(n);

				}
				case 4 -> {

					List<Aluno> alunosFilter = new ArrayList<>();

					System.out.println("Deseja selecionar por nome (1) ou turma (2)? ");
					char x = sc.next().charAt(0);

					int indiceAluno = 0;

					switch (x) {
					case '1' -> {
						System.out.println("Insira o nome do aluno");

						String nome = sc.next();

						alunosFilter = alunos.stream().filter(a -> a.getNome().equals(nome)).toList();

						while (indiceAluno < alunosFilter.size()) {

							System.out.println((indiceAluno + 1) + " -> " + alunosFilter.get(indiceAluno).getNome()
									+ ", turma " + alunosFilter.get(indiceAluno).getTurma());

							indiceAluno++;
						}

						System.out.print("insira o código");
						indiceAluno = sc.nextInt();

					}

					case '2' -> {

						System.out.print("Insira a turma do aluno");

						String turma = sc.next();

						alunosFilter = alunos.stream().filter(a -> a.getTurma().equals(turma)).toList();

						while (indiceAluno < alunosFilter.size()) {

							System.out.println((indiceAluno + 1) + " -> " + alunosFilter.get(indiceAluno).getNome());

							indiceAluno++;
						}

						System.out.print("insira o código");
						indiceAluno = sc.nextInt();

					}

					default -> throw new IllegalArgumentException("Unexpected value: " + x);

					}

					Aluno alunoFiltrado = alunosFilter.get(indiceAluno - 1);

					System.out.println(alunoFiltrado);

					List<Notas> notasFiltradas = notas.stream()
							.filter(n -> n.getAluno().getNome().equals(alunoFiltrado.getNome())).toList();
					// .orElseThrow(() -> new RuntimeException("Este aulo não contem notas"));

					System.out.println();
					Double cont = 0.0;

					for (Notas n : notasFiltradas) {
						System.out.println(n);
						cont += n.getNota();
					}
					System.out.println("Média: " + cont / notasFiltradas.size());
					System.out.println();

				}
				case 5 -> {
					for (int i = 0; i < alunos.size(); i++) {
						System.out.println((i + 1) + " -> " + alunos.get(i));
					}
					System.out.print("insira o código do aluno");
					int index = sc.nextInt() - 1;

					Aluno a = new Aluno();

					System.out.println("Insira o novo nome");
					a.setNome(sc.next());

					System.out.println("Insira a nova turma");
					a.setTurma(sc.next());

					System.out.println("Insira o novo telefone");
					a.setTelefone(sc.next());

					System.out.println("Insira o novo nascimento, exemplo(23/06/1999)");
					String inputNascimento = sc.next();

					LocalDate ld = LocalDate.parse(inputNascimento, formatter);

					a.setAniversario(ld);

					alunos.set(index, a);
				}
				case 6 -> {

					for (int i = 0; i < provas.size(); i++) {
						System.out.println((i + 1) + " -> " + provas.get(i));
					}
					System.out.print("insira o código da prova");
					int index = sc.nextInt() - 1;

					Prova p = new Prova();

					System.out.println("Inisira o novo nome");
					p.setNome(sc.next());

					System.out.println("Insira a nova materia");
					p.setMateria(sc.next());
					System.out.println();

					provas.set(index, p);

				}
				case 7 -> {
					for (int i = 0; i < notas.size(); i++) {
						System.out.println((i + 1) + " -> " + notas.get(i));
					}
					System.out.print("insira o código da nota");
					int index = sc.nextInt() - 1;

					System.out.println("Insira a nova nota");
					double novaNota = sc.nextDouble();

					notas.get(index).setNota(novaNota);

				}
				case 8 -> {
					for (int i = 0; i < alunos.size(); i++) {
						System.out.println((i + 1) + " -> " + alunos.get(i));
					}
					System.out.print("insira o código do aluno");
					int index = sc.nextInt() - 1;

					alunos.remove(index);
				}
				case 9 -> {

					for (int i = 0; i < provas.size(); i++) {
						System.out.println((i + 1) + " -> " + provas.get(i));
					}
					System.out.print("insira o código da prova");
					int index = sc.nextInt() - 1;

					provas.remove(index);
				}
				case 10 -> {
					for (int i = 0; i < notas.size(); i++) {
						System.out.println((i + 1) + " -> " + notas.get(i));
					}
					System.out.print("insira o código da nota");
					int index = sc.nextInt() - 1;

					notas.remove(index);

				}
				case 11 -> sair = true;

				default -> throw new IllegalArgumentException("Unexpected value: " + numSelected);
				}

			
		} catch (Exception e) {
			System.out.println(e);
		}}

		System.out.println("Sistema finalizado");
		sc.close();
	}

}
