package src;

import java.util.ArrayList;

public class Contenedor {

	private ArrayList<ContenedorHelper> helpers = new ArrayList<ContenedorHelper>();
	private Estrategia estrategia;

	public Object dameUnObjeto(Class<?> tipo) throws Exception {
		return this.buscar(new BusquedaHelperPorTipo(tipo)).dameUnObjetoUsando(
				this.getEstrategia());
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
		this.buscar(new BusquedaHelperPorTipo(tipoInyectable))
				.agregarDependencia(this.buscar(new BusquedaHelperPorTipo(tipoDependencia)));
	}

	public void agregarDependencia(Class<?> tipoInyectable,
			ArrayList<Class<?>> tiposDependencia) throws Exception {
		for (Class<?> tipo : tiposDependencia) {
			this.agregarDependencia(tipoInyectable, tipo);
		}
	}

	public void agregarDependencia(Class<?> tipoInyectable,
			String referenciaDependencia) throws Exception {
		this.buscar(new BusquedaHelperPorTipo(tipoInyectable))
				.agregarDependencia(
						this.buscar(new BusquedaHelperPorReferencia(referenciaDependencia)));
	}

	private ContenedorHelper buscar(Busqueda busqueda) throws Exception {
		for (ContenedorHelper helper : this.getHelpers()) {
			if (busqueda.buscasA(helper)) {
				return helper;
			}
		}

		throw new Exception("No se encontro referencia para: "
				+ busqueda.getValor());
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