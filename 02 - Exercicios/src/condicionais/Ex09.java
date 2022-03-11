package condicionais;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe a velocidade do veiculo");
		double velocidade = sc.nextDouble();

		System.out.println("Informe a velocidade maxima permitida do veiculo");
		double velocidadeMaxima = sc.nextDouble();

		if (velocidade <= velocidadeMaxima) {
			System.out.println("Bom motorista");
		} else if ((velocidade - 10) <= velocidadeMaxima) {
			System.out.println("Multa de R$50,00");
		} else if ((velocidade - 20) <= velocidadeMaxima) {
			System.out.println("Multa de R$100,00");
		} else {
			System.out.println("Multa de R$200,00");
		}

		sc.close();
	}
}
