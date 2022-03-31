package controller.service;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import controller.dao.MarcaDAO;
import model.Marca;

public class MarcaService {

	private static MarcaDAO db = new MarcaDAO();
	
	public static DefaultTableModel getTabela() throws SQLException {
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Codigo");
		dtm.addColumn("Nome");
		
		List<Marca> marcas = db.findAll();
		
		System.out.println("ddd" + marcas.size());
		
		for(Marca marca : marcas) {
			dtm.addRow(new Object[] {
					marca.getCodigo(),
					marca.getNome()
			});
		}
		
		return dtm;
	}
	
	public static List<Marca> buscarMarcas() throws SQLException{
		return db.findAll();
	}
	
	public static Marca buscarPorCodigo(Integer codigo) throws RuntimeException, SQLException {
		return db
				.findById(codigo)
				.orElseThrow(() -> new RuntimeException("Marca não encontrada"));
	}

	public static void removerMarca(int codigo) throws SQLException {
		db.delete(codigo);
		
	}

	public static void alterarMarca(int index, String novoNome) throws SQLException {
		
		Marca marca = new Marca(novoNome);
		
		db.update(marca, index);
		
	}

	public static void adicionarMarca(String nome) throws SQLException {
		Marca marca = new Marca(nome);
		db.save(marca);
		
	}
	
}
