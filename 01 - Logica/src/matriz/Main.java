package matriz;

public class Main {

	public static void main(String[] args) {
		
		// Matriz
		String [][] dados = {
				
				{"Alice", "Blumenau"},
				{"Joao", "Curitiba"},
				{"Isabela", "São Paulo"}
		};
		
		
		for(int i = 0; i<dados.length; i++) {
			System.out.println(dados[i][0]);
		}
		
		//ForEach
		for(String[] d : dados) {
			
			for(String inf: d) {
				
				System.out.println(inf);
			}
		}
	}
}
