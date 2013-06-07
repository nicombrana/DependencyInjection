package src;

import java.util.ArrayList;

public class ContenedorConstructor extends Contenedor {

	
	public Object dameUnObjeto(Class<?> clase) throws Exception{
		
		ClaseHelper inyectableHelper = (ClaseHelper) this.getDiccionarioClaseHelper().get(clase);
		ArrayList<Object> dependencias = new ArrayList<Object>();
		Class<?>[] tiposDependencias = new Class<?>[]{};
		
		for (int i = 0; i < inyectableHelper.getDependencias().size(); i++) {
			if (this.getDiccionarioClaseHelper().containsValue(inyectableHelper.getDependencias().get(i))){
				ClaseHelper claseHelperAux = (ClaseHelper) inyectableHelper.getDependencias().get(i);
				dependencias.add(this.dameUnObjeto(claseHelperAux.getTipo()));
				tiposDependencias[i] = claseHelperAux.getTipo();
			} else{
				ObjetoHelper objetoHelperAux = (ObjetoHelper) inyectableHelper.getDependencias().get(i);
				dependencias.add(objetoHelperAux.getValor());
				tiposDependencias[i] = objetoHelperAux.getTipo();
			}		
		}
		
		return clase.getConstructor(tiposDependencias).newInstance(dependencias);
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