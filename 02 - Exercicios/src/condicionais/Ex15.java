package condicionais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Double> numeros = new ArrayList<>();

		double n1 = sc.nextDouble();
		double n2 = sc.nextDouble();
		double n3 = sc.nextDouble();

		numeros.addAll(Arrays.asList(n1, n2, n3));
		Collections.sort(numeros);

		System.out.println(numeros);

		sc.close();
	}

}
