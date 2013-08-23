package src;

public class PorConstructor implements Estrategia {

	public Object dameUnObjeto(Class<?> tipo) throws Exception {

		ClaseHelper inyectableHelper = (ClaseHelper) this
				.getDiccionarioClaseHelper().get(tipo);
		Object[] dependencias = new Object[inyectableHelper.getDependencias()
				.size()];
		Class<?>[] tiposDependencias = new Class<?>[inyectableHelper
				.getDependencias().size()];

		for (int i = 0; i < inyectableHelper.getDependencias().size(); i++) {
			if (this.getDiccionarioClaseHelper().containsValue(
					inyectableHelper.getDependencias().get(i))) {
				ClaseHelper claseHelperAux = (ClaseHelper) inyectableHelper
						.getDependencias().get(i);
				dependencias[i] = this.dameUnObjeto(claseHelperAux.getTipo());
				tiposDependencias[i] = claseHelperAux.getTipo();
			} else {
				ObjetoHelper objetoHelperAux = (ObjetoHelper) inyectableHelper
						.getDependencias().get(i);
				dependencias[i] = objetoHelperAux.getValor();
				tiposDependencias[i] = objetoHelperAux.getTipo();
			}
		}

		return inyectableHelper.getClase().getConstructor(tiposDependencias)
				.newInstance(dependencias);

	}

}