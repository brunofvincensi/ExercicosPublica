package lacos;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char outraPessoa = ' ';
		String nomeMaisVelha = "";
		int idadeMaisVelha = 0;

		do {

			System.out.println("Nome: ");
			String nome = sc.next();

			System.out.println("Idade: ");
			int idade = sc.nextInt();

			if (idade > idadeMaisVelha) {
				idadeMaisVelha = idade;
				nomeMaisVelha = nome;
			}

			System.out.println("Deseja informar outra pessoa? y(yes) n(no)");
			outraPessoa = sc.next().charAt(0);

		} while (outraPessoa == 'y');

		System.out.println(nomeMaisVelha + " " + idadeMaisVelha);
		sc.close();
	}

}
