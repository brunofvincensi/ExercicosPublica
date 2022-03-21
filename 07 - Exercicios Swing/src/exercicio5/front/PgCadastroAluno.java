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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PgCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textIdade;

	public PgCadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 33, 45, 13);
		contentPane.add(lblNome);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 72, 45, 13);
		contentPane.add(lblIdade);

		JLabel lblNewLabel_2 = new JLabel("Genero");
		lblNewLabel_2.setBounds(10, 110, 45, 13);
		contentPane.add(lblNewLabel_2);

		textNome = new JTextField();
		textNome.setBounds(59, 33, 127, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textIdade = new JTextField();
		textIdade.setColumns(10);
		textIdade.setBounds(59, 69, 78, 19);
		contentPane.add(textIdade);

		JComboBox cbxGenero = new JComboBox();
		cbxGenero.setBounds(59, 106, 116, 21);
		contentPane.add(cbxGenero);

		cbxGenero.addItem("Masculino");
		cbxGenero.addItem("Feminino");

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Aluno aluno = new Aluno();

					aluno.setNome(textNome.getText());
					aluno.setIdade(Integer.parseInt(textIdade.getText()));
					aluno.setGenero(cbxGenero.getSelectedItem().toString());

					AlunoDb.save(aluno);
					
					
					PgInicial pg = new PgInicial();
					pg.setVisible(true);
					dispose();

				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);
				}
			}

		});
		btnCadastrar.setBounds(10, 188, 97, 21);
		contentPane.add(btnCadastrar);
	}

}
