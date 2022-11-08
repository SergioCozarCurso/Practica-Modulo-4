package app.curso.banco.entidad;

public class Transferencia{
	

	private float dinero;

	public Transferencia() {

	}
	
	public Transferencia(int id, char tipoEmisor, int idEmisor, char tipoReceptor, int idReceptor, String textoMensaje, float dinero) {
		
	}
	

	public float getDinero() {
		return dinero;
	}
	
	public void setDinero(float dinero) {
		this.dinero = dinero;
	}
	
	public String toString() {
		
		String texto = super.toString();
		texto += ". Dinero transferido: " + this.dinero + "€";
		
		return texto;
	}
}
