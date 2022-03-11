package vetores;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] valores = new int[5];

		for (int i = 0; i < valores.length; i++) {

			System.out.println("Adicione um valor: ");
			int n = sc.nextInt();
			valores[i] = n;
		}

		for (int i = 0; i < valores.length - 1; i++) {

			for (int j = 0; j < valores.length - 1 - i; j++) {

				if (valores[j] > valores[j + 1]) {

					int cont = valores[j];
					valores[j] = valores[j + 1];
					valores[j + 1] = cont;
				}
			}
		}

		for (int i = 0; i < valores.length; i++) {

			System.out.println(valores[i]);
		}

		sc.close();

	}

}
