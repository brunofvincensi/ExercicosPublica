package vetores;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[][] usuarios = new String[10][2];
		
		char continuar = 'y';
				
		for(int i = 0; i < usuarios.length; i++) {		
				
				System.out.println("Adicione o nome");
				String nome = sc.next();
				
				System.out.println("Adicione a idade");
				String idade = sc.next();
				
				usuarios[i][0] = nome;
				usuarios[i][1] = idade;
				
				System.out.println("Continuar? y(yes) n(no)");
				continuar = sc.next().charAt(0);
				
				if(continuar != 'y') {
					break;
				}
				
		}
		
		for(int i = 0; i < usuarios.length; i++) {
						
			System.out.println("nome: " + usuarios[i][0] + " idade: " + usuarios[i][1]);			
	}
			
		sc.close();
	}

}
