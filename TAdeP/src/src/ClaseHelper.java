package src;

import java.util.ArrayList;


public class ClaseHelper extends ContenedorHelper {

	private Class<?> clase;
	private ArrayList<ContenedorHelper> dependencias = new ArrayList<ContenedorHelper>();
	
	public ClaseHelper(Class<?> tipo, Class<?> clase) {
		this.setTipo(tipo);
		this.setClase(clase);
	}

	//Setters & Getters
	public void setTipo(Class<?> tipo){
		this.tipo = tipo;
	}
	
	public void setClase(Class<?> clase){
		this.clase = clase;
	}
	
	public void setDependencias(ContenedorHelper objeto){
		this.dependencias.add(objeto);
	}
	
	public Class<?> getTipo(){
		return this.tipo;
	}
	
	public Class<?> getClase(){
		return this.clase;
	}
	
	public ArrayList<ContenedorHelper> getDependencias(){
		return this.dependencias;
	}
	
	//Comportamiento
	public void agregarDependencia(ClaseHelper dependencia){
		this.getDependencias().add(dependencia);
	}
	
	public void agregarDependencia(ObjetoHelper dependencia){
		this.getDependencias().add(dependencia);
	}
}
