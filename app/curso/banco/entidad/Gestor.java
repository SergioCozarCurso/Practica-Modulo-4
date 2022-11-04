package app.curso.banco.entidad;

public class Gestor{
	
	private int id;
	private char usuario;
	private char password;
	private char correo;
	

	
	public Gestor() {
	}
	
	public Gestor(char usuario, char password, char correo) {
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
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
	
	public int getId() {
		return id;
	}


}
