package src;

import java.lang.reflect.Method;

public class BusquedaHelperPorReferencia implements Busqueda {

	public String valor;
	
	public BusquedaHelperPorReferencia(String valor) {
		this.valor = valor;
	}
	
	@Override
	public boolean buscasA(ContenedorHelper helper) {
		return (helper.getReferencia().equals(this.getValor()));
	}

	@Override
	public Object getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public boolean buscasA(Method metodo) {
		// TODO Auto-generated method stub
		return false;
	}
}
