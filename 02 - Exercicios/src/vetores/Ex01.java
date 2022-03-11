package vetores;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int NUMERO_LISTA = 10;

		int[] list1 = new int[NUMERO_LISTA];
		int[] list2 = new int[NUMERO_LISTA];
		int[] resultList = new int[NUMERO_LISTA];
		char tipoCalculo;

		System.out.println("Digite 10 numeros");

		for (int i = 0; i < NUMERO_LISTA; i++) {

			int n = sc.nextInt();
			list1[i] = n;
		}

		System.out.println("Digite mais 10 numeros");

		for (int i = 0; i < NUMERO_LISTA; i++) {

			int n = sc.nextInt();
			list2[i] = n;
		}

		System.out.println("Informe o tipo de calculo");
		System.out.println("Soma(1) /n Subtracao(2) /n Multiplicacao(3) /n Divisao(4) /n ");

		tipoCalculo = sc.next().charAt(0);

		for (int i = 0; i < NUMERO_LISTA; i++) {

			if (tipoCalculo == '1') {

				resultList[i] = list1[i] + list2[i];
			}

			switch (tipoCalculo) {
			case '1':
				resultList[i] = list1[i] + list2[i];
				break;
			case '2':
				resultList[i] = list1[i] - list2[i];
				break;
			case '3':
				resultList[i] = list1[i] * list2[i];
				break;
			case '4':
				resultList[i] = list1[i] / list2[i];
				break;

			default:
				throw new RuntimeException("numero não permitido");
			}
		}

		for (int i = 0; i < NUMERO_LISTA; i++) {

			System.out.println(resultList[i]);
		}

		sc.close();

	}

}
