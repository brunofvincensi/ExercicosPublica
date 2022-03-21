package exercicio2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Input extends JFrame {

	private JPanel contentPane;
	private JTextField textReais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Input frame = new Input();
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
	public Input() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReais = new JLabel("Valor em reais: ");
		lblReais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReais.setBounds(10, 26, 122, 34);
		contentPane.add(lblReais);
		
		textReais = new JTextField();
		textReais.setBounds(122, 36, 113, 19);
		contentPane.add(textReais);
		textReais.setColumns(10);
		
		JRadioButton rdbtnDolar = new JRadioButton("Dolar");
		rdbtnDolar.setSelected(true);
		rdbtnDolar.setBounds(10, 80, 103, 21);
		rdbtnDolar.setActionCommand("Dolar");
		contentPane.add(rdbtnDolar);
	
		
		JRadioButton rdbtnEuro = new JRadioButton("Euro");
		rdbtnEuro.setBounds(10, 111, 103, 21);
		rdbtnEuro.setActionCommand("Euro");
		contentPane.add(rdbtnEuro);
		
		JRadioButton rdbtnLibra = new JRadioButton("Libra");
		rdbtnLibra.setBounds(10, 144, 103, 21);
		rdbtnLibra.setActionCommand("Libra");
		contentPane.add(rdbtnLibra);
		
		JRadioButton rdbtnIeneJapons = new JRadioButton("Iene japones");
		rdbtnIeneJapons.setBounds(10, 176, 103, 21);
		rdbtnIeneJapons.setActionCommand("Iene japones");
		contentPane.add(rdbtnIeneJapons);
		
		JRadioButton rdbtnPesoArgentino = new JRadioButton("Peso argentino");
		rdbtnPesoArgentino.setBounds(10, 211, 103, 21);
		rdbtnPesoArgentino.setActionCommand("Peso argentino");
		contentPane.add(rdbtnPesoArgentino);
		
		ButtonGroup moedas = new ButtonGroup();
		moedas.add(rdbtnDolar);
		moedas.add(rdbtnEuro);
		moedas.add(rdbtnLibra);
		moedas.add(rdbtnIeneJapons);
		moedas.add(rdbtnPesoArgentino);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(243, 148, 85, 27);
		contentPane.add(lblResultado);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
				String moedaSelecionada = moedas.getSelection().getActionCommand();
				
				double valorMoeda = ValorMoedas.valorMoedas.get(moedaSelecionada);
				
				double resultado = valorMoeda * Double.parseDouble(textReais.getText());
				lblResultado.setText( "R$".concat(String.valueOf(resultado)));
				
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnCalcular.setBounds(243, 35, 85, 21);
		contentPane.add(btnCalcular);
		
	
		
	}
}
