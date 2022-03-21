package exercicio4.front;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exercicio4.Produto;
import exercicio4.ProdutoDb;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textMarca;
	private JTextField textSegmento;
	private JTextField textValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(152, 0, 178, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(25, 64, 72, 17);
		contentPane.add(lblNome);
		
		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(25, 96, 72, 17);
		contentPane.add(lblMarca);
		
		JLabel lblSegmento = new JLabel("Segmento: ");
		lblSegmento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSegmento.setBounds(25, 123, 94, 17);
		contentPane.add(lblSegmento);
		
		JLabel lblValor = new JLabel("Valor: ");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(25, 155, 72, 17);
		contentPane.add(lblValor);
		
		textNome = new JTextField();
		textNome.setBounds(107, 65, 132, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(107, 97, 132, 19);
		contentPane.add(textMarca);
		
		textSegmento = new JTextField();
		textSegmento.setColumns(10);
		textSegmento.setBounds(107, 124, 132, 19);
		contentPane.add(textSegmento);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(107, 156, 94, 19);
		contentPane.add(textValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Produto produto = new Produto();
				
				produto.setNome(textNome.getText());
				produto.setMarca(textMarca.getText());
				produto.setSegmento(textSegmento.getText());
				produto.setValor(Double.parseDouble(textValor.getText()));
				
				ProdutoDb.save(produto);
				}catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);
				}
				
			}
		});
		btnCadastrar.setBounds(25, 208, 94, 21);
		contentPane.add(btnCadastrar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Lista lista = new Lista();
				lista.setVisible(true);
				dispose();
				
			}
		});
		btnListar.setBounds(25, 239, 94, 21);
		contentPane.add(btnListar);
	}

}
