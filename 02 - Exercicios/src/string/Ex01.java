package string;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String frase = sc.next();

		int vogais = 0;
		int consoantes = 0;

		for (int i = 0; i < frase.length(); i++) {

			char letra = frase.charAt(i);

			if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
				vogais++;
			} else {
				consoantes++;
			}

		}

		System.out.println("Vogais: " + vogais);
		System.out.println("Consoantes: " + consoantes);

		sc.close();

	}

}
