package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import controller.interfaces.CrudGeneric;
import db.Conexao;
import model.Marca;

public class MarcaDAO implements CrudGeneric<Marca, Integer> {

	@Override
	public List<Marca> findAll() throws SQLException {

		Conexao c = new Conexao();
		Connection connection = c.conectar();
		Statement stmt = null;
		ResultSet rs = null;

		List<Marca> marcas = new ArrayList<>();

		try {

			String sql = "SELECT * FROM marcas";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println();

				Marca marca = new Marca();

				marca.setCodigo(rs.getInt(1));
				marca.setNome(rs.getString(2));
				marcas.add(marca);

			}

		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {

			stmt.close();
			rs.close();
			connection.close();
		}

		return marcas;
	}

	@Override
	public void save(Marca marca) throws SQLException {
		Conexao c = new Conexao();
		Connection connection = c.conectar();
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO marcas(nome) VALUES(?)";

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, marca.getNome());
			pstmt.execute();

		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {
			connection.close();
			pstmt.close();
		}

	}

	@Override
	public void update(Marca marca, Integer index) throws SQLException {
		Conexao c = new Conexao();
		Connection connection = c.conectar();
		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE marcas SET nome = ? WHERE codigo = ?";

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, marca.getNome());
			pstmt.setInt(2, index);
			pstmt.execute();

		} catch (Exception err) {

			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {
			connection.close();
			pstmt.close();
		}

	}

	@Override
	public void delete(Integer id) throws SQLException {
		Conexao c = new Conexao();
		Connection connection = c.conectar();
		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM marcas WHERE codigo = ?";

			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();

		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {
			connection.close();
			pstmt.close();
		}

	}

	@Override
	public Optional<Marca> findById(Integer id) throws SQLException {

		Conexao c = new Conexao();
		Connection connection = c.conectar();
		PreparedStatement pstmt = null;
		Marca marca;
		Optional<Marca> opt = Optional.empty();

		try {

			String sql = "SELECT * FROM marcas WHERE codigo = ?";
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			rs.next();

			System.out.println("Codigo:" + rs.getInt(1));

			marca = new Marca();

			marca.setCodigo(rs.getInt(1));
			marca.setNome(rs.getString(2));

			opt = Optional.of(marca);

		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {

			pstmt.close();
			connection.close();
		}

		return opt;

	}
}
