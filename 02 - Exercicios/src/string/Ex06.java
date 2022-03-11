package string;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira o email");

		String email = sc.nextLine();

		boolean temEspaco = false;
		boolean temCaracterEspecial = false;
		boolean temArroba = false;
		boolean charDepois = true;
		boolean charAntes = false;

		for (int i = 0; i < email.length(); i++) {

			char letra = email.charAt(i);

			if (letra == ' ') {
				temEspaco = true;
			}
			if (letra == '@') {
				temArroba = true;

				if (i != 0) {
					charAntes = true;
				}
				if ((i == email.length() - 1) || (i == email.length() - 2)) {
					charDepois = false;
				}
			}

			if (letra == 'ç' || letra == 'é' || letra == 'ã' || letra == '!' || letra == '?' || letra == '}') {

				temCaracterEspecial = true;
			}

		}

		if (!temEspaco && !temCaracterEspecial && temArroba && charDepois && charAntes) {

			System.out.println("CERTO");
		} else {
			System.out.println("Errado");
		}

		sc.close();

	}

}
