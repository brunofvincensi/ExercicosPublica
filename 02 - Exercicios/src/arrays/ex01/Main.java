package arrays.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
				
		List<Pessoa> contatos = new ArrayList<>();
		
		boolean sair = false;
		
		while(!sair) {
		
		System.out.println();
		System.out.println("Cadastrar (1)");
		System.out.println("Listar (2)");
		System.out.println("Pesquisar (3)");
		System.out.println("Alterar (4)");
		System.out.println("Remover (5)");
		System.out.println("Sair (6)");
		System.out.println();
		
		char selectedNumber = sc.next().charAt(0);
	
	try {
		switch (selectedNumber) {
		case '1' -> {
			
			System.out.println("Insira o nome: ");
			String nome = sc.next();
			
			System.out.println("Insira a idade: ");
			int idade = sc.nextInt();
			
			System.out.println("Insira o e-mail: ");
			String email = sc.next();
			
			System.out.println("Insira o telefone: ");
			String telefone = sc.next();
			
			System.out.println("Insira a cidade: ");
			String cidade = sc.next();
			
			Pessoa p = new Pessoa(nome, idade, email, telefone, cidade);
			
			contatos.add(p);
		}
		case '2' -> contatos.forEach(c -> System.out.println(c));
		
		case '3' -> {
			System.out.println("Insira o nome do contato");
			String nome = sc.next();			
			Pessoa contato = contatos
					.stream()
					.filter(c -> c.getNome().equals(nome))
					.findFirst().orElseThrow(() -> new RuntimeException("Nome não existe"));
			
			System.out.println(contato.toString());
		}
		case '4' -> {
			System.out.println("Insira o nome do contato");
			String nome = sc.next();
			Pessoa contato = contatos
					.stream()
					.filter(c -> c.getNome().equals(nome))
					.findFirst().orElseThrow(() -> new RuntimeException("Nome não existe"));
			
			System.out.println("Insira o novo nome");
			contato.setNome(sc.next());
			
			System.out.println("Insira a nova idade");
			contato.setIdade(sc.nextInt());
			
			System.out.println("Insira o novo email");
			contato.setEmail(sc.next());
			
			System.out.println("Insira o novo telefone");
			contato.setTelefone(sc.next());
			
			System.out.println("Insira a nova cidade");
			contato.setCidade(sc.next());
					
		}
		case '5' -> {
			System.out.println("Insira o nome do contato");
			String nome = sc.next();
			List<Pessoa> contatosDelete = contatos
					.stream()
					.filter(c -> c.getNome().equals(nome))
					.toList();
			
			if(contatosDelete.isEmpty()) {
				throw new RuntimeException("Nome não existe");
			}
			else if(contatosDelete.size() > 1) {
				System.out.println("Ha mais de um contato com esse nome, digite o numero de qual você deseja");
				contatos.forEach(c -> System.out.println(c));
			}
			
		}
		case '6' -> {
			sair = true;
			System.out.println("Aplicação encerrada");
		}		
		default -> throw new IllegalArgumentException("Unexpected value: " + selectedNumber);
		}
		
	}catch (Exception e) {
		System.out.print(e);
	}
		
		}
		sc.close();

	}

}
