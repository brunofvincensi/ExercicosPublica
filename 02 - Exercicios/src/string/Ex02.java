package string;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira um verbo terminado em AR");

		try {
			String verbo = sc.next();

			if (!verbo.toLowerCase().endsWith("ar")) {
				throw new RuntimeException("não termina com AR");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		sc.close();
	}

}
