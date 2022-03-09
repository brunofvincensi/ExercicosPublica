package vetores;

import java.util.Scanner;

public class Ex11 {
	
    public static void listAll(String[][] produtos) {
		
    	for(int i = 0; i < produtos.length; i++) {
    		
    		if(produtos[i][0] != null) {
    		System.out.print(produtos[i][0] + " ");
    		System.out.print(produtos[i][1] + " ");
    		System.out.print(produtos[i][2] + " ");
    		System.out.println();}
    	}
    	System.out.println("-------------------------------");
	}
    
    public static int alterar(String nome, String[][] produtos ) {
		
    	int indiceProduto = 51;
    	
    	for(int i = 0; i < produtos.length; i++) {
    		
    		if(produtos[i][0] != null) {
    		
    		if(produtos[i][0].equals(nome)) {
    			indiceProduto = i;
    		}}
    		
    	}
    	
    	return indiceProduto;
	}

    public static void deletar(String nome, String[][] produtos) {
          
    	for(int i = 0; i < produtos.length; i++) {
    		
    		if(produtos[i][0] != null) {
    		if(produtos[i][0].equals(nome) ) {
    			
    			produtos[i][0] = null;
    			produtos[i][1] = null;
    			produtos[i][2] = null;
    		}}
    		
    	}
}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[][] produtos = new String[50][3];
		int cont = 0;
		
		boolean aberto = true;
		
		while(aberto) {
		System.out.println("Cadastrar (1)");
		
		System.out.println("Listar todos os produtos (2)");
		
		System.out.println("Alterar produto (3)");
		
		System.out.println("Remover produto (4)");
		
		System.out.println("Finalizar sistema (5)");
		
		char opcao = sc.next().charAt(0);
		
		switch(opcao) {
		
		case '1' : {
			
			System.out.println("Adicione o nome: ");
			String nome = sc.next();
			
			System.out.println("Adicione o valor: ");
			String valor = sc.next();
			
			System.out.println("Adicione a marca: ");
			String marca = sc.next();
			
			produtos[cont][0] = nome;
			produtos[cont][1] = valor;
			produtos[cont][2] = marca;
			
			cont++;
			
		};
		break;
		case '2' : listAll(produtos);
		break;
		case '3' : {
			
			System.out.println("Nome do produto a ser alterado: ");
			String nome = sc.next();
			int indice = alterar(nome, produtos);
			System.out.println(indice);
			if(indice != 51) {
				
				System.out.println("Insira o novo nome");
				String novoNome = sc.next();
				
				System.out.println("Insira o novo valor");
				String novoValor = sc.next();
				
				System.out.println("Insira a nova marca");
				String novaMarca = sc.next();
				
				produtos[indice][0] = novoNome;
				produtos[indice][1] = novoValor;
				produtos[indice][2] = novaMarca;
					
			}
			else {
				System.out.println("Produto não encontrado");
			}
			
		}
		break;
		case '4' : {
			
			System.out.println("Nome do produto a ser deletado: ");
			String nome = sc.next();
			deletar(nome, produtos);
			
		}
		break;
		case '5' : aberto = false;
		break;
		}
		
		}
		sc.close();

	}

}
