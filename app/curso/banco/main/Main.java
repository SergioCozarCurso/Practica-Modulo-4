package app.curso.banco.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.curso.banco.db.DatabaseCliente;
import app.curso.banco.db.DatabaseGestor;
import app.curso.banco.entidad.Cliente;
import app.curso.banco.entidad.Gestor;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		// inicializa la base de datos
		DatabaseGestor databaseGestor = new DatabaseGestor();
		DatabaseCliente databaseCliente = new DatabaseCliente();
		
		// GESTORES:
		
		ArrayList<Gestor> gestores = null;
		
		// obtiene los gestores
		//gestores = obtenerGestores(databaseGestor);
		
		// obtiene un gestor
		//obtenerGestor(databaseGestor, 1);
		
		// inserta un gestor
		//insertarGestor(databaseGestor, "gestor1", "1234", "gestor1@email.com");
		
		// actualiza un gestor
		//updateGestor(databaseGestor, 1, "gestor4", "12345", "gestor4@email.com");
		
		// elimina un gestor
		//deleteGestor(databaseGestor, 2);
		
		//-----------------------------------------------------------------------------------
		
		// CLIENTES:
		ArrayList<Cliente> clientes = null;
		

		// obtiene los clientes
		//obtenerClientes(databaseCliente);
		
		// obtiene un cliente
		//obtenerCliente(databaseCliente, 1);
		
		// inserta un cliente
		//insertarCliente(databaseCliente, 1, "cliente2", "1234", "cliente2@email.com", 30.0);
		
		// actualiza un cliente
		//updateCliente(databaseCliente, 1, 1, "clienteUpdate", "12345", "clienteUpdate@email.com", 30.1);
		
		// elimina un cliente
		//deleteCliente(databaseCliente, 2);
	}
	
	
	//GESTORES:
	
	// Read gestores
	private static ArrayList<Gestor> obtenerGestores(DatabaseGestor database) {
		
		ArrayList<Gestor> gestores = database.getGestores();
		
		if(gestores == null) {
			System.out.println("No hay gestores o no se puedieron obtener");
			return null;
		}
		
		
		gestores.forEach((gestor) -> {
			System.out.println("Id: "+ gestor.getId());
			System.out.println("Usuario: "+ gestor.getUsuario());
			System.out.println("Password: "+ gestor.getPassword());
			System.out.println("Correo: "+ gestor.getCorreo());
		});
		
		return gestores;
	
	}
	
	
	// Read gestor
	private static Gestor obtenerGestor(DatabaseGestor database, int id) throws SQLException {
		
		Gestor gestor = database.getGestor(id);
		
		if(gestor == null) {
			System.out.println("No se pudo obtener ningún gestor");
			return null;
		}
		
		
		System.out.println("Id: " + gestor.getId());
		System.out.println("Usuario: " + gestor.getUsuario());
		System.out.println("Password: " + gestor.getPassword());
		System.out.println("Correo: " + gestor.getCorreo());
		System.out.println("...");
		
		
		return gestor;
		
	}
	
	
	// Create gestor
	private static boolean insertarGestor(DatabaseGestor database, String usuario, String password, String correo) {
		
		Gestor gestor = new Gestor(usuario, password, correo);
		boolean insertado = database.insertarGestor(gestor);
		
		if(insertado == true) {			
			System.out.println("Gestor ingresado correctamente");
		}else {
			System.out.println("No se pudo crear el gestor");			
		}
		
		return insertado;
	}
	
	
	// Update gestor
	private static boolean updateGestor(DatabaseGestor database, int id, String usuario, String password, String correo) {
		
		Gestor gestor = new Gestor(usuario, password, correo);
		gestor.setId(id);
		boolean insertado = database.updateGestor(gestor);
		
		if(insertado == true) {
			System.out.println("Gestor actualizado correctamente");
		}else {
			System.out.println("No se pudo actualizar el gestor");			
		}
		
		return insertado;
	}
	
	
	// Delete gestor
	private static boolean deleteGestor(DatabaseGestor database, int id) {
		
		boolean borrado = database.deleteGestor(id);
		
		if(borrado == true) {			
			System.out.println("Gestor borrado correctamente");
		}else {
			System.out.println("No se pudo borrar el gestor");			
		}
		
		return borrado;
	}
	//------------------------------------------------------------------------------------------------------------------------------
	
	
	
	// CLIENTES:

	// Read CLIENTES
	private static ArrayList<Cliente> obtenerClientes(DatabaseCliente database) {
		
		ArrayList<Cliente> clientes = database.getClientes();
		
		
		clientes.forEach((gestor) -> {
			System.out.println("Id: "+ gestor.getId());
			System.out.println("Id_gestor: "+ gestor.getId_gestor());
			System.out.println("Usuario: "+ gestor.getUsuario());
			System.out.println("Password: "+ gestor.getPassword());
			System.out.println("Correo: "+ gestor.getCorreo());
			System.out.println("Saldo: "+ gestor.getSaldo());
		});
		
		return clientes;
	
	}
	
	
	// Read cliente
	private static Cliente obtenerCliente(DatabaseCliente database, int id) throws SQLException {
		
		Cliente cliente = database.getCliente(id);
		
		if(cliente ==null) {
			System.out.println("No existe ese cliente");
			return null;
		}
		
		System.out.println("Id: " + cliente.getId());
		System.out.println("Id_gestor: " + cliente.getId_gestor());
		System.out.println("Usuario: " + cliente.getUsuario());
		System.out.println("Password: " + cliente.getPassword());
		System.out.println("Correo: " + cliente.getCorreo());
		System.out.println("Saldo: " + cliente.getSaldo());
		System.out.println("...");
		
		
		return cliente;
		
	}
	
	
	// Create cliente
	private static boolean insertarCliente(DatabaseCliente database,int id_gestor, String usuario, String password, String correo, Double saldo) {
		
		Cliente cliente = new Cliente(id_gestor, usuario, password, correo, saldo);
		boolean insertado = database.insertarCliente(cliente);
		
		if(insertado == true) {			
			System.out.println("Cliente ingresado correctamente");
		}else {
			System.out.println("No se pudo crear el cliente");			
		}
		
		return insertado;
	}
	
	
	// Update cliente
	private static boolean updateCliente(DatabaseCliente database, int id, int id_gestor, String usuario, String password, String correo, Double saldo) {
		
		Cliente cliente = new Cliente(id_gestor, usuario, password, correo, saldo);
		cliente.setId(id);
		boolean insertado = database.updateCliente(cliente);
		
		if(insertado == true) {
			System.out.println("Cliente actualizado correctamente");
		}else {
			System.out.println("No se pudo actualizar el cliente");			
		}
		
		return insertado;
	}
	
	// Delete cliente
	private static boolean deleteCliente(DatabaseCliente database, int id) {
		
		boolean borrado = database.deleteCliente(id);
		
		if(borrado == true) {			
			System.out.println("Cliente borrado correctamente");
		}else {
			System.out.println("No se pudo borrar el cliente");			
		}
		
		return borrado;
	}

	
	
	
	
}