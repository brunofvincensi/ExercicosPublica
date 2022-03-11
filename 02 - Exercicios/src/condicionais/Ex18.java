package condicionais;

import java.util.Scanner;

public class Ex18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nota 1: ");
		double nota1 = sc.nextDouble();

		System.out.println("Nota 2: ");
		double nota2 = sc.nextDouble();

		if (nota1 < 7 || nota2 < 7) {
			System.out.println("Esta reprovado");
		} else {
			System.out.println("Esta aprovado");
		}

		sc.close();
	}

}
