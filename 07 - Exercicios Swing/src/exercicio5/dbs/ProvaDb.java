package exercicio5.dbs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import exercicio4.ProdutoDb;
import exercicio5.models.Prova;

public class ProvaDb {	
	private static List<Prova> provas = new ArrayList<>();
	
	public static void save(Prova prova) {
		provas.add(prova);
	}
	
	

}
