package lacos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] candidatos = { "Joao", "Paulo", "Cesar", "Pedro" };

		Map<String, Integer> eleicao = new HashMap<>();

		char continuar = 'y';

		while (continuar == 'y') {

			for (int i = 0; i < candidatos.length; i++) {

				System.out.println(candidatos[i] + " -> digite " + (i + 1));
			}

			System.out.println("Selecione um candidato");
			int n = sc.nextInt();

			if (!eleicao.keySet().contains(candidatos[n - 1])) {

				eleicao.put(candidatos[(n - 1)], 1);
			} else {

				eleicao.replace(candidatos[(n - 1)], (eleicao.get(candidatos[(n - 1)])) + 1);
			}

			System.out.println(eleicao);

			System.out.println("Continuar? y(yes) n(no) ");
			continuar = sc.next().charAt(0);
		}

		sc.close();
	}

}
