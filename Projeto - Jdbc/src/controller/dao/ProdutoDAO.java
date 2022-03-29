package controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import controller.interfaces.CrudGeneric;
import db.Conexao;
import enums.Categoria;
import model.Produto;

public class ProdutoDAO implements CrudGeneric<Produto, Integer>{

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

		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
		
			stmt.close();
			rs.close();
			connection.close();
			}
		
		
		
		return produtos;
	}


	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Produto obj, Integer var) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer var) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Optional<Produto> findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
