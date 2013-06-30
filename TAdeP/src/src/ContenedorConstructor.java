package src;

import java.util.ArrayList;
import java.util.List;

public class ContenedorConstructor extends Contenedor {

	public Object dameUnObjeto(Class<?> tipo) throws Exception {

		ClaseHelper inyectableHelper = (ClaseHelper) this
				.getDiccionarioClaseHelper().get(tipo);
		List<Object> dependencias = new ArrayList<Object>();
		List<Class<?>> tiposDependencias = new ArrayList<Class<?>>();

		for (Componente componente : inyectableHelper.getDependencias()) {
			dependencias.add(componente.getValor(this));
			tiposDependencias.add(componente.getTipo());
		}

		return inyectableHelper.getClase()
				.getConstructor(toArray(tiposDependencias))
				.newInstance(dependencias);
		// return constructor.newInstance(dependencias);

	}

	// public Object seteaGenerico(Class<?> claseInyectable, ClaseHelper
	// claseHelper) throws Exception {
	// return this.dameUnObjeto(claseHelper.getTipo());
	// }
	//
	// public Object seteaGenerico(Class<?> claseInyectable, ObjetoHelper
	// objetoHelper) throws Exception {
	// return objetoHelper.getValor();
	// }
	private Class[] toArray(List<Class<?>> tiposDependencias) {
		return (Class[]) tiposDependencias.toArray(new Class[tiposDependencias
				.size()]);
	}
}