package mensagem;

import java.util.Scanner;

public class Condicional {

	public static void main(String[] args) {
		
		//Scanner
		Scanner sc = new Scanner(System.in);
		
		// Variavel
		int idade = sc.nextInt();
		
		//Condicional
		if(idade >= 18) {
          System.out.println("Maior de idade");
	}else {
		
	      System.out.println("Menor de idade");
	}
		
	
	// Operador ternário
		
	System.out.println(idade >= 18 ? "Maior de idade" : "Menor de idade");	

	sc.close();
}}
