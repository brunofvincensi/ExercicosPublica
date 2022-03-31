package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PgInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PgInicial frame = new PgInicial();
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
	public PgInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInserir = new JButton("Cadastrar");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnInserir.setBounds(113, 47, 85, 21);
		contentPane.add(btnInserir);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(113, 78, 85, 21);
		contentPane.add(btnListar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(113, 109, 85, 21);
		contentPane.add(btnAlterar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(113, 140, 85, 21);
		contentPane.add(btnRemover);
		
		JButton btnEstatsticas = new JButton("Estat\u00EDsticas");
		btnEstatsticas.setBounds(113, 171, 85, 21);
		contentPane.add(btnEstatsticas);
		
		JLabel lblTitulo = new JLabel("Gerenciador de alunos");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(85, 10, 151, 27);
		contentPane.add(lblTitulo);
	}
}
