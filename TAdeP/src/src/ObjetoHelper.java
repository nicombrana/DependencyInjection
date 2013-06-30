package src;

import java.lang.reflect.Method;


public class ObjetoHelper extends Componente {

	private String referencia;
	private Object valor;
	
	public ObjetoHelper(String referencia, Class<?> tipo, Object valor) {
		this.setReferencia(referencia);
		this.setTipo(tipo);
		this.setValor(valor);
	}

	//Comportamiento
	public void settea(Class<?> clase, Object objeto) throws Exception{
		Method metodoAInvocar = null;
		if (this.getReferencia().equals(this.getTipo().getSimpleName())){
			for (Method metodo : clase.getMethods()){
				if ((metodo.getName().contains("set")) && (metodo.getParameterTypes()[0].equals(this.getTipo()))){
					metodoAInvocar= metodo;
				}
			}
		} else{
			metodoAInvocar = clase.getMethod("set"+this.getReferencia(), this.getTipo());
		}
		
		metodoAInvocar.invoke(objeto, this.getValor());
		
	}
	
	@Override
	public Object getValor(ContenedorConstructor contenedorConstructor) {
		return referencia;
	}

	//Setters & Getters
	public String getReferencia() {
		return referencia;
	}
	
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	public Object getValor() {
		return valor;
	}
	
	public void setValor(Object valor) {
		this.valor = valor;
	}

}
