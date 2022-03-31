package controller.service;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import controller.dao.ProdutoDAO;
import enums.Categoria;
import model.Produto;

public class ProdutoService {

	private static ProdutoDAO db = new ProdutoDAO();
		
	public static List<Produto> buscarTodos() throws SQLException{
		return db.findAll();
	}

	public static DefaultTableModel listToTable(List<Produto> produtos) throws SQLException {

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Código");
		dtm.addColumn("Nome");
		dtm.addColumn("Valor");
		dtm.addColumn("Categoria");
		dtm.addColumn("Estoque");
		dtm.addColumn("Marca");
		
		for (Produto produto : produtos) {
			
			
			
			dtm.addRow(new Object[] {
					produto.getCodigo(),
					produto.getNome(),
					"R$" + produto.getValor(),
					produto.getCategoria(),
					produto.getQuantidade() + " unidades",
					MarcaService.buscarPorCodigo(produto.getMarca_id()).getNome()			
			});
		}

		return dtm;
	}

	public static void removerProduto(int codigo) throws SQLException {
		db.delete(codigo);
		
	}

	public static void adicionarProduto(Produto produto) throws SQLException {
		db.save(produto);
		
	}

	public static void alterarProduto(Produto produto, Integer index) throws SQLException {
		db.update(produto, index);
		
	}

	public static Produto buscarPorCodigo(int codigo) throws SQLException {
		return db
				.findById(codigo)
				.orElseThrow(() -> new RuntimeException("Produto não encontrada"));
		
	}
	
	public static List<Produto> buscarPorFiltro(Categoria categoria, int opcaoValor) throws SQLException {
		return db.buscarPorFiltro(categoria, opcaoValor);
	}
	
	public static List<Produto> buscarPorNome(String nome) throws SQLException{
		return db.buscarPorNome(nome);
	}
}
