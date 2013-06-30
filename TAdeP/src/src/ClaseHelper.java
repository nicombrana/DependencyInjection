package src;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class ClaseHelper extends Componente {

	private Class<?> clase;
	private ArrayList<Componente> dependencias = new ArrayList<Componente>();
	private Contenedor contenedor;
	
	public Contenedor getContenedor() {
		return contenedor;
	}

	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}

	public ClaseHelper(Class<?> tipo, Class<?> clase,Contenedor cont) {
		this.setTipo(tipo);
		this.setClase(clase);
		this.setContenedor(cont);
	}
	
	//Comportamiento
	public void settea(Class<?> clase, Object objeto) throws Exception{
		Object objetoDependencia = this.getContenedor().dameUnObjeto(this.getTipo());
		for (Method metodo : clase.getMethods()){
			if ((metodo.getName().contains("set")) && (metodo.getParameterTypes()[0].equals(this.getTipo()))){
				metodo.invoke(objeto, objetoDependencia);
			}
		}
	}

	//Setters & Getters
	public void setTipo(Class<?> tipo){
		this.tipo = tipo;
	}
	
	public void setClase(Class<?> clase){
		this.clase = clase;
	}
	
	public void setDependencias(Componente objeto){
		this.dependencias.add(objeto);
	}
	
	public Class<?> getTipo(){
		return this.tipo;
	}
	
	public Class<?> getClase(){
		return this.clase;
	}
	
	public ArrayList<Componente> getDependencias(){
		return this.dependencias;
	}
	
	//Comportamiento
	public void agregarDependencia(ClaseHelper dependencia){
		this.getDependencias().add(dependencia);
	}
	
	public void agregarDependencia(ObjetoHelper dependencia){
		this.getDependencias().add(dependencia);
	}
	
	@Override
	public Object getValor(ContenedorConstructor contenedorConstructor) throws Exception {
		return contenedorConstructor.dameUnObjeto(getTipo());
	}
}
