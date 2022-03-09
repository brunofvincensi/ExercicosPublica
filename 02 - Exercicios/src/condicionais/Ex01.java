package condicionais;

import javax.swing.JOptionPane;

public class Ex01 {

	public static void main(String[] args) {
		
		int x1 =  Integer.parseInt(JOptionPane.showInputDialog("insira a nota")) ;
		int x2 = Integer.parseInt(JOptionPane.showInputDialog("insira a nota")) ;
		int x3 = Integer.parseInt(JOptionPane.showInputDialog("insira a nota")) ;
		
		double media = (x1 + x2 + x3) / 3;
		JOptionPane.showMessageDialog(null, "A media é " + media);

	}

}
