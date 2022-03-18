package auxiliares;
import javax.swing.JOptionPane;

import enums.Estado;
import models.Pessoa;

public abstract class ListarEstados {
	
	/**
	 * gera a lista para selecionar um estado
	 * @return o estado selecionado
	 */
	public static Estado listarEstados() {

		String lista = "";

		Estado[] estados = Estado.values();

		for (int i = 0; i < estados.length; i++) {

			lista += "(" + (i + 1) + ")" + " " + estados[i];
		}

		int opcao = Integer.parseInt(JOptionPane.showInputDialog(lista));

		if (opcao > estados.length) {
			throw new IllegalArgumentException("Unexpected value: " + opcao);
		}
		
		return estados[opcao - 1];
		
	}
}
