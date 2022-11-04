package app.curso.banco.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Apuntes {

	public static void main(String[] args) {
		
		Statement instruccionStatement = null;
		ResultSet resultados = null;
		Connection conexion = null;
		
		try {
		
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "123Code.");
				
					
				//__________________________________________________________________________________//
				
				// INSTRUCCIONES NO SEGURAS, CON QUERY EN DURO
				
					// 1.1. Insert gestor método --> execute
					//insertGestor(conexion, "execute",       "gestor2", "123", "gestor1@correo.com");
					
					// 1.2. Insert gestor método --> executeUpdate
					//insertGestor(conexion, "executeUpdate", "gestor3", "123", "gestor1@correo.com");
					
					// 2.1 Select All Gestores, método --> executeQuery
					//selectAllGestores(conexion, "executeQuery");	
				
					// 2.1 Select All Gestores, método --> execute
					//selectAllGestores(conexion, "execute");		
				
				
				// INSTRUCCIONES SEGURAS, CON INSTRUCCIONES PREPARADAS
				
					// 1. Insert gestor - Usaremos PreparedStatement, no Statement, etc. Ver en método.
					//insertGestorInstruccionesSeparadas(conexion, "gestor1", "123", "gestor1@correo.com");
				
					// 2. Select Gestores - Instrucciones Preparadas
					selectGestoresInstruccionesPreparadas(conexion);
				

					
				
			} catch (SQLException e) {
			e.printStackTrace();
			}finally {
				try {
						// libera los resultados
						if (resultados != null) {
						resultados.close();
						}
						// libera la instrucción
						if (instruccionStatement != null) {
							instruccionStatement.close();
						}
						// libera la conexión
						if (conexion != null) {
						conexion.close();
						}
		
					}catch (Exception e) {
						e.printStackTrace();
					}
			}

		}
	

	
	
	// Sistema no seguro, usando las querys escritas en duro, es vulnerable
	private static void insertGestor(Connection conexion, String metodo, String usuario, String password, String correo) throws SQLException {
		
		// obtención de un objeto de tipo Statement
		Statement instruccion = conexion.createStatement();
		
		
		// construir sentencia SQL
		String insert = "INSERT INTO gestor (usuario, password, correo) VALUES ('"+usuario+"', '"+password+"', '"+correo+"')";
		
		// Éste método es mejor porque te actualiza la DB.
		if(metodo == "executeUpdate") {
			// 2. ejecutar instrucción con el método EXECUTEUPDATE
			int registrosInsertados = instruccion.executeUpdate(insert);
			// mostrar el número de registros insertados
			System.out.println("Registros insertados: " + registrosInsertados);
		}
				
		
		if(metodo == "execute") {
			// 1. Ejecutar instrucción con el método EXECUTE
			boolean resultado = instruccion.execute(insert);
			
			// si es false, entonces la instrucción no devuelve un objeto de tipo ResultSet
			// Cuando se hace un Insert, resultado será false. Si es un Select, puede ser un ResultSet.
			if (!resultado) {
				// mostrar el número de registros insertados
				System.out.println("Registros insertados: " + instruccion.getUpdateCount() + "\n\n");
			}	
		}
	
	}

	private static void selectAllGestores(Connection conexion, String metodo) throws SQLException {
		
		// obtención de un objeto de tipo Statement
		Statement instruccion = conexion.createStatement();
		
		// construir sentencia SQL
		String selectTodo = "SELECT * FROM gestor";
		
		if(metodo == "executeQuery") {
			// ejecutar instrucción con el método executeQuery.
			ResultSet resultados = instruccion.executeQuery(selectTodo); // ExecuteQuery de un SELECT devuelve ResultSet
			
			System.out.println("Listado de gestores (con executeQuery): ");
			while (resultados.next()) {
				System.out.println("Gestor " + resultados.getInt("id"));
				System.out.println("Usuario: " + resultados.getString("usuario"));
				System.out.println("Password: " + resultados.getString("password"));
				System.out.println("Correo: " + resultados.getString("correo"));
				System.out.println("...");
			}
		}
		
		
		if (metodo == "execute") {
			// ejecutar instrucción con el método execute. Devuelve boolean
			boolean resultado = instruccion.execute(selectTodo);
			
			// si es true, entonces la instrucción devuelve un objeto de tipo ResultSet
			if (resultado) {
				ResultSet resultados2 = instruccion.getResultSet(); // getResultSet devuelve Result set
				
				System.out.println("Listado de gestores (con execute): ");
				while (resultados2.next()) {
					System.out.println("Gestor " + resultados2.getInt("id"));
					System.out.println("Usuario: " + resultados2.getString("usuario"));
					System.out.println("Password: " + resultados2.getString("password"));
					System.out.println("Correo: " + resultados2.getString("correo"));
					System.out.println("...");
				}
			}
		}
	}

	
	// Este es el mejor sistema, es seguro, los anteriores escribiendo la query en duro son vulnerables.
	private static void insertGestorInstruccionesSeparadas(Connection conexion, String usuario, String password, String correo) throws SQLException {
		
		
		// se inicializa la instrucción preparada, marcando los valores a sustituir con el carácter ?
		// La diferencia es que ps en vez de ser "Statement" como antes, es "PreparedStatement".
		PreparedStatement ps = conexion.prepareStatement("INSERT INTO gestor(usuario, password, correo) VALUES (?,?,?)");
		
		// se sustituye la primera aparición del carácter ? con el valor de usuario
		ps.setString(1, "'"+usuario+"'");
		
		// se sustituye la segunda aparición del carácter ? con el valor de password
		ps.setString(2, "'"+password+"'");
		
		// se sustituye la tercera aparición del carácter ? con el valor de correo
		ps.setString(3, "'"+correo+"'");
		
		// se ejecuta la instrucción SQL siguiente:
		// INSERT INTO gestor(usuario, password, correo) VALUES ('gestor10', 'gestor10','gestor10@correo.com')
		if (ps.executeUpdate() != 1) {
		throw new SQLException("Error en la Inserción");
		}
		System.out.println("Programa finalizado, gestor insertado correctamente");
		
		
	}

	private static void selectGestoresInstruccionesPreparadas(Connection conexion) throws SQLException {
		
		// se inicializa la instrucción preparada, marcando los valores a sustituir con el carácter ?
		PreparedStatement ps = conexion.prepareStatement("SELECT * from gestor WHERE id IN (?,?)");
		// se sustituye la primera aparición del carácter ? con el valor 3
		ps.setInt(1, 3);
		// se sustituye la segunda aparición del carácter ? con el valor 4
		ps.setInt(2, 4);
		// se ejecuta la instrucción SQL siguiente:
		// SELECT * from gestor WHERE id IN (3,4)
		ResultSet resultados = ps.executeQuery(); // ExecuteQuery() sin parametros. No se manda la query en duro.
		System.out.println("Listado de gestores: ");
		while (resultados.next()) {
		System.out.println("Gestor " + resultados.getInt("id"));
		System.out.println("Usuario: " + resultados.getString("usuario"));
		System.out.println("Password: " + resultados.getString("password"));
		System.out.println("Correo: " + resultados.getString("correo"));
		System.out.println("...");
		}

	}

}
