package src;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class PorConstructor implements Estrategia {


	@Override
	public Object genera(ClaseHelper inyectableHelper) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, Exception {
	
		ArrayList<Object> dependencias = new ArrayList<Object>(inyectableHelper.getDependencias()
				.size());
		ArrayList<Class<?>> tiposDependencias = new ArrayList<Class<?>>(inyectableHelper
				.getDependencias().size());
		
		for (ContenedorHelper dependenciaHelper : inyectableHelper.getDependencias()) {
			dependencias.add(dependenciaHelper.dameUnObjetoUsando(this));
			tiposDependencias.add(dependenciaHelper.getTipo());
		}
		
		Class<?>[] tConstructor = new Class<?>[inyectableHelper.getDependencias().size()];
		return inyectableHelper.getClase().getConstructor(tiposDependencias.toArray(tConstructor))
				.newInstance(dependencias.toArray());
	}
}