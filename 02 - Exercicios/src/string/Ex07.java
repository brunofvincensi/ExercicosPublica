package string;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String name = "bruno";

		System.out.println(name.contains("br"));

		String[] nomes = new String[10];

		int cont = 0;
		
		while ( cont < nomes.length) {

			System.out.println("Cadastrar nomes (1)");
			System.out.println("Filtrar contatos (2)");
			System.out.println("Finalizar o sistema (3)");

			char select = sc.next().charAt(0);

			switch (select) {
			case '1' -> {
				System.out.println("Insira o nome: ");
				String nome = sc.next();

				nomes[cont] = nome;
				cont++;
			}
			case '2' -> {

				System.out.println("Busque por letra ou nome: ");
				String filtro = sc.next();

				for (int j = 0; j < nomes.length; j++) {

					if (nomes[j] != null) {

						String nomeSelected = nomes[j];

						for (int m = 1; m <= nomeSelected.length(); m++) {

							String teste = nomeSelected.substring(0, m);

							if (filtro.toLowerCase().equals(teste.toLowerCase())) {

								System.out.println(nomeSelected);
								break;
							}
						}

					}
				}

			}
			case '3' -> cont = 10;

			default -> throw new IllegalArgumentException("Unexpected value: " + select);
			}

		}

		System.out.println("finalizado");

		sc.close();
	}

}
