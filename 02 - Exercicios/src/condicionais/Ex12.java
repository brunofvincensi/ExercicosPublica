package condicionais;

import java.util.Scanner;

public class Ex12 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe os quatro lados do quadrado");
		
		double lado1 = sc.nextDouble();
		double lado2 = sc.nextDouble();
		double lado3 = sc.nextDouble();
		double lado4 = sc.nextDouble();
		
		System.out.println(lado1 == lado2 && lado1 == lado3 && lado1 == lado4 
				? "é um quadrado" : "não é um quadrado");
		
		sc.close();
	}

}
