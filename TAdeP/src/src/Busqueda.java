package src;

public abstract class Busqueda<T> {
	public String referencia;
	public Class<?> tipo;
	public String valor;

//	Siempre que busque un Objeto: primero busca alguna referencia y luego, si no lo encontro, por el tipo
	public T dameUnObjetoDesde(T[] collecion) throws Exception {
		for (T elemento : collecion) {
			if (this.buscasPorReferencia(elemento)) {
				return elemento;
			}
		}
		for (T elemento : collecion) {
			if (this.buscasPorTipo(elemento)) {
				return elemento;
			}
		}

		throw new Exception("No se encontro referencia para: "
				+ this.getValor());

	}

	public  boolean buscasPorTipo(T elemento) {
		return false;
	}

	public  boolean buscasPorReferencia(T elemento) {
		return false;
	}

	// getters & setters

	public Object getReferencia() {
		return referencia;
	}

	public void setReferencia(String valor) {
		this.referencia = valor;
	}

	public Class<?> getTipo() {
		return tipo;
	}

	public void setTipo(Class<?> tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
