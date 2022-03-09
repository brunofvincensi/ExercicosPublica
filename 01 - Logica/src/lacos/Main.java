package lacos;

public class Main {

	public static void main(String[] args) {
		
		
		// Contador
		int contador = 0;
		
		// Laço - While
		while(contador < 11) {
			System.out.println(contador);
			contador++;
		}
		
		System.out.println("-----------------------");
		// Laço - Do While
		
		contador = 0;
		
		do {
			System.out.println(contador);
			contador++;
			
		}while(contador < 11);
		
		//Laço - For
		for(int i = 0; i<11; i++){
			System.out.println(i);
			
		}
	}
}
