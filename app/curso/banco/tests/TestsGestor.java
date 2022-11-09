package app.curso.banco.tests;

import java.sql.SQLException;
import java.util.ArrayList;

import app.curso.banco.db.DatabaseGestor;
import app.curso.banco.entidad.Gestor;

public class TestsGestor {

	public TestsGestor() {
		
	}
	
	
	
	
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

}
