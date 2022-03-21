package exercicio4;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
public class ProdutoDb {

	private static List<Produto> produtos = new ArrayList<>();
	
	static {
		produtos.add(new Produto("S21", "Sansung", "celular", 1700));
		produtos.add(new Produto("Geladeira", "Sansung", "eletrodomestico", 750));
		produtos.add(new Produto("Nitro 5", "Acer", "computador", 5999.99));
		
	}
	
	public static void save(Produto produto) {
		produtos.add(produto);
	}
	
	public static DefaultTableModel listar() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Produto");
		dtm.addColumn("Marca");
		dtm.addColumn("Segmento");
		dtm.addColumn("Valor");
		
		for(int i = 0; i < ProdutoDb.produtos.size(); i++) {
			dtm.addRow(new Object[] {
					ProdutoDb.produtos.get(i).getNome(),
					ProdutoDb.produtos.get(i).getMarca(),
					ProdutoDb.produtos.get(i).getSegmento(),
					ProdutoDb.produtos.get(i).getValor()
			});
		}
		
		return dtm;
	}
	
	public static void deletar(int index) {
		produtos.remove(index);
	}
	
	public static void alterar(int index, Produto produto) {
		produtos.set(index, produto);
	}
}
