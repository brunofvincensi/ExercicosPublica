package prova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String DESENVOLVEDOR_JR = "Desenvolvedor Jr";
		final String DESENVOLVEDOR_PLENO = "Desenvolvedor Pleno";
		final String DESENVOLVEDOR_SENIOR = "Desenvolvedor Sênior";
		final String DBA = "DBA";
		final String ARQUITETO_DE_SOFTWARE = "Arquiteto de Software";

		String[][] cargoValores = { { DESENVOLVEDOR_JR, "2000", "12,50", "200", "360" },
				{ DESENVOLVEDOR_PLENO, "3200", "18,90", "320", "420" },
				{ DESENVOLVEDOR_SENIOR, "5000", "25", "500", "500" }, { DBA, "7000", "45", "700", "635" },
				{ ARQUITETO_DE_SOFTWARE, "8500", "70,60", "850", "765" },

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

					System.out.println("Insira o cargo");
					System.out.println(DESENVOLVEDOR_JR + " (1)");
					System.out.println(DESENVOLVEDOR_PLENO + " (2)");
					System.out.println(DESENVOLVEDOR_SENIOR + " (3)");
					System.out.println(DBA + " (4)");
					System.out.println(ARQUITETO_DE_SOFTWARE + " (5)");
					char cargoSelecionado = sc.next().charAt(0);

					int index = cargoSelecionado - 1;

					String cargo = cargoValores[index][0];

					System.out.println("Insira a quantidade de horas extras: ");
					int horasExtras = sc.nextInt();

					System.out.println("Insira a quantidade de faltas: ");
					int faltas = sc.nextInt();

					System.out.println("Adere ao plano de saúde? s(sim) n(nao)");
					char selecaoSaude = sc.next().charAt(0);

					boolean aderePlanoSaude;

					switch (selecaoSaude) {
					case 'y' -> aderePlanoSaude = true;
					case 'n' -> aderePlanoSaude = false;

					default -> throw new IllegalArgumentException("Unexpected value: " + opcaoSelecionada);
					}

					String[] colaborador = { nome, cargo, Integer.toString(horasExtras), Integer.toString(faltas),
							Boolean.toString(aderePlanoSaude) };
				}
				case '2' -> {

				}
				case '3' -> {

				}
				case '4' -> {

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
