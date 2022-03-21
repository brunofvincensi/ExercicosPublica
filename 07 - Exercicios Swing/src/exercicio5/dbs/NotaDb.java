package exercicio5.dbs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import exercicio4.ProdutoDb;
import exercicio5.models.Nota;

public class NotaDb {
		
	private static List<Nota> notas = new ArrayList<>();
	
	public static void save(Nota nota) {
		notas.add(nota);
	}
	
	public static DefaultTableModel listarPorIdAluno(int id) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("prova");
		dtm.addColumn("conteudo");
		dtm.addColumn("nota");
		
		for(int i = 0; i < notas.size(); i++) {
			
			if(notas.get(i).getAluno().getId() == id) {
			
			dtm.addRow(new Object[] {
										
					notas.get(i).getProva().getMateria(),
					notas.get(i).getProva().getConteudo(),
					notas.get(i).getNota()
			});
		   }
		}
		
		return dtm;
	}
	

}
