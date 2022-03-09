package vetores;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] valores = new int[10];
		
		for(int i = 0; i < valores.length; i++) {
			
			System.out.println("Informe um valor: ");
			int valor = sc.nextInt();
			
			valores[i] = valor;
		}
		
		int cont = valores.length - 1;
		int valorArmazenado;
    
       for(int i = 0; i < valores.length / 2; i++) {
		
		   valorArmazenado = valores[i];
				
	       valores[i] = valores[cont];
	       valores[cont] = valorArmazenado;
	            
			cont--;		
		}
		
       
       for(int i = 0; i < valores.length; i++) {
    	   
		System.out.println(valores[i]);
		}
		
		sc.close();

	}

}
