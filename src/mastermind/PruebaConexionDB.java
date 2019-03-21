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
			//			String DB3 = "CREATE TABLE `destinos` (\r\n" + "						`id_destino` int(4) NOT NULL,\r\n"
//					+ "						`nombre_destino` varchar(20) NOT NULL,\r\n"
//					+ "						`vuelo` datetime NOT NULL,\r\n"
////					+ "						`precio_vuelo` int(12) NOT NULL,\r\n"
////					+ "						PRIMARY KEY (`id_destino`)\r\n" + "					);";
//
//			String DB4 = "CREATE TABLE `hoteles` (\r\n" + "					`id_hotel` int(12) NOT NULL,\r\n"
//					+ "					`nombre_hotel` varchar(30) NOT NULL,\r\n"
//					+ "					`ciudad` varchar(30) NOT NULL,\r\n"
//					+ "					`cercania_centro` float(10) NOT NULL, \r\n"
//					+ "					`cercania_aeropuerto` float(10) NOT NULL, \r\n"
//					+ "					`servicios` varchar(30) NOT NULL, \r\n"
//					+ "					`precio_hotel` int(10) NOT NULL, \r\n"
//					+ "					PRIMARY KEY (`id_hotel`),\r\n"
//					+ "					CONSTRAINT `fk_city` FOREIGN KEY (`ciudad`) REFERENCES `agencia_de_viajes`.`destinos` (`nombre_destino`)\r\n"
//					+ "				);";
//
//			String DB5 = "CREATE TABLE `clientes` (\r\n" + "`id_cliente` int(12) NOT NULL, \r\n"
//					+ "`nombre` varchar(30) NOT NULL, \r\n" + "`apellidos` varchar(30) NOT NULL,\r\n"
//					+ "`dinero_cuenta` int(10) NOT NULL,\r\n" + "PRIMARY KEY (`id_cliente`));";

//			stmt.executeUpdate(DB);
//			stmt.executeUpdate(DB2);
//			stmt.executeUpdate(DB3);
//			stmt.executeUpdate(DB4);
//			stmt.executeUpdate(DB5);
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
