package src;

public class ContenedorProperties extends Contenedor {

	public Object dameUnObjeto(Class<?> clase) throws Exception{
		
		Object objetoInyectado = this.getInstancias().get(clase).newInstance();
		
		for(Class<?> claseInyectada : this.getDependenciasClases()){
			Object objetoAInyectar = this.instanciaClaseInyectada(claseInyectada);
			clase.getField(claseInyectada.getSimpleName()).set(objetoInyectado, objetoAInyectar);
		}
		
		for (String referencia: this.getDependenciasObjetos()) {
			Object objetoAInyectar = this.getValorAInyectar(referencia);
			clase.getField(referencia).set(objetoInyectado, objetoAInyectar);
		}
		
		return objetoInyectado;
	}

}
