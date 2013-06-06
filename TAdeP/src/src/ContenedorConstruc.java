package src;

public class ContenedorConstruc extends Contenedor {

	public Object dameUnObjeto(Class<?> clase) throws Exception{
		
		Object objetoAux = this.getInstancias().get(this.getDependenciasClases().get(0)).newInstance();
		ArrayList<<?>> params = clase.getConstructo
		return clase.getConstructor(this.getDependenciasClases().get(0)).newInstance(objetoAux);
	}
}
