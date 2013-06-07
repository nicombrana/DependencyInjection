package src;

import java.beans.Introspector;

public class ContenedorProperties extends Contenedor {

	public Object dameUnObjeto(Class<?> tipo) throws Exception{
		
		ClaseHelper inyectableHelper = (ClaseHelper) this.getDiccionarioClaseHelper().get(tipo);
		Object objetoInyectable = inyectableHelper.getClase().newInstance();
		
		
		for (int i = 0; i < inyectableHelper.getDependencias().size(); i++) {
			if (this.getDiccionarioClaseHelper().containsValue(inyectableHelper.getDependencias().get(i))){
				ClaseHelper claseHelperAux = (ClaseHelper) inyectableHelper.getDependencias().get(i);
				this.seteaGenerico(inyectableHelper.getClase(), objetoInyectable, claseHelperAux);
			} else{
				ObjetoHelper objetoHelperAux = (ObjetoHelper) inyectableHelper.getDependencias().get(i);
				this.seteaGenerico(inyectableHelper.getClase(), objetoInyectable, objetoHelperAux);
			}
			
		}
		
		return objetoInyectable;
	}
	
	public void seteaGenerico(Class<?> claseInyectable, Object objetoInyectable, ClaseHelper claseHelper) throws Exception {
		Object objetoDependencia =  this.dameUnObjeto(claseHelper.getTipo());
		
//		claseInyectable.getDeclaredField(Introspector.decapitalize(claseHelper.getTipo().getSimpleName())).setAccessible(true);
		claseInyectable.getDeclaredField(Introspector.decapitalize(claseHelper.getTipo().getSimpleName())).
			set(objetoInyectable, objetoDependencia);
	}
	
	public void seteaGenerico(Class<?> claseInyectable, Object objetoInyectable, ObjetoHelper objetoHelper) throws Exception {
		Object objetoDependencia = objetoHelper.getValor();
		
//		claseInyectable.getDeclaredField(Introspector.decapitalize(objetoHelper.getReferencia())).setAccessible(true);
		claseInyectable.getDeclaredField(Introspector.decapitalize(objetoHelper.getReferencia())).
			set(objetoInyectable, objetoDependencia);
	}
	
}
