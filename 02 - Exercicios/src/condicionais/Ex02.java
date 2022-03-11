package condicionais;

import javax.swing.JOptionPane;

public class Ex02 {

	public static void main(String[] args) {

		int x1 = Integer.parseInt(JOptionPane.showInputDialog("insira um numero"));
		int x2 = Integer.parseInt(JOptionPane.showInputDialog("insira um numero"));

		if (x1 == x2) {
			JOptionPane.showMessageDialog(null, x1 + x2);
		} else {
			JOptionPane.showMessageDialog(null, x1 * x2);
		}

	}

}
