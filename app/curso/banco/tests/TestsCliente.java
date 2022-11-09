package app.curso.banco.tests;

import java.sql.SQLException;
import java.util.ArrayList;

import app.curso.banco.db.DatabaseCliente;
import app.curso.banco.entidad.Cliente;

public class TestsCliente {

	public TestsCliente() {
		
	}
	
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

}
