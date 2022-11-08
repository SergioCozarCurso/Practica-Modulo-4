package app.curso.banco.entidad;

import java.sql.Date;
import java.sql.Timestamp;

public class Mensaje {
	
	
	protected int id;
	protected int id_origen;
	protected int id_destino;
	protected String texto;
	protected Timestamp fecha;

	

	public Mensaje() {
		
	}
	
	public Mensaje(int id_origen, int id_destino, String texto, Timestamp fecha) {
		
		this.id_origen = id_origen;
		this.id_destino = id_destino;
		this.texto = texto;
		this.fecha = fecha;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_origen() {
		return id_origen;
	}

	public void setId_origen(int id_origen) {
		this.id_origen = id_origen;
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	

}
