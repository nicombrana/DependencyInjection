package src;

import java.util.HashMap;

public abstract class Contenedor  {
	
	private HashMap<Class<?>,ClaseHelper> diccionarioClaseHelper = new HashMap<Class<?>,ClaseHelper>();
	private HashMap<String,ObjetoHelper> diccionarioObjetoHelper = new HashMap<String,ObjetoHelper>();
	
	//Getters & Setters
	
	
	public HashMap<Class<?>, ClaseHelper> getDiccionarioClaseHelper() {
		return diccionarioClaseHelper;
	}

	public void setDiccionarioClaseHelper(HashMap<Class<?>, ClaseHelper> diccionarioClaseHelper) {
		this.diccionarioClaseHelper = diccionarioClaseHelper;
	}

	public HashMap<String, ObjetoHelper> getDiccionarioObjetoHelper() {
		return diccionarioObjetoHelper;
	}

	public void setDiccionarioObjetoHelper(HashMap<String, ObjetoHelper> diccionarioObjetoHelper) {
		this.diccionarioObjetoHelper = diccionarioObjetoHelper;
	}

	public void configurate(Class<?> tipo, Class<?> clase){
		ClaseHelper claseHelper = new ClaseHelper(tipo, clase);
		this.getDiccionarioClaseHelper().put(tipo, claseHelper);
	}
	
	public void configurate(String referencia, Class<?> tipo, Object valor){
		ObjetoHelper objetoHelper = new ObjetoHelper(referencia, tipo, valor);
		this.getDiccionarioObjetoHelper().put(referencia, objetoHelper);
	}
	
	public void agregarDependencia(Class<?> tipoInyectable, Class<?> tipoDependencia){
		this.getDiccionarioClaseHelper().get(tipoInyectable).
			agregarDependencia(this.getDiccionarioClaseHelper().get(tipoDependencia));
	}
	
	public void agregarDependencia(Class<?> tipoInyectable, String referenciaDependencia){
		this.getDiccionarioClaseHelper().get(tipoInyectable).
			agregarDependencia(this.getDiccionarioObjetoHelper().get(referenciaDependencia));
	}
	
}
