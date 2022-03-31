package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class PgLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField passwordField;

	public PgLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setUndecorated(true);
		setBounds(100, 100, 369, 284);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(59, 66, 86, 32);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(59, 123, 86, 32);
		contentPane.add(lblSenha);

		textLogin = new JTextField();
		textLogin.setBounds(131, 71, 162, 27);
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean isAdmin = false;
				try {
					String login = textLogin.getText();
					
					@SuppressWarnings("deprecation")
					String senha = passwordField.getText();

					if (login.equals("root") && senha.equals("admin")) {

						isAdmin = true;

					} else {
						isAdmin = false;
						throw new RuntimeException("Login ou senha incorretos");
					}

				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
				}

				try {
					PgInicial pg = new PgInicial(isAdmin);
					pg.setVisible(true);
					dispose();
				} catch (SQLException err) {
					
					JOptionPane.showMessageDialog(null, err.getMessage());
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setBounds(127, 187, 94, 32);
		contentPane.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 130, 162, 27);
		contentPane.add(passwordField);

	}
}
