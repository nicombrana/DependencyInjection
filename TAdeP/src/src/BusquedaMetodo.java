package src;

import java.lang.reflect.Method;

public class BusquedaMetodo extends Busqueda<Method> {

	public BusquedaMetodo(Class<?> tipo, String referencia) {
		this.tipo = tipo;
		this.referencia = referencia;
		if (referencia.equalsIgnoreCase(" ")) {
			this.valor = tipo.getSimpleName();
		} else {
			this.valor = referencia;
		}
	}

	@Override
	public boolean buscasPorReferencia(Method metodo) {
		return this.esSetter(metodo)
				&& metodo.getName().contains(this.referencia);

	}

	@Override
	public boolean buscasPorTipo(Method metodo) {
		return this.esSetter(metodo)
				&& metodo.getParameterTypes()[0].equals(this.tipo);
	}

	private boolean esSetter(Method metodo) {
		return metodo.getName().contains("set");
	}

}
