package src;

public class ContenedorConstructor extends Contenedor {

	
	public Object dameUnObjeto(Class<?> clase) throws Exception{
		
		ClaseHelper inyectableHelper = (ClaseHelper) this.getDiccionarioClaseHelper().get(clase);
		
		for (int i = 0; i < inyectableHelper.getDependencias().size(); i++) {
			if (this.getDiccionarioClaseHelper().containsValue(inyectableHelper.getDependencias().get(i))){
				ClaseHelper claseHelperAux = (ClaseHelper) inyectableHelper.getDependencias().get(i);
				this.seteaGenerico(clase, objetoInyectable, claseHelperAux);
			} else{
				ObjetoHelper objetoHelperAux = (ObjetoHelper) inyectableHelper.getDependencias().get(i);
				this.seteaGenerico(clase, objetoInyectable, objetoHelperAux);
			}
			
		return clase.getConstructor().newInstance();
		
		}
	
	}
	
}