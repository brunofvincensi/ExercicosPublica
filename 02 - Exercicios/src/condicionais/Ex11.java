package condicionais;

import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Valor total da compra");
		double valorTotal = sc.nextDouble();

		System.out.println("Forma de pagamento v(a vista) p(a prazo)");
		char pagamento = sc.next().charAt(0);

		System.out.println(pagamento == 'v' && valorTotal >= 200 ? valorTotal * 0.9 : valorTotal);

		sc.close();
	}
}
