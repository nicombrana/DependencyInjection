package src;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PorSetter implements Estrategia {


	@Override
	public Object genera(ClaseHelper helper) throws IllegalArgumentException, InvocationTargetException, Exception {
		Object objetoInyectable = helper.getClase().newInstance();

		for (ContenedorHelper dependenciaHelper : helper.getDependencias()) {
			this.buscarMetodo(helper.getClase(), dependenciaHelper.getTipo()).invoke(
					objetoInyectable, dependenciaHelper.dameUnObjetoUsando(this));
		}

		return objetoInyectable;
	}

	private Method buscarMetodo(Class<?> clase, Class<?> tipo) throws Exception {
		for (Method metodo : clase.getMethods()) {
			if ((metodo.getName().contains("set"))
					&& (metodo.getParameterTypes()[0].equals(tipo))) {
				return metodo;
			}
		}
		throw new Exception("No se encontro el metodo.");
	}
}
