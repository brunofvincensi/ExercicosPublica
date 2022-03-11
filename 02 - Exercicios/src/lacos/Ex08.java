package lacos;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final String PALAVRA = "ESTUDAR";

		char[] letras = PALAVRA.toCharArray();

		boolean acertou = false;
		int cont = 0;

		while (acertou == false && cont < 7) {

			// para conferir se a pessoa acertou a letra
			int contMistake = 0;

			System.out.println("Digite uma letra: ");
			char letra = Character.toUpperCase(sc.next().charAt(0));

			for (int i = 0; i < letras.length; i++) {

				if (letra == letras[i]) {
					letras[i] = '0';
				} else {
					contMistake++;
				}
			}

			if (contMistake == letras.length) {
				cont++;
			}

			for (int i = 0; i < letras.length; i++) {

				if (letras[i] != '0') {
					acertou = false;
					break;
				} else {
					acertou = true;
				}
			}

		}
		if (acertou) {
			System.out.println("Parabens voce acertou");
		} else {
			System.out.println("Não acertou");
		}
		sc.close();
	}

}
