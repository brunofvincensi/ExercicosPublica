package exercicio5.front;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exercicio5.dbs.AlunoDb;
import exercicio5.models.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PgInicial extends JFrame {

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
		setBounds(100, 100, 375, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seguir como: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(137, 23, 144, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do aluno"));
				
				Aluno aluno = AlunoDb.findById(id);
				
				PgAluno pgAluno = new PgAluno(aluno);
				pgAluno.setVisible(true);				
				dispose();
			}
		});
		btnAluno.setBounds(137, 64, 100, 21);
		contentPane.add(btnAluno);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProfessor.setBounds(137, 95, 100, 21);
		contentPane.add(btnProfessor);
		
		JLabel lblNewLabel_1 = new JLabel("Ou cadastrar aluno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 215, 164, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCadastrar = new JButton("Clique aqui");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PgCadastroAluno pgc = new PgCadastroAluno();
				pgc.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(141, 217, 100, 21);
		contentPane.add(btnCadastrar);
	}

}
