package exemplo02;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Instanciar objetos da classe curso
		
		Curso c1 = new Curso();
		c1.nome = "Java";
		c1.valor = 3000;
		
		Curso c2 = new Curso();
		c2.nome = "C#";
		c2.valor = 2850;
		
		Curso c3 = new Curso();
		c3.nome = "Angular";
		c3.valor = 1700;
		
		// ArrayList de cursos
		ArrayList<Curso> vetor = new ArrayList<>();
		
		vetor.add(c1);
		vetor.add(c2);
		vetor.add(c3);
		
		// Listar cursos
		vetor.forEach(v -> System.out.printf("%s%n %.2f%n", v.nome, v.valor));
		
		
		

	}

}
