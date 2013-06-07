package src;


public class ContenedorConstructor extends Contenedor {

	
	public Object dameUnObjeto(Class<?> tipo) throws Exception{
		
		ClaseHelper inyectableHelper = (ClaseHelper) this.getDiccionarioClaseHelper().get(tipo);
		Object[] dependencias = new Object[inyectableHelper.getDependencias().size()];
		Class<?>[] tiposDependencias = new Class<?>[inyectableHelper.getDependencias().size()];
		
		for (int i = 0; i < inyectableHelper.getDependencias().size(); i++) {
			if (this.getDiccionarioClaseHelper().containsValue(inyectableHelper.getDependencias().get(i))){
				ClaseHelper claseHelperAux = (ClaseHelper) inyectableHelper.getDependencias().get(i);
				dependencias[i] = this.dameUnObjeto(claseHelperAux.getTipo());
				tiposDependencias[i] = claseHelperAux.getTipo();
			} else{
				ObjetoHelper objetoHelperAux = (ObjetoHelper) inyectableHelper.getDependencias().get(i);
				dependencias[i] = objetoHelperAux.getValor();
				tiposDependencias[i] = objetoHelperAux.getTipo();
			}		
		}
		
		return inyectableHelper.getClase().getConstructor(tiposDependencias).newInstance(dependencias);
//		return constructor.newInstance(dependencias);
	
	}
	
//	public Object seteaGenerico(Class<?> claseInyectable, ClaseHelper claseHelper) throws Exception {
//		return this.dameUnObjeto(claseHelper.getTipo());
//	}
//	
//	public Object seteaGenerico(Class<?> claseInyectable, ObjetoHelper objetoHelper) throws Exception {
//		return objetoHelper.getValor();
//	}
	
}