package src;

import java.lang.reflect.Method;

public class BusquedaMetodoPorTipo implements Busqueda {

	public ContenedorHelper valor;

	public BusquedaMetodoPorTipo(ContenedorHelper valor) {
		this.valor = valor;
	}

	@Override
	public boolean buscasA(Method metodo) {
		return (metodo.getName().contains("set") &&  metodo.getParameterTypes()[0]
				.equals(this.valor.getTipo()));
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
