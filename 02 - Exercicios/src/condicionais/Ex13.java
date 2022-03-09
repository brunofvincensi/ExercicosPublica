package condicionais;

import java.util.Scanner;

public class Ex13 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double tempAtual = sc.nextDouble();
		
		System.out.println(" Celsius para Fahrenheit(1) Fahrenheit para Celsius(2)");
		
		char convercao = sc.next().charAt(0);
		
		if(convercao == '1') {
			
			System.out.println((tempAtual * 9/5) + 32);
		  	
		}
		else if(convercao == '2'){
			
			System.out.println((tempAtual - 32) * 5/9);
		}
		
	
        sc.close();
	}

}
