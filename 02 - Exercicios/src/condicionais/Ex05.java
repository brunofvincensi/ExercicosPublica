package condicionais;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira as 4 notas");
		double nota1 = sc.nextDouble();
		double nota2 = sc.nextDouble();
		double nota3 = sc.nextDouble();
		double nota4 = sc.nextDouble();

		double media = (nota1 + nota2 + nota3 + nota4) / 4;

		System.out.print("Sua média é " + media);

		if (media >= 7) {
			System.out.println(" e voce esta aprovado");
		} else if (media <= 4.9) {
			System.out.println(" e voce esta reprovado");
		} else {
			System.out.println(" e voce esta em exame");
		}

		sc.close();
	}

}
