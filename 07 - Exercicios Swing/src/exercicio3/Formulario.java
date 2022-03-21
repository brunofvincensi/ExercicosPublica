package exercicio3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField textPeso;
	private JTextField textAltura;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeso.setBounds(10, 28, 66, 22);
		contentPane.add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAltura.setBounds(10, 69, 66, 22);
		contentPane.add(lblAltura);
		
		textPeso = new JTextField();
		textPeso.setBounds(86, 32, 96, 19);
		contentPane.add(textPeso);
		textPeso.setColumns(10);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(86, 73, 96, 19);
		contentPane.add(textAltura);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblResultado.setBounds(86, 176, 225, 39);
		contentPane.add(lblResultado);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double altura = Double.parseDouble(textAltura.getText()) ;
				double peso = Double.parseDouble(textPeso.getText()) ;
				
				lblResultado.setText(calculaResultadoImc(calculaImc(peso, altura)));
			}
		});
		btnCalcular.setBounds(86, 117, 85, 21);
		contentPane.add(btnCalcular);
	}
	
	private static String calculaResultadoImc(double imc) {
		
		if(imc < 18.5) {
			return "Abaixo do peso";
		}
		else if(imc <= 24.9) {
			return "Peso normal";
		}
		else if(imc <= 29.9) {
			return "Sobrepeso";
		}
		else if(imc <= 34.9) {
			return "Obesidade 1";
		}
		else if(imc <= 39.9) {
			return "Obesidade 1";			
		}
		else {
			return "Obesidade 3 ou morbida";	
		}
	}
	
	
	private static double calculaImc(double peso, double altura) {
		return peso / (altura * altura);
	}

}
