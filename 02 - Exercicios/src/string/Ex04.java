package string;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira uma palavra ou frase");
		
		String palavra = sc.nextLine();
		
		int numeros = 0;
		int espacos = 0;
		int maiusculas = 0;
		int minusculos = 0;
		
		for(int i = 0; i < palavra.length(); i++) {
			
			char letra = palavra.charAt(i);
			
			if(letra == ' ') {
				
				espacos++;
			}
			else if(Character.isLowerCase(letra)) {
				minusculos++;
			}
			else if(Character.isUpperCase(letra)) {
				maiusculas++;
			}
			else if(Character.isDigit(letra)) {
				numeros++;
			}
			
		}
		System.out.println("Numeros: " + numeros);
		System.out.println("Espacos: " + espacos);
		System.out.println("Maiusculos: " + maiusculas);
		System.out.println("Minusculos: " + minusculos);
		
		sc.close();
	}
	
	
}
