package condicionais;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe um ano");
		int ano = sc.nextInt();

		if (ano % 4 == 0) {
			System.out.println("É um ano bissexto");
		}

		sc.close();
	}
}
