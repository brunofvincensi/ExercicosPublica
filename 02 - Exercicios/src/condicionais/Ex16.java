package condicionais;

import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Valor recebido por hora: ");
		double valorHora = sc.nextDouble();

		System.out.println("Quantidade de horas trabalhadas: ");
		double horasTrabalhadas = sc.nextDouble();

		System.out.println("Horas extras 50%");
		double horasExtras50 = sc.nextDouble();

		System.out.println("Horas extras 100%");
		double horasExtras100 = sc.nextDouble();

		double salario = (valorHora * horasTrabalhadas) + (valorHora * horasExtras50 * 1.5)
				+ (valorHora * horasExtras100 * 2);

		System.out.println("Salário: " + salario);

		sc.close();
	}

}
