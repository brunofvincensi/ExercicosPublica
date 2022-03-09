package condicionais;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira o valor");
		double valor = sc.nextDouble();
		
	   System.out.println("Qual conversor? 1(Real para Dólar) 2(Dólar para Real)"
					+ " 3(Real para Euro) 4(Euro para Real)");
			
		int tipoConversor = sc.nextInt();
			
		switch (tipoConversor) {
		case 1 : System.out.println(valor / 5);
		break;
		case 2 : System.out.println(valor * 5 );
		break;
		case 3 : System.out.println(valor / 6);
		break;
		case 4 : System.out.println(valor * 6);
		break;
		}
		
		
		sc.close();
	}
}
