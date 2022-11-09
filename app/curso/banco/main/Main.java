package app.curso.banco.main;


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

	}
	
	
	//GESTORES:
	
	// Read gestores
	public static ArrayList<Gestor> obtenerGestores(DatabaseGestor database) {
		
		ArrayList<Gestor> gestores = database.getGestores();
		
		if(gestores == null || gestores.size() == 0) {
			System.out.println("No hay gestores o no se puedieron obtener");
			return null;
		}
		
		
		gestores.forEach((gestor) -> {
			System.out.println("Id: "+ gestor.getId());
			System.out.println("Usuario: "+ gestor.getUsuario());
			System.out.println("Password: "+ gestor.getPassword());
			System.out.println("Correo: "+ gestor.getCorreo() + "\n");
		});
		
		return gestores;
	
	}
	
	
	// Read gestor
	public static Gestor obtenerGestor(DatabaseGestor database, int id) throws SQLException {
		
		Gestor gestor = database.getGestor(id);
		
		if(gestor == null) {
			System.out.println("No se pudo obtener ningún gestor");
			return null;
		}
		
		
		System.out.println("Id: " + id);
		System.out.println("Usuario: " + gestor.getUsuario());
		System.out.println("Password: " + gestor.getPassword());
		System.out.println("Correo: " + gestor.getCorreo());
		System.out.println("...");
		
		
		return gestor;
		
	}
	
	
	// Create gestor
	public static boolean insertarGestor(DatabaseGestor database, String usuario, String password, String correo) {
		
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
	public static boolean updateGestor(DatabaseGestor database, int id, String usuario, String password, String correo) {
		
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
	public static boolean deleteGestor(DatabaseGestor database, int id) {
		
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
	public static ArrayList<Cliente> obtenerClientes(DatabaseCliente database) {
		
		ArrayList<Cliente> clientes = database.getClientes();
		
		if(clientes == null || clientes.size() == 0) {
			System.out.println("No hay clientes o no se puedieron obtener");
			return null;
		}
		
		
		clientes.forEach((cliente) -> {
			System.out.println("Id: "+ cliente.getId());
			System.out.println("Id_gestor: "+ cliente.getId_gestor());
			System.out.println("Usuario: "+ cliente.getUsuario());
			System.out.println("Password: "+ cliente.getPassword());
			System.out.println("Correo: "+ cliente.getCorreo());
			System.out.println("Saldo: "+ cliente.getSaldo() + "\n");
		});
		
		return clientes;
	
	}
	
	
	// Read cliente
	public static Cliente obtenerCliente(DatabaseCliente database, int id) throws SQLException {
		
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
	public static boolean insertarCliente(DatabaseCliente database,int id_gestor, String usuario, String password, String correo, Double saldo) {
		
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
	public static boolean updateCliente(DatabaseCliente database, int id, int id_gestor, String usuario, String password, String correo, Double saldo) {
		
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
	public static boolean deleteCliente(DatabaseCliente database, int id) {
		
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
	public static ArrayList<Mensaje> obtenerMensajes(DatabaseMensaje database) {
		
		ArrayList<Mensaje> mensajes = database.getMensajes();
		
		if(mensajes == null || mensajes.size() == 0) {
			System.out.println("No hay mensajes o no se puedieron obtener");
			return null;
		}
		
		
		mensajes.forEach((mensaje) -> {
			System.out.println("Id: "+ mensaje.getId());
			System.out.println("Id_origen: "+ mensaje.getId_origen());
			System.out.println("Id_destino: "+ mensaje.getId_destino());
			System.out.println("Texto: "+ mensaje.getTexto());
			System.out.println("Fecha: "+ mensaje.getFecha() + "\n");
		});
		
		return mensajes;
	
	}
	
	
	// Read mensaje
	public static Mensaje obtenerMensaje(DatabaseMensaje database, int id) throws SQLException {
		
		Mensaje mensaje= database.getMensaje(id);
		
		if(mensaje ==null) {
			System.out.println("No existe ese mensaje");
			return null;
		}
		
		System.out.println("Id: "+ id);
		System.out.println("Id_origen: "+ mensaje.getId_origen());
		System.out.println("Id_destino: "+ mensaje.getId_destino());
		System.out.println("Texto: "+ mensaje.getTexto());
		System.out.println("Fecha: "+ mensaje.getFecha());
		
		
		return mensaje;
		
	}
	
	
	// Create mensaje
	public static boolean nuevoMensaje(DatabaseMensaje database, int id_origen, int id_destino, String texto) {
		
		
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
	public static boolean updateMensaje(DatabaseMensaje database, int id, int id_origen, int id_destino, String texto) {
		
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
	public static boolean deleteMensaje(DatabaseMensaje database, int id) {
		
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
	public static ArrayList<Transferencia> obtenerTransferencias(DatabaseTransferencia database) {
		
		ArrayList<Transferencia> transferencias= database.getTransferencias();
		
		if(transferencias == null || transferencias.size() == 0) {
			System.out.println("No hay transferencias o no se puedieron obtener");
			return null;
		}
		
		
		transferencias.forEach((transferencia) -> {
			System.out.println("Id: "+ transferencia.getId());
			System.out.println("Id_ordenante: "+ transferencia.getId_ordenante());
			System.out.println("Id_beneficiario: "+ transferencia.getId_beneficiario());
			System.out.println("Importe: "+ transferencia.getImporte());
			System.out.println("Concepto: "+ transferencia.getConcepto());
			System.out.println("Fecha: "+ transferencia.getFecha() + "\n");
		});
		
		return transferencias;
	
	}
	
	
	// Read transferencia
	public static Transferencia obtenerTransferencia(DatabaseTransferencia database, int id) throws SQLException {
		
		Transferencia transferencia= database.getTransferencia(id);
		
		if(transferencia ==null) {
			System.out.println("No existe esa transferencia");
			return null;
		}
		
		System.out.println("Id: "+ id);
		System.out.println("Id_ordenante: "+ transferencia.getId_ordenante());
		System.out.println("Id_beneficiario: "+ transferencia.getId_beneficiario());
		System.out.println("Importe: "+ transferencia.getImporte());
		System.out.println("Concepto: "+ transferencia.getConcepto());
		System.out.println("Fecha: "+ transferencia.getFecha());
		
		
		return transferencia;
		
	}
	

	// Create transferencia
	public static boolean nuevaTransferencia(DatabaseTransferencia database, int id_ordenante, int id_beneficiario, double importe, String concepto) {
		
		
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
	public static boolean updateTransferencia(DatabaseTransferencia database, int id, int id_ordenante, int id_beneficiario, double importe, String concepto) {
		
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
	public static boolean deleteTransferencia(DatabaseTransferencia database, int id) {
		
		boolean borrado = database.deleteTransferencia(id);
		
		if(borrado == true) {			
			System.out.println("Transferencia borrada correctamente");
		}else {
			System.out.println("No se pudo borrar el transferencia");			
		}
		
		return borrado;
	}
	
	
}