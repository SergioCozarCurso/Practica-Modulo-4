package app.curso.banco.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DatabaseConnection {
	
	private Connection conexion;
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_NAME = "banco";
	private static final String DB_USER = "banco";
	private static final String DB_PASS = "banco";

	
	public DatabaseConnection() {
		
		try {
			// conecta con la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME, DB_USER, DB_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Connection getConexion() {
		return conexion;
	}


}
