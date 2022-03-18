package models;

import java.time.LocalDateTime;

public class LivroComprado {
	
	private Usuario usuario;	
	private Livro livro;
	private LocalDateTime horarioDaCompra;
	private int quantidade;
	
	public LivroComprado() {
		super();
	}
	
	public LivroComprado(Usuario usuario, Livro livro, int quantidade) {
		super();
		this.usuario = usuario;
		this.livro = livro;
		this.quantidade = quantidade;
		this.horarioDaCompra = LocalDateTime.now();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public LocalDateTime getHorarioDaCompra() {
		return horarioDaCompra;
	}
	public void setHorarioDaCompra(LocalDateTime horarioDaCompra) {
		this.horarioDaCompra = horarioDaCompra;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getTotalPrice() {
		return quantidade * livro.getValor();
	}

	@Override
	public String toString() {
		return "LivroComprado [usuario=" + usuario.getLogin() + ", livro=" + livro.getNome() + ", horarioDaCompra=" + horarioDaCompra
				+ ", quantidade=" + quantidade + ", valorTotal=" + getTotalPrice() + "]";
	}

}
