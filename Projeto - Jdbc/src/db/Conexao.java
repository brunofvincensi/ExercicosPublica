package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public Connection conectar() {

		Connection obj = null;

		try {

			obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");

			System.out.println("Conexao realizada");
		} catch (Exception e) {
			System.out.println("Falha ao conectar " + e.getMessage());
		}

		return obj;

	}
}
