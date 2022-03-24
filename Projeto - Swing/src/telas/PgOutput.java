package telas;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import models.Investimento;
import valores.TaxaInvestimento;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class PgOutput extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public PgOutput(List<Investimento> investimentos, double valorIncicial, int diasTotais,
			int diasRentaveis) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblValorInicial = new JLabel("Valor inicial: R$" + valorIncicial);
		lblValorInicial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorInicial.setBounds(10, 23, 259, 30);
		contentPane.add(lblValorInicial);

		JLabel lblDiasRentaveis = new JLabel("Dias que houve rendimento: " + diasRentaveis);
		lblDiasRentaveis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiasRentaveis.setBounds(10, 63, 259, 30);
		contentPane.add(lblDiasRentaveis);

		JLabel lblTotalDeDias = new JLabel("Total de dias: " + diasTotais);
		lblTotalDeDias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalDeDias.setBounds(10, 103, 212, 30);
		contentPane.add(lblTotalDeDias);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 776, 209);
		contentPane.add(scrollPane);	

		DefaultTableModel dtm = new DefaultTableModel();

		 NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		dtm.addColumn("Tipo");
		dtm.addColumn("taxa mensal");
		dtm.addColumn("imposto de renda");
		dtm.addColumn("lucro bruto");
		dtm.addColumn("lucro liquido");
		dtm.addColumn("valor total");

		for (Investimento i : investimentos) {
			dtm.addRow(new Object[] {

					i.getTipo(),
					 TaxaInvestimento.taxasMensais.get(i.getTipo()) + "%",
					i.getValorImposto() * 100 + "%", 
					nf.format(i.getJurosBruto()) ,
					nf.format(i.getJurosLiquido()) ,
					nf.format(i.getValorTotal()) 
					
				

			});	
		}

		table = new JTable(dtm);
		scrollPane.setViewportView(table);

		JButton btnMostrarGrafico = new JButton("Mostrar grafico");
		btnMostrarGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 new PgGrafico(investimentos);
			}
		});
		btnMostrarGrafico.setBounds(591, 53, 137, 40);
		contentPane.add(btnMostrarGrafico);

	}
}
