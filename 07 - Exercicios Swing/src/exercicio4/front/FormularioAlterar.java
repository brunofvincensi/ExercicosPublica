package exercicio4.front;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exercicio4.Produto;
import exercicio4.ProdutoDb;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioAlterar extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textMarca;
	private JTextField textSegmento;
	private JTextField textValor;
	private JButton btnSalvar;

	public FormularioAlterar(int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoNome = new JLabel("Novo nome");
		lblNovoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNovoNome.setBounds(10, 49, 93, 17);
		contentPane.add(lblNovoNome);
		
		JLabel lblNovaMarca = new JLabel("Nova marca");
		lblNovaMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNovaMarca.setBounds(10, 93, 93, 24);
		contentPane.add(lblNovaMarca);
		
		JLabel lblNovoSegmento = new JLabel("Novo segmento");
		lblNovoSegmento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNovoSegmento.setBounds(10, 145, 140, 24);
		contentPane.add(lblNovoSegmento);
		
		JLabel lblNovoValor = new JLabel("Novo valor");
		lblNovoValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNovoValor.setBounds(10, 197, 93, 24);
		contentPane.add(lblNovoValor);
		
		textNome = new JTextField();
		textNome.setBounds(124, 50, 120, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(124, 98, 120, 19);
		contentPane.add(textMarca);
		
		textSegmento = new JTextField();
		textSegmento.setColumns(10);
		textSegmento.setBounds(124, 150, 120, 19);
		contentPane.add(textSegmento);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(124, 202, 93, 19);
		contentPane.add(textValor);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto novoProduto = new Produto();
				
				novoProduto.setNome(textNome.getText());
				novoProduto.setSegmento(textSegmento.getText());
				novoProduto.setMarca(textMarca.getText());
				novoProduto.setValor(Double.parseDouble(textValor.getText()));
				
				ProdutoDb.alterar(index, novoProduto);
			}
		});
		btnSalvar.setBounds(10, 271, 85, 21);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lista lista = new Lista();
				lista.setVisible(true);
				dispose();
				
			}
		});
		btnVoltar.setBounds(10, 314, 85, 21);
		contentPane.add(btnVoltar);
		
		
	}

}
