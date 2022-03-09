package vetores;

import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		String[][] produtos = new String[3][2];
		
		int cont = 0;
		
		for(int i = 0; i<produtos.length; i++) {
			System.out.println("Insira o nome");
			String nome = sc.next();
			
			System.out.println("Insira a idade");
			int idade = sc.nextInt();
			
			produtos[i][0] = nome;
			produtos[i][1] = Integer.toString(idade);
			
			cont += idade;
		}
				
		String[] maisVelho = new String[2];
		
		String[] maisNovo = new String[2];
		
		maisVelho[1] = "0";
		maisNovo[1] = "200";
		
		for(int i = 0; i<produtos.length; i++) {
			
			if(Integer.parseInt(produtos[i][1]) > Integer.parseInt(maisVelho[1]) ) {
				
				maisVelho[0] = produtos[i][0];
				maisVelho[1] = produtos[i][1];
			}
			
			if(Integer.parseInt(produtos[i][1]) < Integer.parseInt(maisNovo[1])) {
				maisNovo[0] = produtos[i][0];
				maisNovo[1] = produtos[i][1];
				
			}			
		}
	
		double media = cont/produtos.length;
			
		System.out.println("Nome do mais velho: " + maisVelho[0]);
		System.out.println("Idade do mais velho: " + maisVelho[1]);
		System.out.println("");
		System.out.println("Nome do mais novo: " + maisNovo[0]);
		System.out.println("Idade do mais novo: " + maisNovo[1]);
		System.out.println("");
		System.out.println("Media: " + media);
		
		sc.close();
	}

}
