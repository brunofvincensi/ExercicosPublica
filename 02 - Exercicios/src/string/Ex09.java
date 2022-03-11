package string;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		
		
	    System.out.println("Insira os numeros: ");
        String numeros = sc.next();
      
        String[] numerosList = numeros.split(",");
      
        int cont = 0;
        
        for(String n : numerosList) {
        	System.out.println(n);
        	
        	cont += Integer.parseInt(n);
        }
      
        System.out.println();
        System.out.println("Soma: " + cont);
        
        sc.close();

	}

}
