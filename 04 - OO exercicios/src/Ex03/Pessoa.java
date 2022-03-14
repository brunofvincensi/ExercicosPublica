package Ex03;

public class Pessoa {

	private String agencia;
	private String contaCorrente;
	private String nome;
	private String senha;
	private double saldo;
	
	public Pessoa() {
		
	}
	
	
	
	
	public Pessoa(String agencia, String contaCorrente, String nome, String senha, double saldo) {
		super();
		this.agencia = agencia;
		this.contaCorrente = contaCorrente;
		this.nome = nome;
		this.senha = senha;
		this.saldo = saldo;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	
}
