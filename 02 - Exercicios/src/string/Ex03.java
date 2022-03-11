package string;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira uma palavra ou frase");
		String palavra = sc.next();

		int validacao = -1;

		for (int i = 0; i < (int) Math.floor(palavra.length() / 2); i++) {

			if (palavra.charAt(i) != palavra.charAt(palavra.length() - 1 - i)) {

				validacao = 1;

			}

		}
		if (validacao == -1) {
			System.out.println("é um palíndromo");
		} else {
			System.out.println("não é um palíndromo");
		}
		sc.close();

	}

}
