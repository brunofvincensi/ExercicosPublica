package telas;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import models.Investimento;

public class PgGrafico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PgGrafico(List<Investimento> investimentos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		criarGrafico(investimentos);
		setVisible(true);
	}

	public void criarGrafico(List<Investimento> investimentos) {

		DefaultCategoryDataset barra = new DefaultCategoryDataset();

		for (Investimento i : investimentos) {

			barra.setValue(i.getValorTotal(), i.getTipo(), "");

		}
		JFreeChart grafico = ChartFactory.createBarChart3D("Valor Final", "Tipos de Investimentos", "Reais", barra,
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}

}
