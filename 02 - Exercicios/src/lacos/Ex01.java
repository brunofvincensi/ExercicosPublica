package lacos;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe um numero: ");

		int n = sc.nextInt();

		for (int i = 1; i < 10; i++) {

			System.out.println(n + " x " + i + " -> " + (n * i));
		}

		sc.close();
	}

}
