package src;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PorSetter implements Estrategia {


	@Override
	public Object genera(ClaseHelper inyectableHelper) throws IllegalArgumentException, InvocationTargetException, Exception {
		Object objetoInyectable = inyectableHelper.getClase().newInstance();

		for (ContenedorHelper dependenciaHelper : inyectableHelper.getDependencias()) {
			this.buscarMetodo(inyectableHelper.getClase(), dependenciaHelper.crearBusquedaDeMetodo()).invoke(
					objetoInyectable, dependenciaHelper.dameUnObjetoUsando(this));
		}

		return objetoInyectable;
	}

	private Method buscarMetodo(Class<?> clase, Busqueda busqueda) throws Exception {
		for (Method metodo : clase.getMethods()) {
			if (busqueda.buscasA(metodo)) {
				return metodo;
			}
		}
		throw new Exception("No se encontro el metodo para la Dependencia: " + busqueda.toString());
	}
}
