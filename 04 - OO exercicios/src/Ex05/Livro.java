package Ex05;

public class Livro {

	private String nome;
	private int numPaginas;
	private double preco;

	public Livro() {
		super();
	}

	public Livro(String nome, int numPaginas, double preco) {
		super();
		this.nome = nome;
		this.numPaginas = numPaginas;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", numPaginas=" + numPaginas + ", preco=" + preco + "]";
	}

}
