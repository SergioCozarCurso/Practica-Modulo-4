package app.curso.banco.main;


import java.sql.SQLException;
import java.util.Scanner;

import app.curso.banco.db.*;


import app.curso.banco.util.utiles;
import app.curso.banco.tests.*;

public class ConsolaBanco {
	
	// inicializa la base de datos
		static DatabaseGestor databaseGestor = new DatabaseGestor();
		static DatabaseCliente databaseCliente = new DatabaseCliente();
		static DatabaseMensaje databaseMensaje = new DatabaseMensaje();
		static DatabaseTransferencia databaseTransferencia= new DatabaseTransferencia();
	


	public static void main(String[] args) throws SQLException {
		

		Scanner keyboard = new Scanner(System.in);
		int opcion = 0;
		
		do {
			
			for(int i = 0; i<27; i++) {	
				System.out.println(utiles.MENU[i]);
			}
			
			opcion = keyboard.nextInt();
						
			switch(opcion) {
			
			case 1:	
				TestsGestor.obtenerGestores(databaseGestor);
			break;
			
			case 2:
				int id_gestor = 1;
				TestsGestor.obtenerGestor(databaseGestor, id_gestor);
			break;
			
			case 3:
				String usuario = "gestor1";
				String password = "1234";
				String mail = "gestor1@email.com";
				TestsGestor.insertarGestor(databaseGestor, usuario, password, mail);
			break;
				
			case 4:
				int id_gestorUpdate = 1;
				String usuarioUpdate = "gestor1";
				String passwordUpdate = "1234";
				String mailUpdate = "gestor1@email.com";
				TestsGestor.updateGestor(databaseGestor, id_gestorUpdate, usuarioUpdate, passwordUpdate, mailUpdate);
			break;
			
			case 5:
				int id_gestorDelete = 1;
				TestsGestor.deleteGestor(databaseGestor, id_gestorDelete);
			break;
			
			case 6:
				TestsCliente.obtenerClientes(databaseCliente);
			break;
				
			case 7:
				int id_cliente = 1;
				TestsCliente.obtenerCliente(databaseCliente, id_cliente);
			break;
				
			case 8:
				int id_gestorCliente = 1;
				String usuario2 = "cliente1";
				String password2 = "1234";
				String mail2 = "cliente1@email.com";
				Double saldo = 30.0;
				TestsCliente.insertarCliente(databaseCliente, id_gestorCliente, usuario2, password2, mail2, saldo);
			break;
				
			case 9:
				int id_clienteUpdate = 1;
				int id_gestorClienteUpdate = 1;
				String usuario2Update = "clienteUpdate";
				String password2Update = "12345";
				String mail2Update = "clienteUpdate@email.com";
				Double saldoUpdate = 40.0;
				TestsCliente.updateCliente(databaseCliente, id_clienteUpdate, id_gestorClienteUpdate, usuario2Update, password2Update, mail2Update, saldoUpdate);
			break;
				
			case 10:
				int id_clienteDelete = 1;
				TestsCliente.deleteCliente(databaseCliente, id_clienteDelete);
			break;
			
			case 11:
				TestsMensaje.obtenerMensajes(databaseMensaje);
			break;
				
			case 12:
				int id_mensaje = 1;
				TestsMensaje.obtenerMensaje(databaseMensaje, id_mensaje);
			break;
				
			case 13:
				int id_origen = 1;
				int id_destino = 1;
				String texto = "Hola, prueba de crear un nuevo mensaje";
				TestsMensaje.nuevoMensaje(databaseMensaje, id_origen, id_destino, texto);
			break;
				
			case 14:
				int id = 1;
				int id_origenUpdate = 1;
				int id_destinoUpdate = 1;
				String textoUpdate = "Hola, prueba de crear un nuevo mensaje2";
				TestsMensaje.updateMensaje(databaseMensaje, id, id_origenUpdate, id_destinoUpdate, textoUpdate);
			break;
				
			case 15:
				int id_MensajeDelete = 1;
				TestsMensaje.deleteMensaje(databaseMensaje, id_MensajeDelete);
			break;
			
			case 16:
				TestsTransferencia.obtenerTransferencias(databaseTransferencia);
			break;
				
			case 17:
				int id_transferencia = 1;
				TestsTransferencia.obtenerTransferencia(databaseTransferencia, id_transferencia);
			break;
				
			case 18:
				int id_ordenante = 1;
				int id_beneficiario = 1;
				double importe = 2000;
				String concepto = "Concepto";
				TestsTransferencia.nuevaTransferencia(databaseTransferencia, id_ordenante, id_beneficiario, importe, concepto);
			break;
				
			case 19:
				int id2 = 1;
				int id_ordenanteUpdate = 1;
				int id_beneficiarioUpdate = 1;
				double importeUpdate = 2000;
				String conceptoUpdate = "Concepto Update";
				TestsTransferencia.updateTransferencia(databaseTransferencia, id2, id_ordenanteUpdate, id_beneficiarioUpdate, importeUpdate, conceptoUpdate);
			break;
				
			case 20:
				int id_transferenciaDelete = 1;
				TestsTransferencia.deleteTransferencia(databaseTransferencia, id_transferenciaDelete);
			break;
			
			case 21:
				System.out.println("Programa finalizado");
			break;
			
			
			default:
				System.out.println("ERROR: Debes pulsar un número entre el 1 y el 21.");
			}	
			
			if(opcion != 21) {
				
				System.out.println("\nPulsa x para continuar");
				
				String readString = keyboard.next();
				
				while(!readString.equals("x")) {
					readString = keyboard.next();		        
				}
			}
			
			}while (opcion != 21);		 
	}
	
	
	
		
		
	
	
}
