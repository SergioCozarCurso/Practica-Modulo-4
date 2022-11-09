package app.curso.banco.main;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import app.curso.banco.db.DatabaseCliente;
import app.curso.banco.db.DatabaseGestor;
import app.curso.banco.db.DatabaseMensaje;
import app.curso.banco.db.DatabaseTransferencia;
import app.curso.banco.entidad.Cliente;
import app.curso.banco.entidad.Gestor;
import app.curso.banco.entidad.Mensaje;
import app.curso.banco.entidad.Transferencia;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		// inicializa la base de datos
		DatabaseGestor databaseGestor = new DatabaseGestor();
		DatabaseCliente databaseCliente = new DatabaseCliente();
		DatabaseMensaje databaseMensaje = new DatabaseMensaje();
		DatabaseTransferencia databaseTransferencia= new DatabaseTransferencia();
		
		
		// GESTORES:
				
		// Obtiene los gestores
		//obtenerGestores(databaseGestor);
		
		// Obtiene un gestor
		//obtenerGestor(databaseGestor, 1);
		
		// Inserta un gestor
		//insertarGestor(databaseGestor, "gestor1", "1234", "gestor1@email.com");
		
		// Actualiza un gestor
		//updateGestor(databaseGestor, 1, "gestor4", "12345", "gestor4@email.com");
		
		// Elimina un gestor
		//deleteGestor(databaseGestor, 2);
		
		//-----------------------------------------------------------------------------------
		
		
		// CLIENTES:	

		// Obtiene los clientes
		//obtenerClientes(databaseCliente);
		
		// Obtiene un cliente
		//obtenerCliente(databaseCliente, 1);
		
		// Inserta un cliente
		//insertarCliente(databaseCliente, 1, "cliente2", "1234", "cliente2@email.com", 30.0);
		
		// Actualiza un cliente
		//updateCliente(databaseCliente, 1, 1, "clienteUpdate", "12345", "clienteUpdate@email.com", 30.1);
		
		// Elimina un cliente
		//deleteCliente(databaseCliente, 2);
		
		//-----------------------------------------------------------------------------------
		
		
		// MENSAJES:
		
		// Obtiene los mensajes
		//obtenerMensajes(databaseMensaje);
		
		// Obtiene un mensaje
		//obtenerMensaje(databaseMensaje, 2);
		
		// Nuevo mensaje
		//String texto = "Hola, prueba de crear un nuevo mensaje";
		//nuevoMensaje(databaseMensaje, 1, 1, texto);
		
		// Actualiza un mensaje
		//String textoUpdate = "Hola, prueba de crear un nuevo mensaje2";
		//updateMensaje(databaseMensaje, 1, 1, 1, textoUpdate);
		
		// Elimina un mensaje
		//deleteMensaje(databaseMensaje, 2);

		//-----------------------------------------------------------------------------------
		
		
		// TRANSFERENCIAS:
		
		// Obtiene las transferencias
		//obtenerTransferencias(databaseTransferencia);
		
		// Obtiene una transferencia
		//obtenerTransferencia(databaseTransferencia, 1);
		
		// Nueva transferencia
		//String concepto = "Hola, prueba de crear un nuevo mensaje";
		//nuevaTransferencia(databaseTransferencia, 1, 1, 2000, concepto);
		
		// Actualiza una transferencia
		//String conceptoUpdate = "Hola, prueba de crear un nuevo mensaje2";
		//updateTransferencia(databaseTransferencia, 1, 5, 1, 3000, conceptoUpdate);
		
		// Elimina una transferencia
		//deleteTransferencia(databaseTransferencia, 1);
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
		
		if(clientes == null) {
			System.out.println("No hay clientes o no se puedieron obtener");
			return null;
		}
		
		
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

	// ----------------------------------------------------------------------------------------------------------------------------------
	

	// MENSAJES:

	// Read MENSAJES
	private static ArrayList<Mensaje> obtenerMensajes(DatabaseMensaje database) {
		
		ArrayList<Mensaje> mensajes = database.getMensajes();
		
		if(mensajes == null) {
			System.out.println("No hay mensajes o no se puedieron obtener");
			return null;
		}
		
		
		mensajes.forEach((mensaje) -> {
			System.out.println("Id: "+ mensaje.getId());
			System.out.println("Id_origen: "+ mensaje.getId_origen());
			System.out.println("Id_destino: "+ mensaje.getId_destino());
			System.out.println("Texto: "+ mensaje.getTexto());
			System.out.println("Fecha: "+ mensaje.getFecha());
		});
		
		return mensajes;
	
	}
	
	
	// Read mensaje
	private static Mensaje obtenerMensaje(DatabaseMensaje database, int id) throws SQLException {
		
		Mensaje mensaje= database.getMensaje(id);
		
		if(mensaje ==null) {
			System.out.println("No existe ese mensaje");
			return null;
		}
		
		System.out.println("Id: "+ mensaje.getId());
		System.out.println("Id_origen: "+ mensaje.getId_origen());
		System.out.println("Id_destino: "+ mensaje.getId_destino());
		System.out.println("Texto: "+ mensaje.getTexto());
		System.out.println("Fecha: "+ mensaje.getFecha());
		
		
		return mensaje;
		
	}
	
	
	// Create mensaje
	private static boolean nuevoMensaje(DatabaseMensaje database, int id_origen, int id_destino, String texto) {
		
		
		long ms = new java.util.Date().getTime();
		Timestamp datetime = new Timestamp(ms);
				
		
		Mensaje mensaje= new Mensaje(id_origen, id_destino, texto, datetime);
		boolean insertado = database.nuevoMensaje(mensaje);
		
		if(insertado == true) {			
			System.out.println("Mensaje creado correctamente");
		}else {
			System.out.println("No se pudo crear el mensaje");			
		}
		
		return insertado;
	}
	
	
	// Update mensaje
	private static boolean updateMensaje(DatabaseMensaje database, int id, int id_origen, int id_destino, String texto) {
		
		long ms = new java.util.Date().getTime();
		Timestamp datetime = new Timestamp(ms);
		
		Mensaje mensaje= new Mensaje(id_origen, id_destino, texto, datetime);
		mensaje.setId(id);
		boolean insertado = database.updateMensaje(mensaje);
		
		if(insertado == true) {
			System.out.println("Mensaje actualizado correctamente");
		}else {
			System.out.println("No se pudo actualizar el mensaje");			
		}
		
		return insertado;
	}
	
	// Delete mensaje
	private static boolean deleteMensaje(DatabaseMensaje database, int id) {
		
		boolean borrado = database.deleteMensaje(id);
		
		if(borrado == true) {			
			System.out.println("Mensaje borrado correctamente");
		}else {
			System.out.println("No se pudo borrar el mensaje");			
		}
		
		return borrado;
	}

	// -------------------------------------------------------------------------------------------------------------------------------------
	
	
	// TRANSFERENCIAS:
	

	// Read transferencias
	private static ArrayList<Transferencia> obtenerTransferencias(DatabaseTransferencia database) {
		
		ArrayList<Transferencia> transferencias= database.getTransferencias();
		
		if(transferencias == null) {
			System.out.println("No hay transferencias o no se puedieron obtener");
			return null;
		}
		
		
		transferencias.forEach((transferencia) -> {
			System.out.println("Id: "+ transferencia.getId());
			System.out.println("Id_ordenante: "+ transferencia.getId_ordenante());
			System.out.println("Id_beneficiario: "+ transferencia.getId_beneficiario());
			System.out.println("Importe: "+ transferencia.getImporte());
			System.out.println("Concepto: "+ transferencia.getConcepto());
			System.out.println("Fecha: "+ transferencia.getFecha());
		});
		
		return transferencias;
	
	}
	
	
	// Read transferencia
	private static Transferencia obtenerTransferencia(DatabaseTransferencia database, int id) throws SQLException {
		
		Transferencia transferencia= database.getTransferencia(id);
		
		if(transferencia ==null) {
			System.out.println("No existe esa transferencia");
			return null;
		}
		
		System.out.println("Id: "+ transferencia.getId());
		System.out.println("Id_ordenante: "+ transferencia.getId_ordenante());
		System.out.println("Id_beneficiario: "+ transferencia.getId_beneficiario());
		System.out.println("Importe: "+ transferencia.getImporte());
		System.out.println("Concepto: "+ transferencia.getConcepto());
		System.out.println("Fecha: "+ transferencia.getFecha());
		
		
		return transferencia;
		
	}
	

	// Create transferencia
	private static boolean nuevaTransferencia(DatabaseTransferencia database, int id_ordenante, int id_beneficiario, double importe, String concepto) {
		
		
		long ms = new java.util.Date().getTime();
		Timestamp datetime = new Timestamp(ms);
				
		
		Transferencia transferencia= new Transferencia(id_ordenante, id_beneficiario, importe, concepto, datetime);
		boolean insertado = database.nuevaTransferencia(transferencia);
		
		if(insertado == true) {			
			System.out.println("Transferencia realizada correctamente");
		}else {
			System.out.println("No se pudo enviar la transferencia");			
		}
		
		return insertado;
	}
	
	
	// Update transferencia
	private static boolean updateTransferencia(DatabaseTransferencia database, int id, int id_ordenante, int id_beneficiario, double importe, String concepto) {
		
		long ms = new java.util.Date().getTime();
		Timestamp datetime = new Timestamp(ms);
		
		Transferencia transferencia= new Transferencia(id_ordenante, id_beneficiario, importe, concepto, datetime);
		transferencia.setId(id);
		boolean insertado = database.updateTransferencia(transferencia);
		
		if(insertado == true) {
			System.out.println("Transferencia actualizada correctamente");
		}else {
			System.out.println("No se pudo actualizar la transferencia");			
		}
		
		return insertado;
	}
	
	// Delete transferencia
	private static boolean deleteTransferencia(DatabaseTransferencia database, int id) {
		
		boolean borrado = database.deleteTransferencia(id);
		
		if(borrado == true) {			
			System.out.println("Transferencia borrada correctamente");
		}else {
			System.out.println("No se pudo borrar el transferencia");			
		}
		
		return borrado;
	}
	
	
}