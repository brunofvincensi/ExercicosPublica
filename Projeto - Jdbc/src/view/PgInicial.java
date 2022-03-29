package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.dao.MarcaDAO;
import controller.service.MarcaService;
import controller.service.ProdutoService;

import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PgInicial extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	public static void main(String[] args) throws SQLException {
		
		
		MarcaDAO m = new MarcaDAO();
		
		m.findAll().forEach(ma -> System.out.println(ma));
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PgInicial frame = new PgInicial(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PgInicial(boolean isAdmin) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFiltrar.setBounds(10, 458, 85, 30);
		contentPane.add(btnFiltrar);
		
		textField = new JTextField();
		textField.setBounds(191, 105, 277, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAdminAccess = new JButton("Entrar como admin");
		btnAdminAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PgLogin pg = new PgLogin();
				pg.setVisible(true);
				
				dispose();
			
			}
		});
		btnAdminAccess.setBounds(542, 10, 166, 30);
		contentPane.add(btnAdminAccess);
		
		
		JLabel lblNewLabel = new JLabel("Categorias:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 153, 85, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnCarrinho = new JButton("Carrinho");
		btnCarrinho.setBounds(739, 10, 85, 30);
		contentPane.add(btnCarrinho);
		
		JLabel lblQtdProdutos = new JLabel("0");
		lblQtdProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtdProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQtdProdutos.setBounds(823, 5, 37, 37);
		contentPane.add(lblQtdProdutos);
		
		JButton btnComprar = new JButton("Botar no carrinho");
		btnComprar.setBounds(712, 451, 135, 37);
		contentPane.add(btnComprar);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione um produto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(542, 130, 181, 21);
		contentPane.add(lblNewLabel_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 153, 511, 335);
		contentPane.add(scrollPane);
		
		table = new JTable(ProdutoService.buscarProdutos());
		scrollPane.setViewportView(table);
		
		JComboBox cbxProdutos = new JComboBox();
		cbxProdutos.setBounds(26, 19, 29, 21);
		contentPane.add(cbxProdutos);
		
		
		JComboBox cbxMarcas = new JComboBox();
		cbxMarcas.setBounds(100, 19, 29, 21);
		contentPane.add(cbxMarcas);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(478, 109, 29, 26);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnRoupa = new JRadioButton("Roupa");
		rdbtnRoupa.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnRoupa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnRoupa.setBounds(6, 191, 123, 21);
		rdbtnRoupa.setActionCommand("ROUPA");
		contentPane.add(rdbtnRoupa);
		
		JRadioButton rdbtnComida = new JRadioButton("Comida");
		rdbtnComida.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnComida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnComida.setBounds(6, 215, 123, 21);
		rdbtnComida.setActionCommand("COMIDA");
		contentPane.add(rdbtnComida);
		
		JRadioButton rdbtnEletronico = new JRadioButton("Eletronico");
		rdbtnEletronico.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEletronico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnEletronico.setBounds(6, 238, 123, 21);
		rdbtnEletronico.setActionCommand("ELETRONICO");
		contentPane.add(rdbtnEletronico);
		
		JRadioButton rdbtnEletrodomestico = new JRadioButton("Eletrodomestico");
		rdbtnEletrodomestico.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEletrodomestico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnEletrodomestico.setBounds(6, 261, 123, 21);
		rdbtnEletrodomestico.setActionCommand("ELETRODOMESTICO");
		contentPane.add(rdbtnEletrodomestico);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnComida);
		bg.add(rdbtnRoupa);
		bg.add(rdbtnEletronico);
		bg.add(rdbtnEletrodomestico);
		
		JLabel lblPrecos = new JLabel("Pre\u00E7os:");
		lblPrecos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecos.setBounds(10, 311, 72, 21);
		contentPane.add(lblPrecos);
		
		JRadioButton rdbtnTodasAsCategorias = new JRadioButton("Todas as categorias");
		rdbtnTodasAsCategorias.setSelected(true);
		rdbtnTodasAsCategorias.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnTodasAsCategorias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnTodasAsCategorias.setActionCommand("all");
		rdbtnTodasAsCategorias.setBounds(6, 284, 179, 21);
		contentPane.add(rdbtnTodasAsCategorias);
		
		JRadioButton rdbtnOpicao1 = new JRadioButton("at\u00E9 R$100");
		rdbtnOpicao1.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnOpicao1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOpicao1.setActionCommand("1");
		rdbtnOpicao1.setBounds(10, 350, 123, 21);
		contentPane.add(rdbtnOpicao1);
		
		JRadioButton rdbtnOpcao2 = new JRadioButton("entre R$100 e R$300");
		rdbtnOpcao2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnOpcao2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOpcao2.setActionCommand("2");
		rdbtnOpcao2.setBounds(10, 372, 156, 21);
		contentPane.add(rdbtnOpcao2);
		
		JRadioButton rdbtnOpcao3 = new JRadioButton("mais de R$300");
		rdbtnOpcao3.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnOpcao3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOpcao3.setActionCommand("3");
		rdbtnOpcao3.setBounds(10, 395, 123, 21);
		contentPane.add(rdbtnOpcao3);
		
		
		ButtonGroup bgOpcao = new ButtonGroup();
		bgOpcao.add(rdbtnOpicao1);
		bgOpcao.add(rdbtnOpcao2);
		bgOpcao.add(rdbtnOpcao3);
		
		JRadioButton rdbtnOpcao4 = new JRadioButton("todos os pre\u00E7os");
		rdbtnOpcao4.setSelected(true);
		rdbtnOpcao4.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnOpcao4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOpcao4.setActionCommand("4");
		rdbtnOpcao4.setBounds(10, 418, 123, 21);
		contentPane.add(rdbtnOpcao4);
	
       
	}
}
