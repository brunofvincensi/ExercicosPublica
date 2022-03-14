package Ex04;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static boolean responder(Jogador j, Pergunta p) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira o numero da alternativa: ");
		int altSelecionada = sc.nextInt();
		
		if(p.getAltCerta().equals(Integer.toString(altSelecionada))) {
			System.out.println("Parabens voce acertou! ");
			j.acertar();
			return true;
		}
		else {
			System.out.println("Voce errou.");
			return false;
		}
		 
	}

	public static void main(String[] args) {
		
		
		
		List<Jogador> jogadores = new ArrayList<>();  

		
		Pergunta p1 = new Pergunta("Quem foi a primeira pessoa a viajar no Espaço?", 
				"Yuri Gagarin", "A cadela Laika", "Neil Armstrong", "Marcos Pontes", "1", "foi no ano 1961");
		
		Pergunta p2 = new Pergunta("Quanto é 3 + 5", 
				"4", "3", "8", "2", "3", "sem dica");
		
		Pergunta p3 = new Pergunta("Onde se localiza Machu Picchu?", 
				"Colômbia", "Peru", "China", "Bolívia", "2", "faz fronteira com o Brasil");
		
		Pergunta p4 = new Pergunta(" Que país tem o formato de uma bota?", 
				"Butão", "Brasil", "Portugal", "Itália", "4", "fica na Europa");
		
		Pergunta p5 = new Pergunta("A que temperatura a água ferve?", 
				"200 ºC", "-10 ºC", "180 ºC", "100 ºC", "4", "é conhecido como ponto de ebulição");
		
		Pergunta p6 = new Pergunta("Qual é o maior pais do mundo?", 
				"Russia", "Argentina", "Alemanha", "Canada", "1", "fica em dois continentes ao mesmo tempo");
		
		
		Jogador j1 = new Jogador("Bruno");
		Jogador j2 = new Jogador("Pedro");
		Jogador j3 = new Jogador("Maria");
		
		
		
		
		jogadores.addAll(Arrays.asList(j1, j2, j3));
		
		Scanner sc = new Scanner(System.in);
		
		
		int volta = 0;
		
		while(volta < 3) {
			
			Jogador j = jogadores.get(volta);
			
			j.setHoraQueJogou(LocalDateTime.now());
			System.out.println("------------------------------");
			System.out.println("Vez do " + j.getNome());
			System.out.println("------------------------------");
			int respondido = 0;
			int pularQuestao = 0;
			int dicas = 0;
			int eliminar = 0;
			
			List<Pergunta> perguntas = new ArrayList<>();  
			
			perguntas.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
			
			while(respondido < 4) {
				
		
				int index = -1;
				
				do {
					
					index = (int) Math.floor(Math.random() * 10);
				}
				while(index > perguntas.size() - 1);
				
				System.out.println(perguntas.get(index).getPerguta());
				
				System.out.println("a) " + perguntas.get(index).getAlt1());
				System.out.println("b) " + perguntas.get(index).getAlt2());
				System.out.println("c) " + perguntas.get(index).getAlt3());
				System.out.println("d) " + perguntas.get(index).getAlt4());
				
				Pergunta p = perguntas.get(index);
				
				perguntas.remove(index);
				
				System.out.println();
				
				String menu = "";
				
				if(pularQuestao <= 2) {
					menu += "(1) -> Pular questao \n";
				}
				if(eliminar <= 1) {
					menu += "(2) -> Eliminar uma alternativa \n";
				}
				if(dicas <= 1) {
					menu += "(3) -> Usar a dica \n";
				}
				menu += "(4) -> Prosseguir sem ajuda";
				
		
			    System.out.println(menu);
			    int opcaoSelecionada = sc.nextInt();
			    
			    switch(opcaoSelecionada) {
			    
			    case 1 -> {
			    	System.out.println("Questão pulada");
			    	System.out.println();
			    	pularQuestao++;
		
			    }
			    case 2 -> {
			    	
			    	int altSorteada = -1;
			    	
			    	do {
						
			    		altSorteada = (int) Math.floor(Math.random() * 10);
					}
					while(altSorteada > 4 || altSorteada == Integer.parseInt(p.getAltCerta()));
			    	
			    	System.out.println("A alternativa " + altSorteada + " esta errada");
			    	eliminar++;
			    	
			    	responder(j, p);
			    	respondido++;
			    	
			    }
			    case 3 -> {
			    	
			    	System.out.println("Dica: " + p.getDica());
			    	dicas++;
			    	
			    	responder(j, p);
			    	respondido++;
			    }
			    
			    case 4 -> {
			    	
			    	responder(j, p);
			    	respondido++;
			    }
			    
			    default -> throw new IllegalArgumentException("Unexpected value: " + opcaoSelecionada);
			    
			    }								
				
			}
			
			
			
			volta++;
		}
		
		jogadores.forEach(j -> System.out.println(j));
			
		sc.close();

	}

}
