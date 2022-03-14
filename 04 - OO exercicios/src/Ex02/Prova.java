package Ex02;

public class Prova {

	private String nome;
	private String materia;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	@Override
	public String toString() {
		return "Prova [nome=" + nome + ", materia=" + materia + "]";
	}
	
	
}
