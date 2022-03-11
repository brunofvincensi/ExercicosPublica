package lacos;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;
		int soma = 0;

		do {

			System.out.println("Digite um numero: ");
			n = sc.nextInt();
			soma += n;

		} while (n != 0);

		System.out.println("Soma: " + soma);

		sc.close();
	}

}
