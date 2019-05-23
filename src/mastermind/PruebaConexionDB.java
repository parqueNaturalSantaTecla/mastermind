package mastermind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaConexionDB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("El driver no se encuentra");
			System.exit(-1);
		}
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "rootroot");
			Statement stmt = conexion.createStatement();
			String DB = "CREATE DATABASE IF NOT EXISTS `agencia_de_viajes_2`;\n";
			stmt.executeUpdate(DB);
			DB = "USE `agencia_de_viajes_2`;";
			stmt.executeUpdate(DB);
			DB = "CREATE TABLE IF NOT EXISTS `Games`\n"+
					"	(`name` varchar(20) NOT NULL,\n"+
					"	`turn`int(2),\n"+
					"	`secretCombination`int(4),\n"+
					"	PRIMARY KEY (`name`));";
			stmt.executeUpdate(DB);
			stmt.close();
			System.out.println("tabla creada");
		} catch (SQLException e) {
			System.err.println("Error en la base de datos " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					System.err.println("Error al cerrar la conexion " + e.getMessage());
					System.exit(-1);
				}
			}
		}
	}
}
