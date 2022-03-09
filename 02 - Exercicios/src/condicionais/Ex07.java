package condicionais;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira um numero ");
	
		double n = sc.nextDouble();
		if(n >= 0) {
			System.out.println("é positivo");
		}
		else {
			System.out.println("é negativo");
		}
		
		sc.close();
		
	}
}
