package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import enums.TipoInvestimento;
import models.Investimento;
import util.Calculo;
import valores.Feriados;
import valores.TaxaInvestimento;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class PgInput extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textValor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PgInput frame = new PgInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PgInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValor.setBounds(10, 24, 48, 26);
		contentPane.add(lblValor);

		textValor = new JTextField();
		textValor.setBounds(55, 30, 96, 19);
		contentPane.add(textValor);
		textValor.setColumns(10);

		JRadioButton rdbtn_3 = new JRadioButton("3 meses");
		rdbtn_3.setSelected(true);
		rdbtn_3.setBounds(10, 115, 103, 21);
		rdbtn_3.setActionCommand("3");
		contentPane.add(rdbtn_3);

		JRadioButton rdbtn_6 = new JRadioButton("6 meses");
		rdbtn_6.setBounds(10, 153, 103, 21);
		rdbtn_6.setActionCommand("6");
		contentPane.add(rdbtn_6);

		JRadioButton rdbtn_9 = new JRadioButton("9 meses");
		rdbtn_9.setBounds(10, 190, 103, 21);
		rdbtn_9.setActionCommand("9");
		contentPane.add(rdbtn_9);

		JRadioButton rdbtn_12 = new JRadioButton("12 meses");
		rdbtn_12.setBounds(10, 226, 103, 21);
		rdbtn_12.setActionCommand("12");
		contentPane.add(rdbtn_12);

		JRadioButton rdbtn_18 = new JRadioButton("18 meses");
		rdbtn_18.setBounds(10, 261, 103, 21);
		rdbtn_18.setActionCommand("18");
		contentPane.add(rdbtn_18);

		ButtonGroup meses = new ButtonGroup();

		meses.add(rdbtn_3);
		meses.add(rdbtn_6);
		meses.add(rdbtn_9);
		meses.add(rdbtn_12);
		meses.add(rdbtn_18);

		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o");
		lblDuracao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDuracao.setBounds(10, 75, 90, 30);
		contentPane.add(lblDuracao);


		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				double valorAporte;
				LocalDate diaAporte, diaRetirada;
				int duracao, diasTotais, diasNaoRentaveis;

				valorAporte = Double.parseDouble(textValor.getText());

				if (valorAporte <= 0) {
					throw new RuntimeException("Insira um valor válido");
				}

				duracao = Integer.parseInt(meses.getSelection().getActionCommand());

				diaAporte = LocalDate.now();

				diaRetirada = Calculo.calcularRetirada(diaAporte, duracao);
				
				
				 diasTotais = 0;
				 diasNaoRentaveis = 0;			

				while (diaAporte.isBefore(diaRetirada)) {

					int mes = diaAporte.getMonthValue();

					int dia = diaAporte.getDayOfMonth();

					int[] feriados = Feriados.feriados.get(mes);
			
					if (diaAporte.getDayOfWeek() == DayOfWeek.SATURDAY ||  
							diaAporte.getDayOfWeek() == DayOfWeek.SUNDAY ) {
						
						diasNaoRentaveis++;
					} else {

						for (int i = 0; i < feriados.length; i++) {
							if (Feriados.feriados.get(mes)[i] == dia) {
								diasNaoRentaveis++;
								break;
							}
						}
					}
                    diasTotais++;
					diaAporte = diaAporte.plusDays(1);
					
				}
				
				int diasRentaveis = diasTotais - diasNaoRentaveis;
				
				double taxaPoupanca = TaxaInvestimento.taxasMensais.get(TipoInvestimento.POUPANCA);
				
				double taxaCdb = TaxaInvestimento.taxasMensais.get(TipoInvestimento.CDB);
				
				double taxaLci = TaxaInvestimento.taxasMensais.get(TipoInvestimento.LCI);
				
				
				double valorRecebidoPoupanca = Calculo.calcularValorComJuros(valorAporte, taxaPoupanca, duracao) - valorAporte;
				
				
				double valorRecebidoCdb = Calculo.calcularValorComJuros(valorAporte, taxaCdb, duracao) - valorAporte;
				
			
				double valorRecebidoLci = Calculo.calcularValorComJuros(valorAporte, taxaLci, duracao) - valorAporte;
				
				
				double impostoCdb = Calculo.calcularImpostoCdb( valorRecebidoCdb, duracao);
				

				
				Investimento poupanca = new Investimento(TipoInvestimento.POUPANCA, valorRecebidoPoupanca, 
						0.0, valorAporte);
				
				Investimento lci = new Investimento(TipoInvestimento.LCI, valorRecebidoLci, 
						0.0, valorAporte);
				
				Investimento cdb = new Investimento(TipoInvestimento.CDB, valorRecebidoCdb, 
						impostoCdb, valorAporte);
				
				
				PgOutput pg = new PgOutput(Arrays.asList(poupanca, lci, cdb), valorAporte, diasTotais, diasRentaveis);
				
			
				pg.setVisible(true);				
				dispose();
			}
		});

		btnCalcular.setBounds(118, 261, 85, 21);
		contentPane.add(btnCalcular);
	}
}
