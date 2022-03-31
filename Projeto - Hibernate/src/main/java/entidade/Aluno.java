package entidade;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import enums.Genero;
import enums.Situacao;
import enums.Turno;

import javax.persistence.Entity;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
    private Double nota1;
    private Double nota2;
    private Turno turno;
    private Genero genero;
    
	public Aluno() {

	}
	
	public Aluno(Integer codigo, String nome, Double nota1, Double nota2, Turno turno, Genero genero) {
		this.codigo = codigo;
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.turno = turno;
		this.genero = genero;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Double getMedia() {
		return (nota1 + nota2) / 2;
	}
	
	public Situacao getSituacao() {		
		return getMedia() >= 7 ? Situacao.APROVADO : Situacao.REPROVADO;
	}


}
