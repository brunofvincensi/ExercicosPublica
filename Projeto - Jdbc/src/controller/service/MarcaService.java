package controller.service;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import controller.dao.MarcaDAO;
import model.Marca;

public class MarcaService {

	private static MarcaDAO db = new MarcaDAO();
	
	public static DefaultTableModel buscarMarcas() throws SQLException {
		
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
	
	public static Marca findById(Integer id) throws RuntimeException, SQLException {
		return db
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Marca não encontrada"));
	}
	
}
