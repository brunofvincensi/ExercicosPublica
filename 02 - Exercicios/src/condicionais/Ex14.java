package condicionais;

import java.util.Scanner;

public class Ex14 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe seu salário");
		double salario = sc.nextDouble();
		
		System.out.println("Luz: ");
		double luz = sc.nextDouble();
		
		System.out.println("Telefone: ");
		double telefone = sc.nextDouble();
		
		System.out.println("Água: ");
		double agua = sc.nextDouble();
		
		System.out.println("Mercado: ");
		double mercado = sc.nextDouble();
		
		System.out.println("Lazer: ");
		double lazer = sc.nextDouble();
		
		System.out.println("Aluguel: ");
		double aluguel = sc.nextDouble();
		
		
		double despesas = luz + telefone + agua + mercado + lazer + aluguel;
		double valorSobra = salario - despesas;
		
		System.out.println("Sobrou R$" + valorSobra);
	
	sc.close();	
	}

}
