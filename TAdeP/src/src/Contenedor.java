package src;

import java.util.ArrayList;
import java.util.HashMap;

public class Contenedor {

	private ArrayList<ContenedorHelper> diccionarioHelper = new ArrayList<ContenedorHelper>();
	private Estrategia estrategia;

	public Object dameUnObjeto(Class<?> tipo) throws Exception {
		return this.getDiccionarioHelper().get(tipo)
				.dameUnObjetoUsando(this.getEstrategia());

	}

	public void configurate(Class<?> tipo, Class<?> clase) {
		this.getDiccionarioHelper().add(new ClaseHelper(tipo, clase));
	}

	public void configurate(String referencia, Class<?> tipo, Object valor) {
		this.getDiccionarioHelper().add(new ObjetoHelper(referencia, tipo, valor));
	}

	public void configurate(Class<?> tipo, Object valor) {
		this.configurate(tipo.getSimpleName(), tipo, valor);
	}

	public void agregarDependencia(Class<?> tipoInyectable,
			Class<?> tipoDependencia) {
		this.getDiccionarioHelper()
				.get(tipoInyectable)
				.agregarDependencia(
						this.getDiccionarioHelper().get(tipoDependencia));
	}

//	public void agregarDependencia(Class<?> tipoInyectable,
//			ArrayList<Class<?>> tiposDependencia) {
//		for (Class<?> tipo : tiposDependencia) {
//			this.agregarDependencia(tipoInyectable, tipo);
//		}
//	}
//
	public void agregarDependencia(Class<?> tipoInyectable,
			String referenciaDependencia) throws Exception {
		this.getDiccionarioHelper()
				.get(tipoInyectable)
				.agregarDependencia(this.buscarPorReferencia(referenciaDependencia));
	}
	
	private ContenedorHelper buscarPorReferencia(String referencia) throws Exception{
		for (ContenedorHelper helper: this.getDiccionarioHelper()) {
			if (helper.getReferencia().equalsIgnoreCase(referencia)) {
				return helper;
			}
		}
		
		throw new Exception("No se encontro la referencia: " + referencia);
	}
	
	private ContenedorHelper buscarHelper(String referencia) throws Exception{
		for (ContenedorHelper helper: this.getDiccionarioHelper()) {
			
		}
		
	}

	// Getters & Setters
	public ArrayList<ContenedorHelper> getDiccionarioHelper() {
		return diccionarioHelper;
	}

	public void setDiccionarioHelper(
			ArrayList<ContenedorHelper> diccionarioHelper) {
		this.diccionarioHelper = diccionarioHelper;
	}

	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

}