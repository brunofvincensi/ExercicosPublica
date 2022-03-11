package vetores;

import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[][] produtos = { { "TV", "12", "1000" }, { "Geladeira", "7", "800" }, { "xbox", "4", "3000" },
				{ "tapete", "0", "34,50" }, { "computador", "10", "1199.99" }, { "garrafa", "23", "10" },
				{ "teclado", "0", "45" }, { "mouse", "4", "25" }, { "óculos", "55", "299.99" },
				{ "baralho", "32", "30" } };

		String[][] produtosComprados = new String[30][3];

		for (String[] produto : produtos) {

			if (Integer.parseInt(produto[1]) > 0) {

				System.out.print(produto[0] + " ");
				System.out.print(produto[1] + " ");
				System.out.print(produto[2] + " ");
				System.out.println();
			}
		}
		System.out.println("---------------------");
		System.out.println();

		boolean continuar = true;
		int cont = 0;

		while (continuar) {

			System.out.println("Insira o nome do produto a ser comprado");
			String nome = sc.next();

			System.out.println("Insira a quantidade");
			int quantidade = sc.nextInt();

			boolean existe = true;

			for (String[] produto : produtos) {

				if (produto[0].equals(nome)) {

					existe = true;

					int quantidadeProduto = Integer.parseInt(produto[1]);

					if (quantidadeProduto >= quantidade) {

						produtosComprados[cont][0] = produto[0];
						produtosComprados[cont][1] = Integer.toString(quantidade);
						produtosComprados[cont][2] = produto[2];

						int quantidadeRestante = quantidadeProduto - quantidade;

						break;
					} else {
						System.out.println("quantidade insificiente");
					}
				}

				else {
					existe = false;
				}
			}

			if (!existe) {
				System.out.println("Produto não existe");
			}

			System.out.println("Comprar novamente? y(yes) n(no)");
			char inputChar = sc.next().charAt(0);

			if (inputChar != 'y') {
				continuar = false;
			}

			cont++;
		}

		double valorTotal = 0.0;

		for (String[] produtoComprado : produtosComprados) {

			if (produtoComprado[0] != null) {

				System.out.print(produtoComprado[0] + " ");
				System.out.print(produtoComprado[1] + " ");
				System.out.print(produtoComprado[2] + " ");
				System.out.println();

				valorTotal += (Integer.parseInt(produtoComprado[1]) * Double.parseDouble(produtoComprado[2]));
			}

		}
		System.out.println("-------------------------");
		System.out.println("Valor Total: R$" + valorTotal);

		sc.close();

	}

}
