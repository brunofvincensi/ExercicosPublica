package vator;

public class Main {

	public static void main(String[] args) {
		
		// Vetor
		String[] x = {"Vermelho", "Azul", "Amarelo"};

		// Listar cores
		for(int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
		
		for (String nome : x) {
			System.out.println(nome);
		}
	}

}
