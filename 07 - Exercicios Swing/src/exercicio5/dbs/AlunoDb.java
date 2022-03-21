package exercicio5.dbs;

import java.util.ArrayList;
import java.util.List;
import exercicio5.models.Aluno;

public class AlunoDb {
	static int id = 0;
	private static List<Aluno> alunos = new ArrayList<>();
	
	static {
		
		save(new Aluno(null, "Bruno", 17, "Masculino"));
		save(new Aluno(null, "Pedro", 16, "Masculino"));
		save(new Aluno(null, "Julia", 17, "Feminino"));
		save(new Aluno(null, "Carol", 16, "Feminino"));
		save(new Aluno(null, "Carlos", 15, "Masculino"));
	}
	

	
	public static void save(Aluno aluno) {

		aluno.setId(id);
		alunos.add(aluno);
		id++;
	}
	
	public static Aluno findById(int id){
		
		return alunos
				.stream()
				.filter(a -> a.getId() == id)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Aluno não existe"));
	}
	
	
	public static void alterar(int id, Aluno aluno) {
		
		int index = findIndexById(id);
		
		alunos.set(index, aluno);
	}
	
	private static int findIndexById(int id){
		
		int index = -1;
		
		for(int i = 0; i < alunos.size(); i++) {
			
			if(id == alunos.get(i).getId()) {
				
				index = i;
				break;
			}
		}
		return index;
	}
	
	

}
