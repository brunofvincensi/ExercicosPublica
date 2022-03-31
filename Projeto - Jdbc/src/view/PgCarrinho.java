package view;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import auxiliar.GerenciadorPdf;
import controller.service.CarrinhoService;
import controller.service.ProdutoService;
import model.Produto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class PgCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	public PgCarrinho(List<Produto> produtos) throws SQLException {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Meu carrinho");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 25, 184, 30);
		contentPane.add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 75, 426, 274);
		contentPane.add(scrollPane);

		table = new JTable(ProdutoService.listToTable(produtos));
		scrollPane.setViewportView(table);

		JButton btnComprar = new JButton("Finalizar compra");
		btnComprar.setBackground(SystemColor.activeCaption);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					List<Produto> produtos = ProdutoService.buscarTodos();

					List<Produto> produtosCarrinho = CarrinhoService.produtosCarrinho;

					for (Produto p : produtos) {

						for (Produto pCarrinho : produtosCarrinho) {

							if (pCarrinho.getCodigo() == p.getCodigo()) {

								p.setQuantidade(p.getQuantidade() - pCarrinho.getQuantidade());

								ProdutoService.alterarProduto(p, p.getCodigo());

								break;
							}
						}

					}

					Document document = new Document();
					String numeroBoleto = GerenciadorPdf.gerarCodigoBoleto();
					double valorTotal = CarrinhoService.getTotalPrice();
					PdfWriter.getInstance(document,
							new FileOutputStream(GerenciadorPdf.DOMINIO + "\\PDF_Boleto" + GerenciadorPdf.getNumero()));
					document.open();
					document.add(new Paragraph("Bradesco                 " + GerenciadorPdf.gerarCodigoBoleto()));
					document.add(new Paragraph("----------------------------------------------------"
							+ "-------------------------------------------------------------"));

					for (Produto produto : produtosCarrinho) {

						String nome = produto.getNome();
						int quantidade = produto.getQuantidade();
						double valor = produto.getValor();

						document.add(new Paragraph(nome + " -> " + "valor unitario: R$" + valor + " quantidade: "
								+ quantidade + " sub total: R$" + (valor * quantidade)));
					}

					document.add(new Paragraph());
					document.add(new Paragraph("Valor total: R$" + valorTotal));
					document.add(new Paragraph("Dia de expedição: " + LocalDate.now()));
					document.add(new Paragraph("Dia de expiração: " + LocalDate.now().plusDays(5)));

					document.close();

					String boleto = "Numero do boleto: " + numeroBoleto + "\n \n Valor total: " + valorTotal;

					JOptionPane.showMessageDialog(null, boleto);
					CarrinhoService.produtosCarrinho.clear();
					dispose();

				} catch (Exception err) {

					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprar.setBounds(191, 379, 167, 35);
		contentPane.add(btnComprar);

		JButton btnMaisUm = new JButton("Mais um");
		btnMaisUm.setBackground(SystemColor.activeCaption);
		btnMaisUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int index = table.getSelectedRow();

					Produto produto = CarrinhoService.produtosCarrinho.get(index);

					Produto produtoLoja = ProdutoService.buscarPorCodigo(produto.getCodigo());

					if (produtoLoja.getQuantidade() == produto.getQuantidade()) {
						throw new RuntimeException("Estoque insuficiente");
					}

					produto.aumentarQuantidade(1);
					table = new JTable(ProdutoService.listToTable(produtos));
					scrollPane.setViewportView(table);

				} catch (Exception err) {

					JOptionPane.showMessageDialog(null, err.getMessage());
				}

			}
		});
		btnMaisUm.setBounds(501, 129, 96, 21);
		contentPane.add(btnMaisUm);

		JButton btnMenosUm = new JButton("Menos um");
		btnMenosUm.setBackground(SystemColor.activeCaption);
		btnMenosUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int index = table.getSelectedRow();
					Produto produto = CarrinhoService.produtosCarrinho.get(index);

					if (produto.getQuantidade() == 1) {
						CarrinhoService.produtosCarrinho.remove(index);
					} else {
						produto.diminuirQuantidade(1);
					}

					table = new JTable(ProdutoService.listToTable(produtos));
					scrollPane.setViewportView(table);

				} catch (Exception err) {

					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		btnMenosUm.setBounds(501, 160, 96, 21);
		contentPane.add(btnMenosUm);

		JButton btnNewButton = new JButton("Remover item");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = table.getSelectedRow();
					if (index == -1) {
						throw new RuntimeException("Nenhum produto selecionado");
					}
					CarrinhoService.produtosCarrinho.remove(index);
					table = new JTable(ProdutoService.listToTable(produtos));
					scrollPane.setViewportView(table);
				} catch (Exception err) {

					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(501, 212, 116, 30);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Selecione um item");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(501, 87, 181, 21);
		contentPane.add(lblNewLabel_1);

	}
}
