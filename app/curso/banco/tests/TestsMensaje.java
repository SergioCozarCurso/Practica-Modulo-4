package app.curso.banco.tests;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import app.curso.banco.db.DatabaseMensaje;
import app.curso.banco.entidad.Mensaje;

public class TestsMensaje {

	public TestsMensaje() {
		
	}
	

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

}
