package app.curso.banco.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import app.curso.banco.entidad.Cliente;
import app.curso.banco.entidad.Gestor;

public class DatabaseCliente {

	private Connection conexion;
	
	public DatabaseCliente() {
	try {
	// conecta con la base de datos
	conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "");
	} catch (SQLException e) {
	e.printStackTrace();
	}
}
	
	public ArrayList<Cliente> getClientes() {
		
		Statement instruccion = null;
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			// obtiene un objeto de tipo Statement
			instruccion = conexion.createStatement();
			// ejecuta sentencia SQL
			ResultSet resultados = instruccion.executeQuery("SELECT * from cliente");
			while (resultados.next()) {
			int id = resultados.getInt("id");
			int id_gestor = resultados.getInt("id_gestor");
			String usuario = resultados.getString("usuario");
			String password = resultados.getString("password");
			String correo = resultados.getString("correo");
			int saldo = resultados.getInt("saldo");
			
			Cliente cliente = new Cliente(id_gestor, usuario, password, correo, saldo);
			cliente.setId(id);
			clientes.add(cliente);
			}
			// cierra la sentencia
			instruccion.close();
			return clientes;
			
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
	
	
	public Cliente getCliente(int id) {
		
		Cliente cliente = null;
		PreparedStatement instruccion = null;
	
		try {
		
			String query = "SELECT * FROM `cliente` WHERE id=?";
			instruccion = conexion.prepareStatement(query);
			instruccion.setInt(1, id);
			
			ResultSet resultados = instruccion.executeQuery();
			
			if(resultados.next()) {
				cliente = new Cliente();
				cliente.setId(resultados.getInt("id"));
				cliente.setId_gestor(resultados.getInt("id_gestor"));
				cliente.setUsuario(resultados.getString("usuario"));
				cliente.setPassword(resultados.getString("password"));
				cliente.setCorreo(resultados.getString("correo"));
				cliente.setSaldo(resultados.getInt("saldo"));
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
		
			return cliente;
		}
	
	
	public boolean insertarCliente(Cliente cliente) {
		
	PreparedStatement instruccion = null;
	
	try {
		

		instruccion = conexion.prepareStatement("INSERT INTO cliente(id_gestor, usuario, password, correo, saldo) VALUES (?,?,?,?,?)");
		
		instruccion.setInt(1, cliente.getId_gestor());
		
		instruccion.setString(2, cliente.getUsuario());

		instruccion.setString(3, cliente.getPassword());

		instruccion.setString(4, cliente.getCorreo());
		
		instruccion.setDouble(5, cliente.getSaldo());
		
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

	
	public boolean updateCliente(Cliente cliente) {
		
	
		PreparedStatement instruccion = null;
		
		try {
			
			instruccion = conexion.prepareStatement("UPDATE `cliente` SET id_gestor =?, usuario= ?,password= ?,correo= ?, saldo=? WHERE id=?");
			
			instruccion.setInt(1, cliente.getId_gestor());
			
			instruccion.setString(2, cliente.getUsuario());
			
			instruccion.setString(3, cliente.getPassword());
	
			instruccion.setString(4, cliente.getCorreo());
			
			instruccion.setDouble(5, cliente.getSaldo());
			
			instruccion.setDouble(6, cliente.getId());
			
	
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


	public boolean deleteCliente(int id) {
		
		
		PreparedStatement instruccion = null;
		
		try {
			

			instruccion = conexion.prepareStatement("DELETE FROM `cliente` WHERE id = ?");
			
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
