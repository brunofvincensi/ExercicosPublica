package condicionais;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	

		int hora = sc.nextInt();
		
		String cidadeInput = sc.next();
		
		switch (cidadeInput) {
		case "Acre" : System.out.println("A hora é " + (hora - 3));
		break;
		case "Cidade do Mexico" : System.out.println("A hora é " + (hora - 2));
		break;
		case "Nova York" : System.out.println("A hora é " + (hora - 1));
		break;
		
		default:
			throw new IllegalArgumentException("Cidade invalida");
		}
		
		sc.close();
	}

}
