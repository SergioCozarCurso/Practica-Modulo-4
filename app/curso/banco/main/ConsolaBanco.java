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
			
			for(int i = 0; i<26; i++) {	
				System.out.println(utiles.MENU[i]);
			}
			
			opcion = keyboard.nextInt();
						
			switch(opcion) {
			
			case 1:	
				TestsGestor.obtenerGestores(databaseGestor);
			break;
			
			case 2:
				TestsGestor.obtenerGestor(databaseGestor, 1);
			break;
			
			case 3:
				TestsGestor.insertarGestor(databaseGestor, "gestor1", "1234", "gestor1@email.com");
			break;
				
			case 4:
				TestsGestor.updateGestor(databaseGestor, 1, "gestorUpdate", "12345", "gestorUpdate@email.com");
			break;
			
			case 5:
				TestsGestor.deleteGestor(databaseGestor, 1);
			break;
			
			case 6:
				TestsCliente.obtenerClientes(databaseCliente);
			break;
				
			case 7:
				TestsCliente.obtenerCliente(databaseCliente, 1);
			break;
				
			case 8:
				TestsCliente.insertarCliente(databaseCliente, 1, "cliente1", "1234", "cliente1@email.com", 30.0);
			break;
				
			case 9:
				TestsCliente.updateCliente(databaseCliente, 1, 1, "clienteUpdate", "12345", "clienteUpdate@email.com", 30.1);
			break;
				
			case 10:
				TestsCliente.deleteCliente(databaseCliente, 1);
			break;
			
			case 11:
				TestsMensaje.obtenerMensajes(databaseMensaje);
			break;
				
			case 12:
				TestsMensaje.obtenerMensaje(databaseMensaje, 1);
			break;
				
			case 13:
				String texto = "Hola, prueba de crear un nuevo mensaje";
				TestsMensaje.nuevoMensaje(databaseMensaje, 1, 1, texto);
			break;
				
			case 14:
				String textoUpdate = "Hola, prueba de crear un nuevo mensaje2";
				TestsMensaje.updateMensaje(databaseMensaje, 1, 1, 1, textoUpdate);
			break;
				
			case 15:
				TestsMensaje.deleteMensaje(databaseMensaje, 2);
			break;
			
			case 16:
				TestsTransferencia.obtenerTransferencias(databaseTransferencia);
				break;
				
			case 17:
				TestsTransferencia.obtenerTransferencia(databaseTransferencia, 1);
				break;
				
			case 18:
				String concepto = "Concepto";
				TestsTransferencia.nuevaTransferencia(databaseTransferencia, 1, 1, 2000, concepto);
				break;
				
			case 19:
				String conceptoUpdate = "Concepto Update";
				TestsTransferencia.updateTransferencia(databaseTransferencia, 1, 1, 1, 3000, conceptoUpdate);
				break;
				
			case 20:
				TestsTransferencia.deleteTransferencia(databaseTransferencia, 1);
				break;
			
			
			default:
				System.out.println("ERROR: Debes pulsar un número entre el 1 y el 20.");
			}	
			
			
			System.out.println("\nPulsa x para continuar");
			
			String readString = keyboard.next();
			
		    while(!readString.equals("x")) {
		    	readString = keyboard.next();		        
		    }
			
			}while (opcion != 0);		 
	}
	
	
	
		
		
	
	
}
