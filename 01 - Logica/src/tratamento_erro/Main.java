package tratamento_erro;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		boolean valida = false;
		
		do {
		
		try {
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero"));
		valida = true;
	} 
		catch(Exception e){
		JOptionPane.showMessageDialog(null, e);
		
	}
		}while(valida == false);
	
	
	}
}
