package src;


public class ContenedorSetter extends Contenedor {

	public Object dameUnObjeto(Class<?> clase) throws Exception{
		ClaseHelper inyectableHelper = (ClaseHelper) this.getDiccionarioClaseHelper().get(clase);
		Object objetoInyectable = inyectableHelper.getClase().newInstance();
		
		
		for (int i = 0; i < inyectableHelper.getDependencias().size(); i++) {
			if (this.getDiccionarioClaseHelper().containsValue(inyectableHelper.getDependencias().get(i))){
				ClaseHelper claseHelperAux = (ClaseHelper) inyectableHelper.getDependencias().get(i);
				this.seteaGenerico(clase, objetoInyectable, claseHelperAux);
			} else{
				ObjetoHelper objetoHelperAux = (ObjetoHelper) inyectableHelper.getDependencias().get(i);
				this.seteaGenerico(clase, objetoInyectable, objetoHelperAux);
			}
			
		}
		
		return objetoInyectable;
	}

	public void seteaGenerico(Class<?> claseInyectable, Object objetoInyectable, ClaseHelper claseHelper) throws Exception {
		Object objetoDependencia =  this.dameUnObjeto(claseHelper.getTipo());
		claseInyectable.getMethod("set"+claseHelper.getTipo().getSimpleName(), claseHelper.getTipo()).
			invoke(objetoInyectable,objetoDependencia);
	}
	
	public void seteaGenerico(Class<?> claseInyectable, Object objetoInyectable, ObjetoHelper objetoHelper) throws Exception {
		Object objetoDependencia = objetoHelper.getValor();
		claseInyectable.getMethod("set"+objetoHelper.getReferencia(), objetoHelper.getTipo()).
			invoke(objetoInyectable, objetoDependencia);
	}
	
	public void seteaGenerico(Class<?> claseInyectable, Object objetoInyectable, ContenedorHelper contenedorHelper){
		System.out.print(2);
	}
}

