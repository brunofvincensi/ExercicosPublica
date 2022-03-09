package vetores;

import java.util.Scanner;

public class Ex15 {
	
	
	public static double calculaMedia(String nota1, String nota2, String nota3) {
		double media = (Double.parseDouble(nota1) + 
				Double.parseDouble(nota2)  +  Double.parseDouble(nota3))/3.0;
		
		return media;
	} 

	public static void listAll(String[][] alunos){
		
		for(String[] aluno : alunos) {
			
			if(aluno[0] != null) {
			System.out.print("Nome: " + aluno[0]);
			System.out.print(" Genero: " + aluno[1]);
			System.out.print(" Nota1: " + aluno[2]);
			System.out.print(" Nota2: " + aluno[3]);
			System.out.print(" Nota3: " + aluno[4]);
			
			double media = calculaMedia(aluno[2], aluno[3], aluno[4]);
			
			System.out.printf(" Média: %.2f ", media);			
			System.out.println(media >= 7 ? "Aprovado!" : "Reprovado");
			}
		}
		
		System.out.println("--------------------------------");
	}
	
	public static int update(String[][] alunos, String nome) {

        int indiceAluno = -1;
    	
    	for(int i = 0; i < alunos.length; i++) {
    		
    		if(alunos[i][0] != null) {
    		
    		 if(alunos[i][0].equals(nome)) {
    			indiceAluno = i;
    		}
    	}  		
    }
    	
    	return indiceAluno;    	   
}
	
	
	public static int delete(String[][] alunos, String nome) {
		
		int indiceAluno = -1;
		
		for(int i = 0; i < alunos.length; i++) {
			
			if(alunos[i][0] != null) {
	    		
	    		 if(alunos[i][0].equals(nome)) {
	    			
	    			 indiceAluno = i;
	    			 
	    			 alunos[i][0] = null;
	    			 alunos[i][1] = null;
	    			 alunos[i][2] = null;
	    			 alunos[i][3] = null;
	    			 alunos[i][4] = null;
	    			 	    			
	    		}
	    	}  
			
		}
		
		return indiceAluno;
	}
	
	public static void estatisticas(String[][] alunos) {
	
		int quantidadeRegistro = 0;
		int quantidadeHomens = 0;
		int quantidadeMulheres = 0;
		int quantidadeAprovados = 0;
		int quantidadeReprovados = 0;
		
		for(int i = 0; i < alunos.length; i++){
			
			
			if(alunos[i][0] != null) {
										
				quantidadeRegistro++;
				if(alunos[i][1].equals("m")) {
					quantidadeHomens++;
				}
				else {
					quantidadeMulheres++;
				}
				
				double media = calculaMedia(alunos[i][2], alunos[i][3], alunos[i][4]);
				
				System.out.println(media);
				
				if(media >= 7) {
					quantidadeAprovados++;
				}
				else {
					quantidadeReprovados++;
				}				
			}			
		}
		
		System.out.println("Quantidade de registros: " + quantidadeRegistro);
		System.out.println("Quantidade de homens: " + quantidadeHomens);
		System.out.println("Quantidade de mulheres: " + quantidadeMulheres);
		System.out.println("Quantidade de aprovados: " + quantidadeAprovados);
		System.out.println("Quantidade de reprovados: " + quantidadeReprovados);
		System.out.println("--------------------------------");
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[][] alunos = new String[30][5];
		
		int cont = 0;
		
		boolean continuar = true;
		
		while(continuar) {
						
			System.out.println("Cadastrar aluno (1)");
			
			System.out.println("Listar todos os alunos (2)");
			
			System.out.println("Alterar aluno (3)");
			
			System.out.println("Remover aluno (4)");
			
			System.out.println("Estatisticas (5)");
			
			System.out.println("Finalizar sistema (6)");
			
			char opcao = sc.next().charAt(0);
			
			switch(opcao) {
			case '1' : {
				
				System.out.println("Cadastrar nome: ");
				String nome = sc.next();
				
				System.out.println("Cadastrar genero (f)feminino (m)masculino: ");
				char genero = sc.next().charAt(0);
				
				System.out.println("Cadastrar nota1: ");
				double nota1 = sc.nextDouble();
				
				System.out.println("Cadastrar nota2: ");
				double nota2 = sc.nextDouble();
				
				System.out.println("Cadastrar nota3: ");
				double nota3 = sc.nextDouble();
				
				alunos[cont][0] = nome;
				alunos[cont][1] = Character.toString(genero) ;
				alunos[cont][2] = Double.toString(nota1);
				alunos[cont][3] = Double.toString(nota2);
				alunos[cont][4] = Double.toString(nota3);
				
				cont++;
			}
			break;
			
			case '2' : listAll(alunos);
			break;
			
			case '3' : {
				System.out.println("Insira o nome do estudante");
				String nome = sc.next();
				int indice = update(alunos, nome );
				
				if(indice == -1) {
					System.out.println("Aluno não encontrado");
				}
				else {
				
	            System.out.println("Insira o novo nome: ");	
	            String novoNome = sc.next();
				
				System.out.println("Insira o novo genero: ");
				char novoGenero = sc.next().charAt(0);
				
				System.out.println("Insira a nova nota1: ");
				double nota1 = sc.nextDouble();
				
				System.out.println("Insira a nova nota2: ");
				double nota2 = sc.nextDouble();
				
				System.out.println("Insira a nova nota3: ");
				double nota3 = sc.nextDouble();
				
				alunos[indice][0] = novoNome;
				alunos[indice][1] = Character.toString(novoGenero);
				alunos[indice][2] = Double.toString(nota1);
				alunos[indice][3] = Double.toString(nota2);
				alunos[indice][4] = Double.toString(nota3);
								
				}
			}			
			break;
			
			case '4' : {
				
				System.out.println("Insira o nome do estudante");
				String nome = sc.next();
				if(delete(alunos, nome) != -1) {
					System.out.println("Aluno excluido");
				}
				else {
					System.out.println("Aluno não encontrado");
				}
			}
			break;
			
			case '5' : estatisticas(alunos);
			break;
			
			case '6' : {
				System.out.println("Aplição encerrada");
				continuar = false;
				}
			break;
			
			default : {
				System.out.println("numero invalido");
			}
						
			}
			
		}		
		sc.close();

	}

}
