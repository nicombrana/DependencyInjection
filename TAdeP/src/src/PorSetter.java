package src;

import java.lang.reflect.InvocationTargetException;

public class PorSetter implements Estrategia {

	@Override
	public Object genera(ClaseHelper inyectableHelper)
			throws IllegalArgumentException, InvocationTargetException,
			Exception {
		Object objetoInyectable = inyectableHelper.getClase().newInstance();

		for (ContenedorHelper dependenciaHelper : inyectableHelper
				.getDependencias()) {
			new BusquedaMetodo(dependenciaHelper.getTipo(),
					dependenciaHelper.getReferencia()).dameUnObjetoDesde(
					inyectableHelper.getTipo().getMethods()).invoke(
					objetoInyectable,
					dependenciaHelper.dameUnObjetoUsando(this));
		}

		return objetoInyectable;
	}

}
