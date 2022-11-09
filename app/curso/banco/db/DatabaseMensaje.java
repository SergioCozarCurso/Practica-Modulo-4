package app.curso.banco.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import app.curso.banco.entidad.Gestor;
import app.curso.banco.entidad.Mensaje;

public class DatabaseMensaje {

	private Connection conexion;
	
	public DatabaseMensaje() {
	
		// conecta con la base de datos
		DatabaseConnection database = new DatabaseConnection();
		conexion = database.getConexion();
	}
	
	public ArrayList<Mensaje> getMensajes() {
		
		Statement instruccion = null;
		
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		try {
			// obtiene un objeto de tipo Statement
			instruccion = conexion.createStatement();
			// ejecuta sentencia SQL
			ResultSet resultados = instruccion.executeQuery("SELECT * from mensaje");
			while (resultados.next()) {
	
			int id = resultados.getInt("id");
			int id_origen = resultados.getInt("id_origen");
			int id_destino = resultados.getInt("id_destino");
			String texto= resultados.getString("texto");
			Timestamp fecha = resultados.getTimestamp("fecha");
			
			Mensaje mensaje= new Mensaje(id_origen, id_destino, texto, fecha);
			mensaje.setId(id);
			mensajes.add(mensaje);
			}
			// cierra la sentencia
			instruccion.close();
			return mensajes;
			
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
	
	
	public Mensaje getMensaje(int id) {
		
		Mensaje mensaje= null;
		PreparedStatement instruccion = null;
	
		try {
		
			String query = "SELECT * FROM `mensaje` WHERE id=?";
			instruccion = conexion.prepareStatement(query);
			instruccion.setInt(1, id);
			
			ResultSet resultados = instruccion.executeQuery();
			
			if(resultados.next()) {
				mensaje = new Mensaje();
				mensaje.setId_origen(resultados.getInt("id_origen"));
				mensaje.setId_destino(resultados.getInt("id_destino"));
				mensaje.setTexto(resultados.getString("texto"));
				mensaje.setFecha(resultados.getTimestamp("fecha"));
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
		
			return mensaje;
		}
	
	
	public boolean nuevoMensaje(Mensaje mensaje) {
		
	PreparedStatement instruccion = null;
	
	try {
		

		instruccion = conexion.prepareStatement("INSERT INTO mensaje(id_origen, id_destino, texto, fecha) VALUES (?,?,?,?)");
		
		instruccion.setInt(1, mensaje.getId_origen());
		instruccion.setInt(2, mensaje.getId_destino());
		instruccion.setString(3, mensaje.getTexto());
		instruccion.setTimestamp(4, mensaje.getFecha());

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

	
	public boolean updateMensaje(Mensaje mensaje) {
		
	
		PreparedStatement instruccion = null;
		
		try {
			
			instruccion = conexion.prepareStatement("UPDATE `mensaje` SET id_origen= ?,id_destino= ?,texto= ?, fecha= ? WHERE id=?");
			
			instruccion.setInt(1, mensaje.getId_origen());
			instruccion.setInt(2, mensaje.getId_destino());
			instruccion.setString(3, mensaje.getTexto());
			instruccion.setTimestamp(4, mensaje.getFecha());
			instruccion.setInt(5, mensaje.getId());
	
			int filasActualizadas = instruccion.executeUpdate();			
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


	public boolean deleteMensaje(int id) {
		
		
		PreparedStatement instruccion = null;
		
		try {
			

			instruccion = conexion.prepareStatement("DELETE FROM `mensaje` WHERE id = ?");
			
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
