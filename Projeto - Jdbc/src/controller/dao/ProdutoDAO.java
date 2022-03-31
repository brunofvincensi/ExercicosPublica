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
import enums.Categoria;
import model.Produto;

public class ProdutoDAO implements CrudGeneric<Produto, Integer> {

	@Override
	public List<Produto> findAll() throws SQLException {

		Conexao c = new Conexao();
		Connection connection = c.conectar();
		Statement stmt = null;
		ResultSet rs = null;

		List<Produto> produtos = new ArrayList<>();

		try {

			String sql = "SELECT * FROM produtos;";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Produto produto = new Produto();

				produto.setCodigo(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));
				produto.setCategoria(Categoria.valueOf(rs.getString(4)));
				produto.setQuantidade(rs.getInt(5));
				produto.setMarca_id(rs.getInt(6));

				produtos.add(produto);

			}

		} catch (Exception err) {

			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {

			stmt.close();
			rs.close();
			connection.close();
		}

		return produtos;
	}

	@Override
	public void update(Produto produto, Integer id) throws SQLException {
		Conexao c = new Conexao();
		Connection connection = c.conectar();
		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE produtos SET nome = ?, valor = ?, categoria = ?, quantidade = ?, marca_id = ?"
					+ " WHERE codigo = ?";

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, produto.getNome());
			pstmt.setDouble(2, produto.getValor());
			pstmt.setString(3, produto.getCategoria().toString());
			pstmt.setInt(4, produto.getQuantidade());
			pstmt.setInt(5, produto.getMarca_id());
			pstmt.setInt(6, id);

			pstmt.execute();

		} catch (Exception err) {

			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {

			pstmt.close();
			connection.close();
		}

	}

	@Override
	public void delete(Integer id) throws SQLException {
		Conexao c = new Conexao();
		Connection connection = c.conectar();
		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM produtos WHERE codigo = ?";

			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();

		} catch (Exception err) {

			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {

			pstmt.close();
			connection.close();
		}

	}

	@Override
	public Optional<Produto> findById(Integer id) throws SQLException {
		Conexao c = new Conexao();
		Connection connection = c.conectar();
		PreparedStatement pstmt = null;
		Produto produto;
		Optional<Produto> opt = Optional.empty();

		try {

			String sql = "SELECT * FROM produtos WHERE codigo = ?";
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			rs.next();

			produto = new Produto();

			produto.setCodigo(rs.getInt(1));
			produto.setNome(rs.getString(2));
			produto.setValor(rs.getDouble(3));
			produto.setCategoria(Categoria.valueOf(rs.getString(4)));
			produto.setQuantidade(rs.getInt(5));
			produto.setMarca_id(rs.getInt(6));

			opt = Optional.of(produto);

		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {

			pstmt.close();
			connection.close();
		}

		return opt;

	}

	@Override
	public void save(Produto produto) throws SQLException {
		Conexao c = new Conexao();
		Connection connection = c.conectar();
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO produtos(nome, valor, categoria, quantidade, marca_id)"
					+ " VALUES(?, ?, ?, ?, ?)";

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, produto.getNome());
			pstmt.setDouble(2, produto.getValor());
			pstmt.setString(3, produto.getCategoria().toString());
			pstmt.setInt(4, produto.getQuantidade());
			pstmt.setInt(5, produto.getMarca_id());
			pstmt.execute();

		} catch (Exception err) {

			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {

			pstmt.close();
			connection.close();
		}

	}

	public List<Produto> buscarPorNome(String nome) throws SQLException {
		Conexao c = new Conexao();
		Connection connection = c.conectar();
		PreparedStatement pstmt = null;
		List<Produto> produtos = new ArrayList<>();

		try {
			String sql = "SELECT * FROM produtos WHERE nome like ?";

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();

				produto.setCodigo(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));
				produto.setCategoria(Categoria.valueOf(rs.getString(4)));
				produto.setQuantidade(rs.getInt(5));
				produto.setMarca_id(rs.getInt(6));

				produtos.add(produto);
			}

		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {

			pstmt.close();
			connection.close();
		}

		return produtos;

	}

	public List<Produto> buscarPorFiltro(Categoria categoria, int opcaoValor) throws SQLException {
		Conexao c = new Conexao();
		Connection connection = c.conectar();
		PreparedStatement pstmt = null;
		List<Produto> produtos = new ArrayList<>();
		boolean temQuategoria = false;

		try {

			String sql = "SELECT * FROM produtos WHERE nome like '%%'";

			if (categoria != null) {
				sql += " AND categoria = ?";
				temQuategoria = true;
			}

			switch (opcaoValor) {

			case 1 -> sql += "AND valor < 100";

			case 2 -> sql += "AND valor >= 100 AND valor <= 300";

			case 3 -> sql += "AND valor > 300";

			case 4 -> {
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + opcaoValor);
			}

			pstmt = connection.prepareStatement(sql);

			if (temQuategoria) {
				pstmt.setString(1, categoria.toString());
			}

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();

				produto.setCodigo(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));
				produto.setCategoria(Categoria.valueOf(rs.getString(4)));
				produto.setQuantidade(rs.getInt(5));
				produto.setMarca_id(rs.getInt(6));

				produtos.add(produto);
			}

		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		} finally {

			pstmt.close();
			connection.close();
		}

		return produtos;

	}

}
