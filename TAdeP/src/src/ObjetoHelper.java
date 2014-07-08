package src;

public class ObjetoHelper extends ContenedorHelper {

	private Object valor;

	public ObjetoHelper(String referencia, Class<?> tipo, Object valor) {
		this.setTipo(tipo);
		this.setValor(valor);
		this.setReferencia(referencia);
	}

	// Comportamiento
	@Override
	public Object dameUnObjetoUsando(Estrategia estrategia) {
		return this.getTipo().cast(this.getValor());
	}

	//FIXME no dejen código comentado :D 
	//Para llevar la historia, ya está el git 
//	@Override
//	public void settea(Class<?> clase, Object objeto) throws Exception {
//		Method metodoAInvocar = null;
//		if (this.getReferencia().equals(this.getTipo().getSimpleName())) {
//			for (Method metodo : clase.getMethods()) {
//				if ((metodo.getName().contains("set"))
//						&& (metodo.getParameterTypes()[0]
//								.equals(this.getTipo()))) {
//					metodoAInvocar = metodo;
//				}
//			}
//		} else {
//			metodoAInvocar = clase.getMethod("set" + this.getReferencia(),
//					this.getTipo());
//		}
//
//		metodoAInvocar.invoke(objeto, this.getValor());
//
//	}

	// Setters & Getters

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

}
