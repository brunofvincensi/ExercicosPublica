package vetores;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] valores = new String[100];
		char prosseguir = 'y';
		
		
		for(int i = 0; i < valores.length; i++) {
			
			System.out.println("Adicione um nome");
			String nome = sc.next();
			valores[i] = nome;	
			System.out.println("prosseguir e cadastra novamente? y(yes) n(no)");
			prosseguir = sc.next().charAt(0);
			
			if(prosseguir != 'y') {
				
				break;
			}
			
		}
		
		for(String n : valores) {
			
			if(n != null && n != "") {
			System.out.println(n);
			}
		}
		
		sc.close();

	}

}
