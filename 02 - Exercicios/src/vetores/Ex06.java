package vetores;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		char[][] tabuleiro = new char[3][3];
		
		char[] simbolos = {'x', 'o'};
		char simbolo;		
		int playerTime = 1;
			
		 for(int m = 0; m < tabuleiro.length; m++) {
				
				for(int j = 0; j < tabuleiro[0].length; j++) {
					tabuleiro[m][j] = '/';
				}
			}
		 
		
		for(int i = 0; i < 9; i++ ) {
			
			if(playerTime == 1) {
				
			 simbolo = simbolos[0];
			 
			}else {
				
		     simbolo = simbolos[1];}
			
			 System.out.println( "jogador " + playerTime + " posicao da linha: ");
			 int linha = sc.nextInt();
			 
			 System.out.println("jogador " + playerTime + "posicao da coluna: ");
			 int coluna = sc.nextInt();	
			
			 if(tabuleiro[linha][coluna] == '/') { 
			 
			 tabuleiro[linha][coluna] = simbolo;
			 }
			 else {
				 
				 throw new RuntimeException("essa posicao ja foi preenchida");
			 }
			 
			 for(int m = 0; m < tabuleiro.length; m++) {
					
					for(int j = 0; j < tabuleiro[0].length; j++) {
						System.out.print(tabuleiro[m][j] + " ");
					}
					System.out.println();
				}
			 
			playerTime = 2;
			
		}
			
		sc.close();

	}

}
