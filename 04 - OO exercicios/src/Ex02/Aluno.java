package Ex02;

import java.time.LocalDate;

public class Aluno {

	private String nome;
	private String turma;
	private LocalDate aniversario;
	private String telefone;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public LocalDate getAniversario() {
		return aniversario;
	}
	public void setAniversario(LocalDate aniversario) {
		this.aniversario = aniversario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", turma=" + turma + ", aniversario=" + aniversario + ", telefone=" + telefone
				+ "]";
	}
	
	
}
