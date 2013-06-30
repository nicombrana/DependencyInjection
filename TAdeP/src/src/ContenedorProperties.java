package src;


public class ContenedorProperties extends Contenedor {

	public Object dameUnObjeto(Class<?> tipo) throws Exception{
		ClaseHelper inyectableHelper = (ClaseHelper) this.getDiccionarioClaseHelper().get(tipo);
		Object objetoInyectable = inyectableHelper.getClase().newInstance();
		//FIXME código repetido con ContenedorProperties
		//FIXME usar foreach
		for (int i = 0; i < inyectableHelper.getDependencias().size(); i++) {
			//FIXME nombres de variables !!!!
			if (this.getDiccionarioClaseHelper().containsValue(inyectableHelper.getDependencias().get(i))){
				ClaseHelper claseHelperAux = (ClaseHelper) inyectableHelper.getDependencias().get(i);
				claseHelperAux.settea(inyectableHelper.getClase(), objetoInyectable);
//				this.seteaGenerico(inyectableHelper.getClase(), objetoInyectable, claseHelperAux);
			} else{
				ObjetoHelper objetoHelperAux = (ObjetoHelper) inyectableHelper.getDependencias().get(i);
				objetoHelperAux.settea(inyectableHelper.getClase(), objetoInyectable);
//				this.seteaGenerico(inyectableHelper.getClase(), objetoInyectable, objetoHelperAux);
			}
			
		}
		
		return objetoInyectable;
	}

	//FIXME no tener código comentado!!
//	public void seteaGenerico(Class<?> claseInyectable, Object objetoInyectable, ClaseHelper claseHelper) throws Exception {
//		Object objetoDependencia =  this.dameUnObjeto(claseHelper.getTipo());
//		claseInyectable.getMethod("set"+claseHelper.getTipo().getSimpleName(), claseHelper.getTipo()).
//			invoke(objetoInyectable,objetoDependencia);
//	}
//	
//	public void seteaGenerico(Class<?> claseInyectable, Object objetoInyectable, ObjetoHelper objetoHelper) throws Exception {
//		Object objetoDependencia = objetoHelper.getValor();
//		claseInyectable.getMethod("set"+objetoHelper.getReferencia(), objetoHelper.getTipo()).
//			invoke(objetoInyectable, objetoDependencia);
//	}
	
}

