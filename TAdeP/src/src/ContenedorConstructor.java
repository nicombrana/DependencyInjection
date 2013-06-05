package src;

public class ContenedorConstructor extends Contenedor {

	
	public Object dameUnObjeto(Class<?> clase) throws Exception{
		
		Object objetoAux = this.getInstancias().get(this.getDependenciasClases().get(0)).newInstance();
		
		return clase.getConstructor(this.getDependenciasClases().get(0)).newInstance(objetoAux);
	}
}
