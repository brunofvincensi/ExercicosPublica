package model;

import enums.Categoria;

public class Produto {

	private int codigo;
	private String nome;
	private double valor;
	private Categoria categoria;
	private int quantidade;
	private int marca_id;
	
	public Produto() {
		
	}

	public Produto(String nome, double valor, Categoria categoria, int quantidade, int marca_id) {

		this.nome = nome;
		this.valor = valor;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.marca_id = marca_id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getMarca_id() {
		return marca_id;
	}

	public void setMarca_id(int marca_id) {
		this.marca_id = marca_id;
	}
	
	public void aumentarQuantidade(int n) {
		quantidade += n;
	}
	
	public void diminuirQuantidade(int n) {
		quantidade -= n;
	}
	
	

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + ", categoria=" + categoria
				+ ", quantidade=" + quantidade + ", marca_id=" + marca_id + "]";
	}
	
	
	
}
