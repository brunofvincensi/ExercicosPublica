package lacos;

import java.util.Scanner;

public class Ex07 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe um valor: ");
		double valor = sc.nextDouble();
		
		System.out.println("Informe uma taxa de juros: ");
		double taxa = sc.nextDouble();
		
		System.out.println("Informe o tempo: ");
		int tempo = sc.nextInt();
		
		double total = valor;
		
		
		for(int i = 1; i <= tempo; i++) {
			
			double ganhoMensal = total * (taxa/100);
			
			System.out.printf("mes %d, ganho mensal : %.2f %n", i, ganhoMensal);
			
		//	System.out.println("mes " + i + " ganho mensal = " + ganhoMensal );
			
			total += ganhoMensal;				
		}
		
		System.out.println("----------------------------");
		System.out.println( "Total: " + total);
		
		
		sc.close();
	}
	
	
	
	
	
	


}
