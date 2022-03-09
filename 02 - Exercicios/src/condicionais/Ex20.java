package condicionais;

import java.util.Scanner;

public class Ex20 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Valor: ");
		double valor = sc.nextDouble();
		
		System.out.println("Tipo de convercao: milhas para quilometros(1) ou quilometros para milhas(2)");
		char tipo = sc.next().charAt(0);
		
	    System.out.println(tipo == '1' ? (valor * 1.609) : (valor / 1.609));
		
		sc.close();
	}

}
