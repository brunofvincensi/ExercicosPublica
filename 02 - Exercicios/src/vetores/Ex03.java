package vetores;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] valores = new int[10];
		
		boolean repete = false;
		
		for(int i = 0; i < valores.length; i++) {
			
		 System.out.println("Adicione um valor: ");
		 
		 int valor = sc.nextInt();
		 
		 for(int j = 0; j < valores.length; j++) {
			 
			 if(valores[j] == valor) {
				 repete = true;
			 }
			 
		 }
		 
		 if(!repete) {
			 
			 valores[i] = valor;
		 }
		 else {
			 i--;
			 System.out.println("numero ja existe");
		 }
		 
		 repete = false;
		}
		
		System.out.println("-------------------------");
		
          for(int v: valores) {			
			System.out.println(v);		
		}
				
		sc.close();
	}

}
