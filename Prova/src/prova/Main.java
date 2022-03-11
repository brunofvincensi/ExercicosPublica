package prova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		final String DESENVOLVEDOR_JR = "Desenvolvedor Jr";
		final String DESENVOLVEDOR_PLENO = "Desenvolvedor Pleno";
		final String DESENVOLVEDOR_SENIOR = "Desenvolvedor Sênior";
		final String DBA = "DBA";
		final String ARQUITETO_DE_SOFTWARE = "Arquiteto de Software";

		String[][] cargoValores = { { DESENVOLVEDOR_JR, "2000", "12.50", "200", "360" },
				{ DESENVOLVEDOR_PLENO, "3200", "18.90", "320", "420" },
				{ DESENVOLVEDOR_SENIOR, "5000", "25", "500", "500" }, { DBA, "7000", "45", "700", "635" },
				{ ARQUITETO_DE_SOFTWARE, "8500", "70.60", "850", "765" },

		};

		List<String[]> colaboradores = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("Sistema de folha de pagamento");
		System.out.println();

		boolean sair = false;

		while (!sair) {

			System.out.println("Cadastrar (1)");
			System.out.println("Listar (2)");
			System.out.println("Alterar (3)");
			System.out.println("Remover (4)");
			System.out.println("Sair (5)");

			char opcaoSelecionada = sc.next().charAt(0);

			try {
				switch (opcaoSelecionada) {
				case '1' -> {

					System.out.println("Insira o nome do colaborador: (sem espaços)");
					String nome = sc.next();

					for (String[] colaborador : colaboradores) {
						if (colaborador.equals(nome)) {
							throw new RuntimeException("Usuario já existe");
						}
					}

					System.out.println("Insira o cargo");
					System.out.println(DESENVOLVEDOR_JR + " (1)");
					System.out.println(DESENVOLVEDOR_PLENO + " (2)");
					System.out.println(DESENVOLVEDOR_SENIOR + " (3)");
					System.out.println(DBA + " (4)");
					System.out.println(ARQUITETO_DE_SOFTWARE + " (5)");
					char cargoSelecionado = sc.next().charAt(0);

					int index = Integer.parseInt(Character.toString(cargoSelecionado)) - 1;

					String cargo = cargoValores[index][0];

					System.out.println("Insira a quantidade de horas extras: ");
					int horasExtras = sc.nextInt();

					System.out.println("Insira a quantidade de faltas: ");
					int faltas = sc.nextInt();

					System.out.println("Adere ao plano de saúde? s(sim) n(nao)");
					char selecaoSaude = sc.next().charAt(0);

					boolean aderePlanoSaude;

					switch (selecaoSaude) {
					case 's' -> aderePlanoSaude = true;
					case 'n' -> aderePlanoSaude = false;

					default -> throw new IllegalArgumentException("Unexpected value: " + opcaoSelecionada);
					}

					String[] colaborador = { nome, cargo, Integer.toString(horasExtras), Integer.toString(faltas),
							Boolean.toString(aderePlanoSaude) };

					colaboradores.add(colaborador);
				}
				case '2' -> {

					if (colaboradores.isEmpty()) {
						System.out.println("Nenhum colaborador cadastrado");
					} else {
						for (String[] colaborador : colaboradores) {

							String nome = colaborador[0];
							String cargo = colaborador[1];
							int horasExtras = Integer.parseInt(colaborador[2]);
							int faltas = Integer.parseInt(colaborador[3]);
							boolean aderePlanoSaude = Boolean.parseBoolean(colaborador[4]);

							for (String[] cv : cargoValores) {

								System.out.println();

								if (cv[0].equals(cargo)) {

									double salarioBruno = Double.parseDouble(cv[1]);

									double valorHoraExtra = Double.parseDouble(cv[2]);

									double valorImposto = Double.parseDouble(cv[3]);

									double valorValeAlimentacao = Double.parseDouble(cv[4]);

									double horaExtraRecebido = valorHoraExtra * horasExtras;

									double premioFaltas = 0.0;
									double planoSaude = 0.0;

									if (faltas == 0) {
										premioFaltas = 100;
									}

									if (aderePlanoSaude) {
										planoSaude = 400;
									}

									double valeTransporte = salarioBruno * (6.0 / 100.0);

									double salarioLiquido = (salarioBruno + horaExtraRecebido + premioFaltas)
											- (valeTransporte + valorValeAlimentacao + planoSaude + valorImposto);

									System.out.println("Nome: " + nome);
									System.out.println("Salário bruto: " + salarioBruno);
									System.out.println("Cargo: " + cargo);
									System.out.println("Quantidade de horas extras: " + horasExtras);
									System.out.println("Valor recebido pelas horas extras: " + horaExtraRecebido);
									System.out.println("Valor extra recebido pela quantidade faltas: " + premioFaltas);
									System.out.println("Valor a ser descontado do plano de saúde: " + planoSaude);
									System.out.println("Desconto do vale transporte: " + valeTransporte);
									System.out.println("Desconto do vale alimentação: " + valorValeAlimentacao);
									System.out.println("Desconto do imposto de renda: " + valorImposto);
									System.out.println("Salário líquido: " + salarioLiquido);
									System.out.println("---------------------------------------");

								}
							}
						}

					}
				}
				case '3' -> {

					System.out.println("Insira o nome do colaborador que deseja ser alterado: ");
					String nome = sc.next();

					int indexColaborador = -1;

					for (int i = 0; i < colaboradores.size(); i++) {

						if (colaboradores.get(i)[0].equals(nome)) {

							indexColaborador = i;
						}

					}

					if (indexColaborador == -1) {
						throw new RuntimeException("Usuario não existe");
					}

					System.out.println("Insira o novo nome do colaborador: (sem espaços)");
					String novoNome = sc.next();

					System.out.println("Insira o novo cargo");
					System.out.println(DESENVOLVEDOR_JR + " (1)");
					System.out.println(DESENVOLVEDOR_PLENO + " (2)");
					System.out.println(DESENVOLVEDOR_SENIOR + " (3)");
					System.out.println(DBA + " (4)");
					System.out.println(ARQUITETO_DE_SOFTWARE + " (5)");
					char cargoSelecionado = sc.next().charAt(0);

					int index = Integer.parseInt(Character.toString(cargoSelecionado)) - 1;

					String cargo = cargoValores[index][0];

					System.out.println("Insira a nova quantidade de horas extras: ");
					int horasExtras = sc.nextInt();

					System.out.println("Insira a nova quantidade de faltas: ");
					int faltas = sc.nextInt();

					System.out.println("Adere ao plano de saúde? s(sim) n(nao)");
					char selecaoSaude = sc.next().charAt(0);

					boolean aderePlanoSaude;

					switch (selecaoSaude) {
					case 's' -> aderePlanoSaude = true;
					case 'n' -> aderePlanoSaude = false;

					default -> throw new IllegalArgumentException("Unexpected value: " + opcaoSelecionada);
					}

					String[] colaborador = { novoNome, cargo, Integer.toString(horasExtras), Integer.toString(faltas),
							Boolean.toString(aderePlanoSaude) };

					colaboradores.set(indexColaborador, colaborador);

				}
				case '4' -> {

					System.out.println("Insira o nome do colaborador");
					String nomeDelete = sc.next();

					boolean removido = false;

					for (String[] colaborador : colaboradores) {

						if (nomeDelete.equals(colaborador[0])) {

							colaboradores.remove(colaborador);
							removido = true;
						}
					}

					if (removido) {
						System.out.println("Usuario removido");
					} else {
						throw new RuntimeException("Usuario não existe");
					}
				}
				case '5' -> sair = true;

				default -> throw new IllegalArgumentException("Unexpected value: " + opcaoSelecionada);
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("Sistema finalizado");

		sc.close();

	}

}
