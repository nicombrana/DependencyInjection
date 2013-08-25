package src;

import java.lang.reflect.Method;

public class BusquedaHelperPorTipo implements Busqueda {

	public Class<?> valor;
	

	public BusquedaHelperPorTipo(Class<?> valor) {
		this.valor = valor;
	}

	@Override
	public boolean buscasA(ContenedorHelper helper) {
		return (helper.getTipo().equals(this.getValor()));
	}

	@Override
	public Object getValor() {
		return valor;
	}
	
	public void setValor(Class<?> valor) {
		this.valor = valor;
	}

	@Override
	public boolean buscasA(Method metodo) {
		// TODO Auto-generated method stub
		return false;
	}

}
