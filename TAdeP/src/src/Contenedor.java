package src;

import java.util.HashMap;

public class Contenedor {

	private HashMap<Class<?>, ContenedorHelper> diccionarioHelper = new HashMap<Class<?>, ContenedorHelper>();
	private Estrategia estrategia;

	public Object dameUnObjeto(Class<?> tipo) throws Exception {
		return this.getDiccionarioHelper().get(tipo)
				.dameUnObjetoUsando(this.getEstrategia());

	}

	public void configurate(Class<?> tipo, Class<?> clase) {
		this.getDiccionarioHelper().put(tipo, new ClaseHelper(tipo, clase));
	}

	public void configurate(String referencia, Class<?> tipo, Object valor) {
		this.getDiccionarioHelper().put(tipo,
				new ObjetoHelper(referencia, tipo, valor));
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
		for (ContenedorHelper helper: this.getDiccionarioHelper().values()) {
			System.out.println(helper.getReferencia());
			if (helper.getReferencia().contains(referencia)) {
				return helper;
			}
		}
		
		throw new Exception("No se encontro la referencia.");
	}

	// Getters & Setters
	public HashMap<Class<?>, ContenedorHelper> getDiccionarioHelper() {
		return diccionarioHelper;
	}

	public void setDiccionarioHelper(
			HashMap<Class<?>, ContenedorHelper> diccionarioHelper) {
		this.diccionarioHelper = diccionarioHelper;
	}

	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

}