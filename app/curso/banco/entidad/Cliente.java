package app.curso.banco.entidad;


public class Cliente{
	
	
	private int id;
	private int id_gestor;
	private char usuario;
	private char password;
	private char correo;
	private double saldo;
	
	public Cliente() {
		
	}
	
	public Cliente(int id_gestor, char usuario, char password, char correo, double saldo) {
		this.id_gestor = id_gestor;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.saldo = saldo;
	}
	
	public int getId_gestor() {
		return id_gestor;
	}

	public void setId_gestor(int id_gestor) {
		this.id_gestor = id_gestor;
	}

	public char getUsuario() {
		return usuario;
	}

	public void setUsuario(char usuario) {
		this.usuario = usuario;
	}

	public char getPassword() {
		return password;
	}

	public void setPassword(char password) {
		this.password = password;
	}

	public char getCorreo() {
		return correo;
	}

	public void setCorreo(char correo) {
		this.correo = correo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}
	
}
