package exercicio5.models;

import java.time.LocalDate;

public class Prova {
	
	private String materia;
	private LocalDate diaAplicacao;
	private String conteudo;
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public LocalDate getDiaAplicacao() {
		return diaAplicacao;
	}
	public void setDiaAplicacao(LocalDate diaAplicacao) {
		this.diaAplicacao = diaAplicacao;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	

}
