package confirmDialog;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// ConfirmeDialog
		int acao = JOptionPane.showConfirmDialog(null, "Escolha uma opcao");
		
		// Retornar a acao
		JOptionPane.showMessageDialog(null, acao);

	}

}
