package src;

import java.util.ArrayList;
import java.util.HashMap;

public class Contenedor  {
	private HashMap<Class<?>,Class<?>> instancias = new HashMap<Class<?>, Class<?>>();
	private HashMap<String,Object> objetos = new HashMap<String,Object>();
	private HashMap<String,Class<?>> referencias = new HashMap<String,Class<?>>();
	private ArrayList<Class<?>> dependenciasClases = new ArrayList<Class<?>>();
	private ArrayList<String> dependenciasObjetos = new ArrayList<String>();
	
	
	public HashMap<String, Object> getObjetos() {
		return objetos;
	}

	public void setObjetos(HashMap<String, Object> objetos) {
		this.objetos = objetos;
	}

	public HashMap<String, Class<?>> getReferencias() {
		return referencias;
	}

	public void setReferencias(HashMap<String, Class<?>> referencias) {
		this.referencias = referencias;
	}

	public ArrayList<String> getDependenciasObjetos() {
		return dependenciasObjetos;
	}

	public void setDependenciasObjetos(ArrayList<String> dependenciasObjetos) {
		this.dependenciasObjetos = dependenciasObjetos;
	}

	public HashMap<Class<?>, Class<?>> getInstancias() {
		return instancias;
	}

	public void setInstancias(HashMap<Class<?>, Class<?>> instancias) {
		this.instancias = instancias;
	}

	public ArrayList<Class<?>> getDependenciasClases() {
		return dependenciasClases;
	}

	public void setDependenciasClases(ArrayList<Class<?>> dependencias) {
		this.dependenciasClases = dependencias;
	}
	
	
	public void configurate(Class<?> claseTipo, Class<?> claseInstancia){
		this.instancias.put(claseTipo, claseInstancia);
	}
	
	public void configurate(String referencia, Class<?> tipo){
		this.referencias.put(referencia, tipo);
	}
	
	public void configurate(String referencia, Object objeto){
		this.objetos.put(referencia, objeto);
	}

	
	public void agregarDependencia(Class<?> clase){
		this.dependenciasClases.add(clase);
	}
	
//	public void agregarDependencia(ArrayList<Class<?>> clase){
//		this.dependenciasClases.addAll(clase);
//	}
	
	
	public void agregarDependencia(String referenciaAObjeto){
		this.dependenciasObjetos.add(referenciaAObjeto);
	}
	
//	public void agregarDependencia(ArrayList<String> referenciaAObjeto){
//		this.dependenciasObjetos.addAll(referenciaAObjeto);
//	}
}
