package string;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite a hora atual: (exemplo: 09:27) ");
		String horarioString = sc.next();

		String[] dadosHorarioString = horarioString.split(":");

		int hora = Integer.parseInt(dadosHorarioString[0]);
		int minuto = Integer.parseInt(dadosHorarioString[1]);

		String[][] modificadores = { { "Nova Iorque", "-2" }, { "Tóquio", "12" }, { "Londres", "3" },
				{ "Sidney", "11" }, { "Berlim", "4" } };

		for (int i = 0; i < modificadores.length; i++) {

			int modificador = Integer.parseInt(modificadores[i][1]);
			String cidade = modificadores[i][0];

			int horaAjustada = hora + modificador;

			if (horaAjustada >= 24) {
				
				horaAjustada = horaAjustada - 24;
				
			} else if (horaAjustada < 0) {
				
				horaAjustada = horaAjustada + 24;
				
			}

			System.out.println(cidade + " -> " + horaAjustada + ":" + minuto);

		}

		sc.close();

	}

}
