package vetores;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] tabuleiro = new int[5][5];
		
		int[] diagonalPricipal = new int[5];
		int[] diagonalSecundaria = new int[5];
		
		 for(int i = 0; i < tabuleiro.length; i++) {
				
				for(int j = 0; j < tabuleiro[0].length; j++) {
				tabuleiro[i][j] = (int) (Math.random() * 10);
				
				if(i == j) {
					diagonalPricipal[i] = tabuleiro[i][j];
				}
				
				if((i == 0 && j == 4) || (i == 1 && j == 3) || (i == 2 && j == 2) || (i == 3 && j == 1) || (i == 4 && j == 0)) {
					
					diagonalSecundaria[i] = tabuleiro[i][j];
				}
				
			}	
		}
		 	 
		 int cont = 0;
		 
		 for(int m = 0; m < tabuleiro.length; m++) {
				
				for(int j = 0; j < tabuleiro[0].length; j++) {
					System.out.print(tabuleiro[m][j] + " ");
					
					cont += tabuleiro[m][j];
				}
				System.out.println();
			}
		
		System.out.println("Soma dos valores: " + cont);
		System.out.println();
		
		int media = cont/25;
		
		System.out.println("Media dos valores: " + media);
		System.out.println();
		
		System.out.println("Diagonal Principal: ");
		for(int d : diagonalPricipal) {
			System.out.print(d +  " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Diagonal Secundaria: ");
		for(int d : diagonalSecundaria) {
			System.out.print(d +  " ");
		}
		
		System.out.println();
		System.out.println();
		
        int naMedia = 0;
		 
		 for(int m = 0; m < tabuleiro.length; m++) {
				
				for(int j = 0; j < tabuleiro[0].length; j++) {
					
					if(tabuleiro[m][j] >= media){
						naMedia++;
					}
					
				}
				
			}
		 System.out.println("numeros na media: " + naMedia);
		
		
		sc.close();

	}

}
