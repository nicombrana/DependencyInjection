package src;

import java.lang.reflect.InvocationTargetException;

public abstract class ContenedorHelper {

	public Class<?> tipo;
	public String referencia = " ";

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public void setTipo(Class<?> tipo) {
		this.tipo = tipo;
	}

	public Class<?> getTipo() {
		return this.tipo;
	}

	public void settea(Class<?> clase, Object objeto) throws Exception {

	}

	public void agregarDependencia(ContenedorHelper dependencia) {

	}
	
	public Object dameUnObjetoUsando(Estrategia estrategia) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception{
		return null;
	}
	
//	public Busqueda crearBusquedaDeMetodo(){
//		if (this.getReferencia().equalsIgnoreCase(" ")) {
//			return new BusquedaMetodoPorTipo(this);
//		}
//		
//		return new BusquedaMetodoPorReferencia(this);
//	}
	
	public boolean sos(Class<?> tipo){
		return this.getTipo().equals(tipo);
	}
	
	public boolean sos(String referencia){
		return this.getReferencia().equals(referencia);
	}
	
	
}
