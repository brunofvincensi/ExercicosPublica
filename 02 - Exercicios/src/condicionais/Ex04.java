package condicionais;

import javax.swing.JOptionPane;

public class Ex04 {

	public static void main(String[] args) {
		int x1 = Integer.parseInt(JOptionPane.showInputDialog("insira um numero"));
		int x2 = Integer.parseInt(JOptionPane.showInputDialog("insira um numero"));
		int x3 = Integer.parseInt(JOptionPane.showInputDialog("insira um numero"));

		if (x1 < x2 && x1 < x3) {
			JOptionPane.showMessageDialog(null, "O menor numero é o " + x1);
		} else if (x2 < x3) {
			JOptionPane.showMessageDialog(null, "O menor numero é o " + x2);
		} else {
			JOptionPane.showMessageDialog(null, "O menor numero é o " + x3);
		}

	}

}
