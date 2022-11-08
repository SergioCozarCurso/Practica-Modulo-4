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
import app.curso.banco.entidad.Transferencia;

public class DatabaseTransferencia {

	private Connection conexion;
	
	public DatabaseTransferencia() {
	try {
	// conecta con la base de datos
	conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "");
	} catch (SQLException e) {
	e.printStackTrace();
	}
}
	
	public ArrayList<Transferencia> getTransferencias() {
		
		Statement instruccion = null;
		
		ArrayList<Transferencia> transferencias = new ArrayList<Transferencia>();
		try {
			// obtiene un objeto de tipo Statement
			instruccion = conexion.createStatement();
			// ejecuta sentencia SQL
			ResultSet resultados = instruccion.executeQuery("SELECT * from transferencia");
			while (resultados.next()) {
	
			int id = resultados.getInt("id");
			int id_ordenante = resultados.getInt("id_ordenante");
			int id_beneficiario = resultados.getInt("id_beneficiario");
			double importe = resultados.getDouble("importe");
			String concepto= resultados.getString("concepto");
			Timestamp fecha = resultados.getTimestamp("fecha");
			
			Transferencia transferencia= new Transferencia(id_ordenante, id_beneficiario, importe, concepto, fecha);
			transferencia.setId(id);
			transferencias.add(transferencia);
			}
			// cierra la sentencia
			instruccion.close();
			return transferencias;
			
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
	
	
	public Transferencia getTransferencia(int id) {
		
		Transferencia transferencia= null;
		PreparedStatement instruccion = null;
	
		try {
		
			String query = "SELECT * FROM `transferencia` WHERE id=?";
			instruccion = conexion.prepareStatement(query);
			instruccion.setInt(1, id);
			
			ResultSet resultados = instruccion.executeQuery();
			
			if(resultados.next()) {
				transferencia = new Transferencia();
				transferencia.setId(resultados.getInt(id));
				transferencia.setId_ordenante(resultados.getInt("id_ordenante"));
				transferencia.setId_beneficiario(resultados.getInt("id_beneficiario"));
				transferencia.setImporte(resultados.getDouble("importe"));
				transferencia.setConcepto(resultados.getString("concepto"));
				transferencia.setFecha(resultados.getTimestamp("fecha"));
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
		
			return transferencia;
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
