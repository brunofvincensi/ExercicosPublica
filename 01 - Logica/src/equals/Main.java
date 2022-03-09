package equals;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		// Obter nomes
		String nome1 = JOptionPane.showInputDialog("1° nome");
		String nome2 = JOptionPane.showInputDialog("2° nome");
		
		// Comparativo
		if(nome1.equalsIgnoreCase(nome2)) {
			JOptionPane.showMessageDialog(null, "São iguais");
		}else {
			JOptionPane.showMessageDialog(null, "São diferentes");
		}
	}

}
