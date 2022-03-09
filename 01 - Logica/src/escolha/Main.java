package escolha;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		// Variavel para obter a cidade
		String cidade = JOptionPane.showInputDialog("Informe uma cidade");
		
		// Escolha
	     
		switch(cidade.toLowerCase()) {
		case "blumenau" : 
		JOptionPane.showMessageDialog(null, "Cidade da Oktoberfest");
		break;
		case "florianopolis" : 
			JOptionPane.showMessageDialog(null, "Capital da cidade");
		break;
		case "joinville" : 
			JOptionPane.showMessageDialog(null, "Maior cidade");
		break;
		
		default: JOptionPane.showMessageDialog(null, "Cidade não encontrada");
		
		}
		
		//Switch Statement
		
		switch(cidade) {
		case "blumenau", "floripa" -> JOptionPane.showMessageDialog(null, "SC");
		case "curitiba", "londrina" -> JOptionPane.showMessageDialog(null, "PR");
		default -> JOptionPane.showMessageDialog(null, "Cidade não encontrada");
		
		}
	
}}
