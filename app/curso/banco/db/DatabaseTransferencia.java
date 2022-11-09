package app.curso.banco.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import app.curso.banco.entidad.Transferencia;



public class DatabaseTransferencia {

	private Connection conexion;
	
	public DatabaseTransferencia() {
		
	// conecta con la base de datos
		DatabaseConnection database = new DatabaseConnection();
		conexion = database.getConexion();
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
	
	
	public boolean nuevaTransferencia(Transferencia transferencia) {
		
	PreparedStatement instruccion = null;
	
	try {
		

		instruccion = conexion.prepareStatement("INSERT INTO transferencia(id_ordenante, id_beneficiario, importe, concepto, fecha) VALUES (?,?,?,?,?)");
		
		instruccion.setInt(1, transferencia.getId_ordenante());
		instruccion.setInt(2, transferencia.getId_beneficiario());
		instruccion.setDouble(3, transferencia.getImporte());
		instruccion.setString(4, transferencia.getConcepto());
		instruccion.setTimestamp(5, transferencia.getFecha());

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

	
	public boolean updateTransferencia(Transferencia transferencia) {
		
	
		PreparedStatement instruccion = null;
		
		try {
			
			instruccion = conexion.prepareStatement("UPDATE `transferencia` SET id_ordenante= ?,id_beneficiario= ?,importe= ?, concepto= ?, fecha= ? WHERE id=?");
			
			instruccion.setInt(1, transferencia.getId_ordenante());
			instruccion.setInt(2, transferencia.getId_beneficiario());
			instruccion.setDouble(3, transferencia.getImporte());
			instruccion.setString(4, transferencia.getConcepto());
			instruccion.setTimestamp(5, transferencia.getFecha());
			instruccion.setInt(6, transferencia.getId());
	
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


	public boolean deleteTransferencia(int id) {
		
		
		PreparedStatement instruccion = null;
		
		try {
			

			instruccion = conexion.prepareStatement("DELETE FROM `transferencia` WHERE id = ?");
			
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
