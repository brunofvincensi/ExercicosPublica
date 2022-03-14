package Ex03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		List<Pessoa> correntistas = new ArrayList<>();

		Pessoa p1 = new Pessoa("Itau", "123", "Bruno", "bruno123", 500.0);
		Pessoa p2 = new Pessoa("Bradesco", "456", "Maria", "maria456", 340.0);
		Pessoa p3 = new Pessoa("Viacred", "789", "Joao", "joao789", 675.0);

		correntistas.addAll(Arrays.asList(p1, p2, p3));

		Scanner sc = new Scanner(System.in);
		boolean sair = false;
		boolean logado = false;

		Pessoa correntista = new Pessoa();

		while (!logado) {
			try {
				System.out.println("Login");
				System.out.println("----------------");
				System.out.println("conta: ");
				String conta = sc.next();

				System.out.println("senha: ");
				String senha = sc.next();

				correntista = correntistas.stream()
						.filter(c -> c.getContaCorrente().equals(conta) && c.getSenha().equals(senha)).findFirst()
						.orElseThrow(() -> new RuntimeException("conta ou senha invlidos"));

				System.out.println("Bem vindo! Saldo atual: " + correntista.getSaldo());
				logado = true;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		while (!sair) {

			boolean foiSaque = false;

			System.out.println("Sacar (1)");
			System.out.println("Depositar (2)");
			System.out.println("Extrato (3)");
			System.out.println("Sair do sistema (4)");
			int numberSelected = sc.nextInt();

			switch (numberSelected) {
			case 1 -> {
				System.out.println("Insira o valor que deseja sacar: ");
				double valor = sc.nextDouble();

				double saldoAtual = correntista.getSaldo();

				if (saldoAtual < valor) {
					System.out.println("Saldo insuficiente");
				} else {
					correntista.setSaldo(saldoAtual - valor);
					foiSaque = true;
				}

			}

			case 2 -> {
				System.out.println("Insira o valor que deseja depositar");
				double valor = sc.nextDouble();
				correntista.depositar(valor);

			}
			case 3 -> {
				System.out.println(LocalDateTime.now());
				System.out.println("Saldo: " + correntista.getSaldo());
				if (foiSaque) {
					System.out.println("Deposito foi saque");
				} else {
					System.out.println("Deposito não foi saque");
				}
			}
			case 4 -> sair = true;

			default -> throw new IllegalArgumentException("Unexpected value: " + numberSelected);
			}
		}

		System.out.println("Sistema finalizado");

		sc.close();

	}

}
