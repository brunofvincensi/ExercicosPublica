package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira a data completa: ");
		String dataString = sc.next();
		System.out.println();
		
		String[] dadosDataString = dataString.split("/");
		
		List<Integer> dadosDataInt = new ArrayList<>();
		
		for(String d : dadosDataString) {			
			dadosDataInt.add(Integer.parseInt(d));
		}
		
		int dia = dadosDataInt.get(0);
		int mes = dadosDataInt.get(1);
		int ano = dadosDataInt.get(2);
		
		
		if(dia != 30) {
			
			System.out.println((dia - 1) + "/" + mes + "/" + ano);
			System.out.println((dia + 1) + "/" + mes + "/" + ano);			
		}
		else {
			
			if(mes != 12) {
				
				System.out.println(1 + "/" + (mes + 1) + "/" + ano);
				System.out.println(29 + "/" + mes + "/" + ano);			
			}
			else {
				System.out.println(1 + "/" + 1 + "/" + (ano + 1));
				System.out.println(29 + "/" + mes + "/" + ano);	
			
			}
			
		}
		
		if(dia == 1) {
			
			if(mes != 1) {
				System.out.println(30 + "/" + (mes - 1) + "/" + ano);
				System.out.println(2 + "/" + mes + "/" + ano);
							
			}
			else {
				System.out.println(30 + "/" + 12 + "/" + (ano - 1));
				System.out.println(2 + "/" + mes + "/" + ano);
							
			}
		}
				
		sc.close();

	}

}
