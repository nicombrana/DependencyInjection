package src;

public class ObjetoHelper extends ContenedorHelper {

	private String referencia;
	private Object valor;
	
	public ObjetoHelper(String referencia, Class<?> tipo, Object valor) {
		this.setReferencia(referencia);
		this.setTipo(tipo);
		this.setValor(valor);
	}

	//Setters & Getters
	public String getReferencia() {
		return referencia;
	}
	
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	public Object getValor() {
		return valor;
	}
	
	public void setValor(Object valor) {
		this.valor = valor;
	}

}
