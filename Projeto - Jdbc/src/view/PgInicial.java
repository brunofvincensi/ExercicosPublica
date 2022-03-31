package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.service.CarrinhoService;
import controller.service.MarcaService;
import controller.service.ProdutoService;
import enums.Categoria;
import model.Produto;
import view.marca.TabelaMarcas;
import view.produto.FormularioProduto;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;
import java.awt.Color;

public class PgInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	public static JTable table;
	public List<Produto> produtos = ProdutoService.buscarTodos();
	private JLabel lblQtdProdutos;
	private JLabel lblValorTotal;
	public static JScrollPane scrollPane;

	public static void main(String[] args) throws SQLException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PgInicial frame = new PgInicial(false);
					frame.setVisible(true);
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
	}

	public PgInicial(boolean isAdmin) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textNome = new JTextField();
		textNome.setBounds(191, 86, 244, 30);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JButton btnAdminAccess = new JButton("Entrar como admin");
		btnAdminAccess.setBackground(SystemColor.activeCaption);
		btnAdminAccess.setForeground(Color.BLACK);
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
		lblNewLabel.setBounds(10, 134, 85, 21);
		contentPane.add(lblNewLabel);

		JButton btnCarrinho = new JButton("");
		btnCarrinho.setIcon(new ImageIcon(
				"C:\\Users\\publica\\Desktop\\Publica - treinamento\\Projeto - Jdbc\\src\\images\\carrinho_compras.png"));
		btnCarrinho.setBackground(Color.WHITE);
		btnCarrinho.setForeground(Color.WHITE);
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new PgCarrinho(CarrinhoService.produtosCarrinho);
				} catch (SQLException err) {

					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		btnCarrinho.setBounds(761, 10, 51, 30);
		contentPane.add(btnCarrinho);

		lblQtdProdutos = new JLabel("0");
		lblQtdProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtdProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQtdProdutos.setBounds(808, 5, 37, 37);
		contentPane.add(lblQtdProdutos);

		JSpinner nQuantiade = new JSpinner();
		nQuantiade.setBackground(SystemColor.activeCaption);
		nQuantiade.setModel(new SpinnerNumberModel(1, null, null, 1));
		nQuantiade.setBounds(801, 326, 44, 33);
		contentPane.add(nQuantiade);

		JButton btnComprar = new JButton("Botar no carrinho");
		btnComprar.setBackground(SystemColor.activeCaption);
		btnComprar.setForeground(Color.BLACK);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int index = table.getSelectedRow();

					if (index == -1) {
						throw new RuntimeException("Nenhum produto selecionado");
					}

					int quantidade = (int) nQuantiade.getValue();

					if (quantidade < 1) {
						throw new RuntimeException("A quantidade não pode ser menor que 1");
					}

					Produto produto = produtos.get(index);

					int estoqueAtual = produto.getQuantidade();

					if (estoqueAtual < quantidade) {
						throw new RuntimeException("Estoque insuficiente");
					}

					Produto produtoSelecionado = new Produto();
					produtoSelecionado.setNome(produto.getNome());
					produtoSelecionado.setCategoria(produto.getCategoria());
					produtoSelecionado.setCodigo(produto.getCodigo());
					produtoSelecionado.setQuantidade(quantidade);
					produtoSelecionado.setValor(produto.getValor());
					produtoSelecionado.setMarca_id(produto.getMarca_id());

					CarrinhoService.adicionar(produtoSelecionado);
					lblQtdProdutos.setText(String.valueOf(CarrinhoService.getQtdItens()));
					lblValorTotal.setText("R$" + CarrinhoService.getTotalPrice());

					contentPane.add(lblQtdProdutos);
					contentPane.add(lblValorTotal);

					produto.setQuantidade(estoqueAtual - quantidade);

					table = new JTable(ProdutoService.listToTable(produtos));
					scrollPane.setViewportView(table);
					nQuantiade.setValue(1);

				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		btnComprar.setBounds(712, 376, 135, 37);
		contentPane.add(btnComprar);

		JLabel lblNewLabel_1 = new JLabel("Selecione um produto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(542, 113, 181, 21);
		contentPane.add(lblNewLabel_1);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(191, 134, 511, 335);
		contentPane.add(scrollPane);

		table = new JTable(ProdutoService.listToTable(produtos));
		scrollPane.setViewportView(table);

		Icon icon = new ImageIcon("lupa.png");

		System.out.println(icon);

		JRadioButton rdbtnRoupa = new JRadioButton("Roupa");
		rdbtnRoupa.setBackground(Color.WHITE);
		rdbtnRoupa.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnRoupa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnRoupa.setBounds(6, 172, 123, 21);
		rdbtnRoupa.setActionCommand("ROUPA");
		contentPane.add(rdbtnRoupa);

		JRadioButton rdbtnComida = new JRadioButton("Comida");
		rdbtnComida.setBackground(Color.WHITE);
		rdbtnComida.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnComida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnComida.setBounds(6, 196, 123, 21);
		rdbtnComida.setActionCommand("COMIDA");
		contentPane.add(rdbtnComida);

		JRadioButton rdbtnEletronico = new JRadioButton("Eletronico");
		rdbtnEletronico.setBackground(Color.WHITE);
		rdbtnEletronico.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEletronico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnEletronico.setBounds(6, 219, 123, 21);
		rdbtnEletronico.setActionCommand("ELETRONICO");
		contentPane.add(rdbtnEletronico);

		JRadioButton rdbtnEletrodomestico = new JRadioButton("Eletrodomestico");
		rdbtnEletrodomestico.setBackground(Color.WHITE);
		rdbtnEletrodomestico.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnEletrodomestico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnEletrodomestico.setBounds(6, 242, 123, 21);
		rdbtnEletrodomestico.setActionCommand("ELETRODOMESTICO");
		contentPane.add(rdbtnEletrodomestico);

		JRadioButton rdbtnTodasAsCategorias = new JRadioButton("Todas as categorias");
		rdbtnTodasAsCategorias.setBackground(Color.WHITE);
		rdbtnTodasAsCategorias.setSelected(true);
		rdbtnTodasAsCategorias.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnTodasAsCategorias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnTodasAsCategorias.setActionCommand("all");
		rdbtnTodasAsCategorias.setBounds(6, 265, 179, 21);
		contentPane.add(rdbtnTodasAsCategorias);

		ButtonGroup bgCategoria = new ButtonGroup();
		bgCategoria.add(rdbtnComida);
		bgCategoria.add(rdbtnRoupa);
		bgCategoria.add(rdbtnEletronico);
		bgCategoria.add(rdbtnEletrodomestico);
		bgCategoria.add(rdbtnTodasAsCategorias);

		JLabel lblPrecos = new JLabel("Pre\u00E7os:");
		lblPrecos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecos.setBounds(10, 292, 72, 21);
		contentPane.add(lblPrecos);

		JRadioButton rdbtnOpicao1 = new JRadioButton("at\u00E9 R$100");
		rdbtnOpicao1.setBackground(Color.WHITE);
		rdbtnOpicao1.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnOpicao1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOpicao1.setActionCommand("1");
		rdbtnOpicao1.setBounds(10, 331, 123, 21);
		contentPane.add(rdbtnOpicao1);

		JRadioButton rdbtnOpcao2 = new JRadioButton("entre R$100 e R$300");
		rdbtnOpcao2.setBackground(Color.WHITE);
		rdbtnOpcao2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnOpcao2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOpcao2.setActionCommand("2");
		rdbtnOpcao2.setBounds(10, 353, 156, 21);
		contentPane.add(rdbtnOpcao2);

		JRadioButton rdbtnOpcao3 = new JRadioButton("mais de R$300");
		rdbtnOpcao3.setBackground(Color.WHITE);
		rdbtnOpcao3.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnOpcao3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOpcao3.setActionCommand("3");
		rdbtnOpcao3.setBounds(10, 376, 123, 21);
		contentPane.add(rdbtnOpcao3);

		JRadioButton rdbtnOpcao4 = new JRadioButton("todos os pre\u00E7os");
		rdbtnOpcao4.setBackground(Color.WHITE);
		rdbtnOpcao4.setSelected(true);
		rdbtnOpcao4.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnOpcao4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOpcao4.setActionCommand("4");
		rdbtnOpcao4.setBounds(10, 399, 123, 21);
		contentPane.add(rdbtnOpcao4);

		ButtonGroup bgOpcao = new ButtonGroup();
		bgOpcao.add(rdbtnOpicao1);
		bgOpcao.add(rdbtnOpcao2);
		bgOpcao.add(rdbtnOpcao3);
		bgOpcao.add(rdbtnOpcao4);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.activeCaption);
		btnFiltrar.setForeground(Color.BLACK);
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String categoriaString = bgCategoria.getSelection().getActionCommand();

					Categoria categoria = categoriaString.equals("all") ? null : Categoria.valueOf(categoriaString);

					int opcaoValor = Integer.parseInt(bgOpcao.getSelection().getActionCommand());

					produtos = ProdutoService.buscarPorFiltro(categoria, opcaoValor);

					table = new JTable(ProdutoService.listToTable(produtos));
					scrollPane.setViewportView(table);

				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFiltrar.setBounds(10, 439, 85, 30);
		contentPane.add(btnFiltrar);

		lblValorTotal = new JLabel("R$0.0");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValorTotal.setBounds(722, 432, 138, 37);
		contentPane.add(lblValorTotal);

		JButton btnPesquisar = new JButton();
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setIcon(new ImageIcon(
				"C:\\Users\\publica\\Desktop\\Publica - treinamento\\Projeto - Jdbc\\src\\images\\lupa.png"));
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				rdbtnTodasAsCategorias.setSelected(true);
				rdbtnOpcao4.setSelected(true);

				try {
					String nome = textNome.getText();

					produtos = ProdutoService.buscarPorNome(nome);
					table = new JTable(ProdutoService.listToTable(produtos));
					scrollPane.setViewportView(table);

				} catch (SQLException err) {
					JOptionPane.showMessageDialog(null, err);
				}

			}
		});
		btnPesquisar.setBounds(445, 86, 57, 30);
		contentPane.add(btnPesquisar);

		JLabel lblQtdInserida = new JLabel("Quantidade");
		lblQtdInserida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQtdInserida.setBounds(712, 330, 96, 21);
		contentPane.add(lblQtdInserida);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dispose();
					CarrinhoService.produtosCarrinho.clear();
					PgInicial pg = new PgInicial(isAdmin);
					pg.setVisible(true);
				} catch (Exception err) {

					JOptionPane.showInternalMessageDialog(null, err.getMessage());
				}

			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(
				"C:\\Users\\publica\\Desktop\\Publica - treinamento\\Projeto - Jdbc\\src\\images\\publica_logo.jpg"));
		lblNewLabel_2.setBounds(46, 15, 106, 101);
		contentPane.add(lblNewLabel_2);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setBounds(552, 49, 101, 22);

		setJMenuBar(menuBar);

		JMenu marcaMenu = new JMenu("Gerenciar Marcas");
		marcaMenu.setEnabled(isAdmin);
		JMenu produtoMenu = new JMenu("Gerenciar Produtos");
		produtoMenu.setEnabled(isAdmin);

		menuBar.add(marcaMenu);
		menuBar.add(produtoMenu);

		JMenuItem addMarca = new JMenuItem("Adicionar marca");
		addMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String nome = JOptionPane.showInputDialog("Insira o nome da marca");
					MarcaService.adicionarMarca(nome);
				} catch (Exception err) {

					JOptionPane.showInternalMessageDialog(null, err.getMessage());
				}

			}
		});

		JMenuItem findMarcas = new JMenuItem("Listar marcas");
		findMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					TabelaMarcas tm = new TabelaMarcas();
					tm.setVisible(true);
				} catch (Exception err) {

					JOptionPane.showInternalMessageDialog(null, err.getMessage());
				}

			}
		});

		JMenuItem alterMarca = new JMenuItem("Alterar marca");
		alterMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int index = Integer.parseInt(JOptionPane.showInputDialog("Insira o codigo da marca"));
					MarcaService.buscarPorCodigo(index);

					String novoNome = JOptionPane.showInputDialog("Insira o novo nome da marca");
					MarcaService.alterarMarca(index, novoNome);
					JOptionPane.showMessageDialog(null, "Marca alterada");
				} catch (Exception err) {

					JOptionPane.showInternalMessageDialog(null, err.getMessage());
				}

			}
		});
		JMenuItem deleteMarca = new JMenuItem("Deletar marca");
		deleteMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int codigo = Integer.parseInt(JOptionPane.showInputDialog("Insira o código da marca"));
					MarcaService.removerMarca(codigo);
					JOptionPane.showMessageDialog(null, "Marca deletada");
				} catch (Exception err) {

					JOptionPane.showInternalMessageDialog(null, err.getMessage());
				}

			}
		});

		JMenuItem adicionarProduto = new JMenuItem("Adicionar produto");
		adicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FormularioProduto f = new FormularioProduto(null);
					f.setVisible(true);
				} catch (Exception err) {

					JOptionPane.showInternalMessageDialog(null, err.getMessage());
				}

			}
		});

		JMenuItem alterProduto = new JMenuItem("Alterar produto");
		alterProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigo = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do produto"));

					ProdutoService.buscarPorCodigo(codigo);

					FormularioProduto f = new FormularioProduto(codigo);
					f.setVisible(true);
				} catch (Exception err) {

					JOptionPane.showInternalMessageDialog(null, err.getMessage());
				}

			}
		});

		JMenuItem deleteProduto = new JMenuItem("Deletar produto");
		deleteProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codigo = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do produto"));
					ProdutoService.removerProduto(codigo);
					JOptionPane.showMessageDialog(null, "Produto deletado");
				} catch (Exception err) {

					JOptionPane.showInternalMessageDialog(null, err.getMessage());
				}

			}
		});
		marcaMenu.add(addMarca);
		marcaMenu.add(findMarcas);
		marcaMenu.add(alterMarca);
		marcaMenu.add(deleteMarca);

		produtoMenu.add(adicionarProduto);
		produtoMenu.add(alterProduto);
		produtoMenu.add(deleteProduto);

	}

}
