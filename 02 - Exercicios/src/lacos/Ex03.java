package lacos;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1º numero: ");
		int n1 = sc.nextInt();
		
		System.out.println("2º numero: ");
		int n2 = sc.nextInt();
		
		int menor = n1;
		int maior = n2;
		
		if(n1 > n2) {
			maior = n1;
			menor = n2;
		}
		
		
		while(menor <= maior) {
			
			System.out.println(menor + " ");
			menor++;
		}
		
		sc.close();
	}
}
