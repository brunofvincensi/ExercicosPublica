package view.marca;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.service.MarcaService;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabelaMarcas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public TabelaMarcas() throws SQLException {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 479, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 25, 394, 283);
		contentPane.add(scrollPane);
		
		table = new JTable(MarcaService.getTabela());
		scrollPane.setViewportView(table);
	}
}
