package condicionais;

import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Dia de nascimento: ");
		int dia = sc.nextInt();

		System.out.println("Mes de nascimento: ");
		int mes = sc.nextInt();

		switch (mes) {

		case 1:
			System.out.println(dia <= 20 ? "Capricornio" : "Aquario");
			break;

		case 2:
			System.out.println(dia <= 20 ? "Aquario" : "Peixes");
			break;

		case 3:
			System.out.println(dia <= 20 ? "Peixes" : "Aries");
			break;

		case 4:
			System.out.println(dia <= 20 ? "Aries" : "Touro");
			break;

		case 5:
			System.out.println(dia <= 20 ? "Gemeos" : "Cancer");
			break;

		case 6:
			System.out.println(dia <= 20 ? "Cancer" : "Leao");
			break;

		case 7:
			System.out.println(dia <= 20 ? "Leao" : "Virgem");
			break;

		case 8:
			System.out.println(dia <= 20 ? "Virgem" : "Libra");
			break;

		case 9:
			System.out.println(dia <= 20 ? "Libra" : "Escorpiao");
			break;

		case 10:
			System.out.println(dia <= 20 ? "Escorpiao" : "Sagitario");
			break;

		case 11:
			System.out.println(dia <= 20 ? "Sagitario" : "Capricornio");
			break;

		case 12:
			System.out.println(dia <= 20 ? "Capricornio" : "Touro");
			break;

		}

		sc.close();
	}

}
