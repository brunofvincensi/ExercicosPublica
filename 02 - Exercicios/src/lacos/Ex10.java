package lacos;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int totalCont = 0;
		int paresCont = 0;
		int imparesCont = 0;
		int positivosCont = 0;
		int negativosCont = 0;

		System.out.println("Digite um numero: ");
		int n = sc.nextInt();

		while (n != 0) {

			if (n % 2 == 0) {
				paresCont++;
			} else {
				imparesCont++;
			}

			if (n >= 0) {
				positivosCont++;
			} else {
				negativosCont++;
			}

			System.out.println("Digite um numero: ");
			n = sc.nextInt();

			totalCont++;

		}
		;

		System.out.println("total: " + (totalCont));
		System.out.println("pares: " + paresCont);
		System.out.println("impares: " + imparesCont);
		System.out.println("positivos: " + positivosCont);
		System.out.println("negativos: " + negativosCont);

		sc.close();
	}

}
