package controller.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import controller.dao.MarcaDAO;
import controller.dao.ProdutoDAO;
import model.Marca;
import model.Produto;

public class ProdutoService {

	private static ProdutoDAO db = new ProdutoDAO();

	public static DefaultTableModel buscarProdutos() throws SQLException {

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Nome");
		dtm.addColumn("Valor");
		dtm.addColumn("Categoria");
		dtm.addColumn("Quantidade");
		dtm.addColumn("Marca");

		List<Produto> produtos = db.findAll();


		for (Produto produto : produtos) {
			dtm.addRow(new Object[] {
					produto.getNome(),
					produto.getValor(),
					produto.getCategoria(),
					produto.getQuantidade(),
					MarcaService.findById(produto.getMarca_id())
					
			
			});
		}

		return dtm;
	}
}
