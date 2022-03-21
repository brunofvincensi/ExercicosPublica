package exercicio5.front;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exercicio5.dbs.AlunoDb;
import exercicio5.dbs.NotaDb;
import exercicio5.models.Aluno;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PgAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textIdade;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PgAluno(Aluno aluno) {
		
		int id = aluno.getId();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 30, 63, 17);
		contentPane.add(lblNome);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(10, 63, 63, 17);
		contentPane.add(lblGenero);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdade.setBounds(10, 94, 63, 17);
		contentPane.add(lblIdade);
		
		txtNome = new JTextField();
		txtNome.setText(aluno.getNome());
		txtNome.setBounds(62, 31, 126, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		textIdade = new JTextField();
		textIdade.setText(String.valueOf(aluno.getIdade()));
		textIdade.setColumns(10);
		textIdade.setBounds(62, 95, 81, 19);
		contentPane.add(textIdade);
		
		JComboBox<String> cbxGenero = new JComboBox<String>();
		cbxGenero.setBounds(62, 63, 81, 21);
		contentPane.add(cbxGenero);
		
		cbxGenero.addItem("Masculino");
		cbxGenero.addItem("Feminino");
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Aluno aluno = new Aluno();
				aluno.setNome(txtNome.getText());
				aluno.setIdade( Integer.parseInt(textIdade.getText()));
				aluno.setGenero(cbxGenero.getSelectedItem().toString());
				aluno.setId(id);
				
				AlunoDb.alterar(id, aluno);
			}
		});
		btnAlterar.setBounds(10, 140, 85, 21);
		contentPane.add(btnAlterar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 30, 359, 358);
		contentPane.add(scrollPane);
		
		table = new JTable(NotaDb.listarPorIdAluno(id));
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PgInicial pg = new PgInicial();
				pg.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 380, 85, 21);
		contentPane.add(btnVoltar);
	}
}
