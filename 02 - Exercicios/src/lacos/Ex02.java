package lacos;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe um numero: ");
		int n = sc.nextInt();

		String antecessores = "";

		String sucessores = "";

		for (int i = 1; i <= 10; i++) {

			sucessores += (n + i) + ", ";

		}
		for (int i = 10; i >= 1; i--) {

			antecessores += (n - i) + ", ";

		}

		System.out.println("Sucessores: " + sucessores);

		System.out.println("Antecessores: " + antecessores);

		sc.close();
	}

}
