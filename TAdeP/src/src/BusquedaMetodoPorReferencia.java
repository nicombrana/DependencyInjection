package src;

import java.lang.reflect.Method;

public class BusquedaMetodoPorReferencia implements Busqueda {

	public ContenedorHelper valor;

	public BusquedaMetodoPorReferencia(ContenedorHelper valor) {
		this.valor = valor;
	}

	@Override
	public boolean buscasA(Method metodo) {
		return (metodo.getName().contains("set") && (metodo.getName().contains(
				this.valor.getReferencia())));
	}

	@Override
	public Object getValor() {
		return valor;
	}

	public void setValor(ContenedorHelper valor) {
		this.valor = valor;
	}

	@Override
	public boolean buscasA(ContenedorHelper helper) {
		// TODO Auto-generated method stub
		return false;
	}

}
