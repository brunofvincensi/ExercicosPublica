package Ex04;

import java.time.LocalDateTime;

public class Jogador {
	
	private String nome;
	private int quantAcertos;
	private LocalDateTime horaQueJogou;
	
	
	
	
	public Jogador(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantAcertos() {
		return quantAcertos;
	}
	public void setQuantAcertos(int quantAcertos) {
		this.quantAcertos = quantAcertos;
	}
	public LocalDateTime getHoraQueJogou() {
		return horaQueJogou;
	}
	public void setHoraQueJogou(LocalDateTime horaQueJogou) {
		this.horaQueJogou = horaQueJogou;
	}
	
	public void acertar() {
		this.quantAcertos++;
	}
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", quantAcertos=" + quantAcertos + ", horaQueJogou=" + horaQueJogou + "]";
	}
	
	

}
