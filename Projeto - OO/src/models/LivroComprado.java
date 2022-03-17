package models;

import java.time.LocalDateTime;

public class LivroComprado {
	
	private Usuario usuario;	
	private Livro livro;
	private LocalDateTime horarioDaCompra;
	
	public LivroComprado() {
		super();
	}
	
	public LivroComprado(Usuario usuario, Livro livro) {
		super();
		this.usuario = usuario;
		this.livro = livro;
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

	@Override
	public String toString() {
		return "LivroComprado [usuario=" + usuario + ", livro=" + livro + ", horarioDaCompra=" + horarioDaCompra
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
