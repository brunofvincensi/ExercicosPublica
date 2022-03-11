package vetores;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] palavras = { "cachorro", "xadrez", "zebra", "calculadora" };

		int indice;

		do {
			indice = (int) (Math.random() * 10);
		} while (indice >= 4);

		char[] palavra = new char[palavras[indice].length()];

		char[] palavraCompleta = new char[palavras[indice].length()];

		for (int i = 0; i < palavraCompleta.length; i++) {

			palavraCompleta[i] = palavras[indice].charAt(i);
		}

		boolean palavraAchada = false;

		System.out.println("A palavra tem " + palavraCompleta.length + " letras");

		for (int i = 0; i < palavra.length; i++) {

			palavra[i] = '?';
		}

		while (!palavraAchada) {

			for (char letra : palavra) {

				System.out.print(letra + " ");
			}
			System.out.println();

			System.out.println("Adicione uma letra");
			char letra = sc.next().charAt(0);

			for (int i = 0; i < palavraCompleta.length; i++) {

				if (palavraCompleta[i] == letra) {
					palavra[i] = letra;
				}
			}

			palavraAchada = true;

			// valida se a palavra foi encontrada
			for (int i = 0; i < palavra.length; i++) {

				if (palavra[i] == '?') {
					palavraAchada = false;
					break;
				}
			}
		}

		System.out.println("Parabens voce achou! a palavra é " + palavras[indice]);

		sc.close();

	}

}
