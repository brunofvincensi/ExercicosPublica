package lacos;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite um numero: ");
		int n = sc.nextInt();
		
		int antecessor = n - 1;
		int result = n;
				
		do {
			result *= antecessor;
			System.out.println(result);
			antecessor--;
		}
		while(antecessor > 0);
				
		sc.close();

	}

}
