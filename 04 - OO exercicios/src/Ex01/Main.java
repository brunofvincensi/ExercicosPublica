package Ex01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Contatos> contatos = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		boolean sair = false;
		
		while(!sair) {
		
		System.out.println("Cadastrar (1)");
		System.out.println("Pesquisar (2)");
		System.out.println("Alterar (3)");
		System.out.println("Remover (4)");
		System.out.println("Aniversariante do mes (5)");
		System.out.println("Sair (6)");
		char numSelected = sc.next().charAt(0);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		switch (numSelected) {
		case '1' -> {
			
			Contatos c = new Contatos();
			
			System.out.println("Insira o nome");
			c.setNome(sc.next());
			
			System.out.println("Insira o email");
			c.setEmail(sc.next());
			
			System.out.println("Insira o telefone");
			c.setTelefone(sc.next());
			
			System.out.println("Insira o nascimento, exemplo(23/06/1999)");
			String inputNascimento = sc.next();
			
			LocalDate ld = LocalDate.parse(inputNascimento, formatter);
			
	
			
			c.setNascimento(ld);
			
			System.out.println("Insira o estado");
			c.setEstado(sc.next());
			
			System.out.println("Insira a cidade");
			c.setCidade(sc.next());
			
			contatos.add(c);
		}
		case '3' -> {
			System.out.println("Digite o nome do contato");
			String nome = sc.next();
			
			contatos.forEach(c -> {
				
				if(c.getNome().equals(nome)) {
				
					
					System.out.println("Insira o novo nome");
					c.setNome(sc.next());
					
					System.out.println("Insira o novo email");
					c.setEmail(sc.next());
					
					System.out.println("Insira o novo telefone");
					c.setTelefone(sc.next());
					
					System.out.println("Insira o novo nascimento, exemplo(23/06/1999)");
					String inputNascimento = sc.next();
					
					LocalDate ld = LocalDate.parse(inputNascimento, formatter);
								
					c.setNascimento(ld);
					
					System.out.println("Insira o novo estado");
					c.setEstado(sc.next());
					
					System.out.println("Insira a nova cidade");
					c.setCidade(sc.next());					
					
				}
			});
		}
		case '2' -> {
			System.out.println("Digite o nome do contato");
			String nome = sc.next();
			
			contatos.forEach(c -> {
				
				if(c.getNome().equals(nome)) {
					System.out.println(c.toString());
				}
			});
			
		}
		case '4' -> {
			System.out.println("Digite o nome do contato");
			String nome = sc.next();
			
			contatos.forEach(c -> {
				
				if(c.getNome().equals(nome)) {
					contatos.remove(c);
				}
			});
			
		}
		case '5' -> {
			
			LocalDate hoje = LocalDate.now();
			
			contatos.forEach(c -> {
				if(hoje.getMonth() == c.getNascimento().getMonth()) {
					System.out.println(c.getNome() + " irá fazer " + (hoje.getYear() - c.getNascimento().getYear()));
				}
			});
		}
		case '6' -> sair = true;
				
		default ->
		throw new IllegalArgumentException("Unexpected value: " + numSelected);
		}
		
		
	
		
		}
		sc.close();
	}

}
