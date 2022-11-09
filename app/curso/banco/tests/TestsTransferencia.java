package app.curso.banco.tests;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import app.curso.banco.db.DatabaseTransferencia;
import app.curso.banco.entidad.Transferencia;

public class TestsTransferencia {

	public TestsTransferencia() {
		
	}
	
	
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
