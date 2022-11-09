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

public class DatabaseGestor {

	private Connection conexion;
	
	public DatabaseGestor() {
		// conecta con la base de datos
		DatabaseConnection database = new DatabaseConnection();
		conexion = database.getConexion();
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
			Gestor gestor = new Gestor(usuario, password, correo);
			gestor.setId(id);
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
	
	
	public Gestor getGestor(int id) {
		
		Gestor gestor = null;
		PreparedStatement instruccion = null;
	
		try {
		
			String query = "SELECT * FROM `gestor` WHERE id=?";
			instruccion = conexion.prepareStatement(query);
			instruccion.setInt(1, id);
			
			ResultSet resultados = instruccion.executeQuery();
			
			if(resultados.next()) {
				gestor = new Gestor();
				gestor.setUsuario(resultados.getString("usuario"));
				gestor.setPassword(resultados.getString("password"));
				gestor.setCorreo(resultados.getString("correo"));
			}
			
		
			
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
		
			return gestor;
		}
	
	
	public boolean insertarGestor(Gestor gestor) {
		
	PreparedStatement instruccion = null;
	
	try {
		

		instruccion = conexion.prepareStatement("INSERT INTO gestor(usuario, password, correo) VALUES (?,?,?)");
		
		instruccion.setString(1, gestor.getUsuario());
		// se sustituye la segunda aparición del carácter ? con el valor gestor10
		instruccion.setString(2, gestor.getPassword());
		// se sustituye la tercera aparición del carácter ? con el valor gestor10@correo.com
		instruccion.setString(3, gestor.getCorreo());
		
		// ejecuta sentencia SQL
		int filasCreadas = instruccion.executeUpdate();
		
		return filasCreadas !=0;
	
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

	
	public boolean updateGestor(Gestor gestor) {
		
	
		PreparedStatement instruccion = null;
		
		try {
			
			instruccion = conexion.prepareStatement("UPDATE `gestor` SET usuario= ?,password= ?,correo= ? WHERE id=?");
			
			instruccion.setString(1, gestor.getUsuario());
			
			instruccion.setString(2, gestor.getPassword());
	
			instruccion.setString(3, gestor.getCorreo());
			
			instruccion.setInt(4, gestor.getId());
			
			System.out.println(gestor.getId());
			
	
			int filasActualizadas = instruccion.executeUpdate();
			
			System.out.println(filasActualizadas);
			
			return filasActualizadas !=0;
		
		
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


	public boolean deleteGestor(int id) {
		
		
		PreparedStatement instruccion = null;
		
		try {
			

			instruccion = conexion.prepareStatement("DELETE FROM `gestor` WHERE id = ?");
			
			instruccion.setInt(1,id);
			
			// ejecuta sentencia SQL
			int filasBorradas = instruccion.executeUpdate();
			
		
			return filasBorradas!=0;
		
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

}
