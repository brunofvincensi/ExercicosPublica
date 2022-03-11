package condicionais;

import java.util.Scanner;

public class Ex19 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Peso: ");
		double peso = sc.nextDouble();

		System.out.println("Altura: ");
		double altura = sc.nextDouble();

		double imc = peso / (altura * altura);

		if (imc < 17.5) {
			System.out.println("Abaixo do peso");
		} else if (imc <= 24.99) {
			System.out.println("Peso normal");
		} else if (imc <= 29.99) {
			System.out.println("Acima do peso");
		} else if (imc <= 34.99) {
			System.out.println("Obesidade 1");
		} else if (imc <= 39.99) {
			System.out.println("Obesidade 2");
		} else {
			System.out.println("Obesidade 3");
		}

		sc.close();
	}

}
