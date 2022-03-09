package vetores;

import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[][] quiz = {
			
			{"Quanto é 6 x 5? ", "56", "23", "30", "36", "3"},
			{"Qual é a capital do Brasil? ", "Santa Catarina", "Brasilia", "Sao Paulo", "Rio de Janeiro", "2"},
			{"De quem é a famosa frase “Penso, logo existo”?", "Platão", "Galileu Galilei", "Descartes", "Sócrates", "4"},
			{"Qual o livro mais vendido no mundo a seguir à Bíblia? ", "O Senhor dos Anéis", "Dom Quixote", "O Pequeno Príncipe", "Ela, a Feiticeira", "2"},
			{"Quantas casas decimais tem o número pi? ", "Duas", "Centenas", "Infinitas", "Milhares", "3"},
			{"O que a palavra legend significa em português? ", "Legenda", "Conto", "História", "Lenda", "4"},
			{"Quem pintou Guernica? ", "Paul Cézanne", "Pablo Picasso", "Diego Rivera", "Tarsila do Amaral", "2"},
			{"Qual a nacionalidade de Che Guevara? ", "Argentina", "Boliviana", "Panamenha", "Peruana", "1"},
		};
				
		String[][] usuarios = new String[20][2];
		
		char jogarNovamente = 'y';
		int indice;
		int cont = 0;
		
		while(jogarNovamente == 'y') {
						
			System.out.println("Insira seu nome: ");
			String nome = sc.next();
			
			String[][] quizSelecionado = new String[4][6];
			int acertos = 0;
			
			for(int i = 0; i < quizSelecionado.length; i++) {
				
				do {
					 indice = (int) Math.floor(Math.random() * 10);
					}while(indice >= 8);
				
				
				boolean existe = false;
				
				for(int j = 0; j < i; j++) {
					
				if(quiz[indice][0].equals(quizSelecionado[j][0])) {
					existe = true;
					i--;
					break;		
				  }
				}
				if(!existe) {
					quizSelecionado[i] = quiz[indice];
				}
				
			}
						
			for(String[] pergunta : quizSelecionado) {
				System.out.println(pergunta[0]);
				System.out.println();
				System.out.println("1) " + pergunta[1]);
				System.out.println("2) " + pergunta[2]);
				System.out.println("3) " + pergunta[3]);
				System.out.println("4) " + pergunta[4]);
				
				String resposta = sc.next();
				
				if(resposta.equals(pergunta[5])) {
					acertos++;
				}
				
			}
			
			usuarios[cont][0] = nome;
			usuarios[cont][1] = Integer.toString(acertos);
		
			cont++;
			System.out.println("Jogar novamente? y(yes) n(no)");
			jogarNovamente = sc.next().charAt(0);
			
		}
		
		for(String[] usuario : usuarios) {
			
			if(usuario[0] != null) {
			
			System.out.println();
			System.out.print("Nome: " + usuario[0]);
			System.out.print("  Acertos: " + usuario[1]);
			}
		}
					
		sc.close();
	}

}
