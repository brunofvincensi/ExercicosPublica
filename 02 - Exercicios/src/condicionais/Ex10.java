package condicionais;

import java.util.Scanner;

public class Ex10 {
	
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		System.out.println("lado esquerdo");
		double ladoEsquerdo = sc.nextDouble();
		
		System.out.println("lado direito");
		double ladoDireito = sc.nextDouble();
		
		System.out.println("lado inferior");
		double ladoInferior = sc.nextDouble();
		
		if(ladoEsquerdo == ladoDireito && ladoEsquerdo == ladoInferior &&  
				ladoInferior == ladoDireito) {
			
			System.out.println("Equilatero");		
		}
		else if(ladoEsquerdo == ladoDireito || ladoEsquerdo == ladoInferior ||
				ladoInferior == ladoDireito) {
			
			System.out.println("Isoceles");		
		}
		else {
			System.out.println("Escaleno");		
		}
		

       sc.close();
	}

}
