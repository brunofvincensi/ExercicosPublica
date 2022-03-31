package view.produto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.service.MarcaService;
import controller.service.ProdutoService;
import enums.Categoria;
import model.Marca;
import model.Produto;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textValor;
	private JTextField textEstoque;

	public FormularioProduto(Integer index) throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(25, 32, 48, 21);
		contentPane.add(lblNome);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValor.setBounds(25, 66, 48, 21);
		contentPane.add(lblValor);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoria.setBounds(25, 149, 123, 21);
		contentPane.add(lblCategoria);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstoque.setBounds(25, 97, 66, 21);
		contentPane.add(lblEstoque);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMarca.setBounds(25, 203, 48, 21);
		contentPane.add(lblMarca);
		
		textNome = new JTextField();
		textNome.setBounds(72, 34, 113, 21);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(72, 69, 66, 21);
		contentPane.add(textValor);
		
		textEstoque = new JTextField();
		textEstoque.setColumns(10);
		textEstoque.setBounds(90, 99, 58, 21);
		contentPane.add(textEstoque);
		
		
		JComboBox<String> cbxCategoria = new JComboBox<>();
		cbxCategoria.setBounds(106, 151, 113, 21);
		contentPane.add(cbxCategoria);
		
		for(Categoria c : Categoria.values()) {
			cbxCategoria.addItem(c.toString());
		}
		
		JComboBox<String> cbxMarca = new JComboBox<>();
		cbxMarca.setBounds(90, 205, 129, 21);
		contentPane.add(cbxMarca);
		
		List<Marca> marcas = MarcaService.buscarMarcas();
		
		for(Marca marca : marcas) {
			cbxMarca.addItem(marca.getNome());
		}
		
		
		JButton btnInserir = new JButton( index == null ? "Cadastrar" : "Alterar" );
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Produto produto = new Produto();
				
				produto.setNome(textNome.getText());
				produto.setValor(Double.parseDouble(textValor.getText()));
				produto.setQuantidade(Integer.parseInt(textEstoque.getText()));
				produto.setCategoria(Categoria.valueOf((String) cbxCategoria.getSelectedItem()));				
				produto.setMarca_id( marcas.get(cbxMarca.getSelectedIndex()).getCodigo());
				
				if(index == null) {
					ProdutoService.adicionarProduto(produto);
					JOptionPane.showMessageDialog(null, "Produto adicionado");
				}else {
					ProdutoService.alterarProduto(produto, index);
					JOptionPane.showMessageDialog(null, "Produto alterado");
				}
				
				
				
				}catch (Exception err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInserir.setBounds(123, 295, 96, 30);
		contentPane.add(btnInserir);
	
		
	}
}
