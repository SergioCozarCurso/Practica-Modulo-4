package app.curso.banco.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import app.curso.banco.entidad.Gestor;

public class Database {

	private Connection conexion;
	
	public Database() {
	try {
	// conecta con la base de datos
	conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
	} catch (SQLException e) {
	e.printStackTrace();
	}
}
	
	
	
	public boolean insertarGestor(Gestor gestor) {
		
	Statement instruccion = null;
	PreparedStatement ps = null;
	
	try {
		
		// obtiene un objeto de tipo Statement
		instruccion = conexion.createStatement();

		ps = conexion.prepareStatement("INSERT INTO gestor(usuario, password, correo) VALUES (?,?,?)");
		
		ps.setString(1, gestor.getUsuario());
		// se sustituye la segunda aparición del carácter ? con el valor gestor10
		ps.setString(2, gestor.getPassword());
		// se sustituye la tercera aparición del carácter ? con el valor gestor10@correo.com
		ps.setString(3, gestor.getCorreo());
		
		// ejecuta sentencia SQL
		ps.executeUpdate();
		
		// cierra la sentencia
		instruccion.close();
	return true;
	
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		if (instruccion != null) {
			try {
				instruccion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return false;
	}	


	
	
	public ArrayList<Gestor> getGestores() {
		
		Statement instruccion = null;
		
		ArrayList<Gestor> gestores = new ArrayList<Gestor>();
		try {
			// obtiene un objeto de tipo Statement
			instruccion = conexion.createStatement();
			// ejecuta sentencia SQL
			ResultSet resultados = instruccion.executeQuery("SELECT * from gestor");
			while (resultados.next()) {
			int id = resultados.getInt("id");
			String usuario = resultados.getString("usuario");
			String password = resultados.getString("password");
			String correo = resultados.getString("correo");
			Gestor gestor = new Gestor(id, usuario, password, correo);
			gestores.add(gestor);
			}
			// cierra la sentencia
			instruccion.close();
			return gestores;
			
		} catch (SQLException e) {
		e.printStackTrace();
		
		} finally {
			if (instruccion != null) {
					try {
						instruccion.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return null;
		}
	
}
