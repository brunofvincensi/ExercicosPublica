package exercicio4.front;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import exercicio4.ProdutoDb;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Lista extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Lista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario formulario = new Formulario();
				formulario.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 10, 85, 21);
		contentPane.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 68, 544, 302);
		contentPane.add(scrollPane);
		
		table = new JTable(ProdutoDb.listar());
		scrollPane.setViewportView(table);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  try {
				int index = table.getSelectedRow();
			  
			  if(index < 0) {
					throw new RuntimeException("Nenhum produto selecionado");
				}
			  ProdutoDb.deletar(index);
			  table.setModel(ProdutoDb.listar());
			  }
			  catch (Exception err) {
				  JOptionPane.showMessageDialog(null, err);
			}
			}
		});
		
		
		btnDeletar.setBounds(436, 10, 85, 21);
		contentPane.add(btnDeletar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				int index = table.getSelectedRow();
				
				if(index < 0) {
					throw new RuntimeException("Nenhum produto selecionado");
				}
				
				FormularioAlterar fa = new FormularioAlterar(index);
				fa.setVisible(true);
				dispose();
				}
				catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);
				}
				
			}
		});
		btnAlterar.setBounds(436, 41, 85, 21);
		contentPane.add(btnAlterar);
		
		
		 
	}
}
