package src;


public class ContenedorSetter extends Contenedor {

	public Object dameUnObjeto(Class<?> clase) throws Exception{
		
		Object objetoPedido = this.getInstancias().get(clase).newInstance();

		for (Class<?> claseInyectada: this.getDependenciasClases()) {
			Object objetoAInyectar = this.getInstancias().get(claseInyectada).newInstance();
			clase.getMethod(("set"+claseInyectada.getSimpleName()), claseInyectada).invoke(objetoPedido, objetoAInyectar);
		};
		
		for (String referencia: this.getDependenciasObjetos()) {
			Object objetoAInyectar = this.getObjetos().get(referencia);
			clase.getMethod(("set"+referencia), this.getReferencias().get(referencia)).invoke(objetoPedido, objetoAInyectar);
		}
		
		return objetoPedido;
	}	

}
