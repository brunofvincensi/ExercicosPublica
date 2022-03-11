package lacos;

import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int nAleatorio = (int) Math.floor(Math.random() * 100);

		boolean acertou = false;
		int cont = 0;

		while (!acertou) {

			System.out.println("Digite um numero: ");
			int nTentativa = sc.nextInt();

			if (nTentativa > nAleatorio) {

				System.out.println("O numero certo é menor");

			} else if (nTentativa < nAleatorio) {

				System.out.println("O numero certo é maior");
			} else {
				System.out.println("Parabens voce acertou!");
				acertou = true;
			}

			cont++;
		}

		System.out.println(cont + " tentativas");

		sc.close();

	}

}
