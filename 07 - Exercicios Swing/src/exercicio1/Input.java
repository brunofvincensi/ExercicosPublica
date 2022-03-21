package exercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Input extends JFrame {

	private JPanel contentPane;
	private JTextField textNumero;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Input frame = new Input();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Input() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumero = new JLabel("Insira um n\u00FAmero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(25, 25, 120, 41);
		contentPane.add(lblNumero);

		textNumero = new JTextField();
		textNumero.setBounds(155, 38, 111, 19);
		contentPane.add(textNumero);
		textNumero.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 92, 327, 161);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnTabuada = new JButton("mostrar tabuada");
		btnTabuada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer numero = null;
				try {
					numero = Integer.parseInt(textNumero.getText());

					DefaultTableModel dtm = new DefaultTableModel();

					dtm.addColumn("multiplicacao");
					dtm.addColumn("resultado");

					for (int i = 1; i < 10; i++) {

						dtm.addRow(new Object[] {

								numero + " x " + i, (numero * i) });
					}

					table.setModel(dtm);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);

					textNumero.setText(null);
				}
			}
		});
		btnTabuada.setBounds(286, 37, 126, 19);
		contentPane.add(btnTabuada);
	}
}
