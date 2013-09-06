package src;

import java.util.ArrayList;

public class Contenedor {

	private ArrayList<ContenedorHelper> helpers = new ArrayList<ContenedorHelper>();
	private Estrategia estrategia;

	public Object dameUnObjeto(Class<?> tipo) throws Exception {
		return new BusquedaHelper(tipo).dameUnObjetoDesde(this.helpersAsVector()).dameUnObjetoUsando(
				this.getEstrategia());
	}

	private ContenedorHelper[] helpersAsVector() {
		return helpers.toArray( new ContenedorHelper[helpers.size()]);
	}

	public void configurate(Class<?> tipo, Class<?> clase) {
		this.getHelpers().add(new ClaseHelper(tipo, clase));
	}

	public void configurate(String referencia, Class<?> tipo, Object valor) {
		this.getHelpers().add(new ObjetoHelper(referencia, tipo, valor));
	}

	public void configurate(Class<?> tipo, Object valor) {
		this.configurate(" ", tipo, valor);
	}

	public void agregarDependencia(Class<?> tipoInyectable,
			Class<?> tipoDependencia) throws Exception {
		new BusquedaHelper(tipoInyectable).dameUnObjetoDesde(this.helpersAsVector())
				.agregarDependencia(new BusquedaHelper(tipoDependencia).dameUnObjetoDesde(this.helpersAsVector()));
	}

	public void agregarDependencia(Class<?> tipoInyectable,
			ArrayList<Class<?>> tiposDependencia) throws Exception {
		for (Class<?> tipo : tiposDependencia) {
			this.agregarDependencia(tipoInyectable, tipo);
		}
	}
	
	public void agregarDependencia(Class<?> tipoInyectable,
			String referenciaDependencia) throws Exception {
		new BusquedaHelper(tipoInyectable).dameUnObjetoDesde(this.helpersAsVector())
				.agregarDependencia(
						new BusquedaHelper(referenciaDependencia).dameUnObjetoDesde(this.helpersAsVector()));
	}


	// Getters & Setters
	public ArrayList<ContenedorHelper> getHelpers() {
		return helpers;
	}

	public void setHelpers(ArrayList<ContenedorHelper> helpers) {
		this.helpers = helpers;
	}

	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

}