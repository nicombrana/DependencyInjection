package src;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Contenedor {

	private Map<String,Object> dictionaryObject;
	private Map<String,ArrayList<Object>> dictionaryObjects;
		
	public Contenedor() {
		this.dictionaryObject = new TreeMap<String,Object>();
		this.dictionaryObjects = new TreeMap<String,ArrayList<Object>>();
	}
	
	public Object dameUnObjeto(String nombre){
		return this.dictionaryObject.get(nombre);
	}
	
	public Object dameUnaColeccion(String nombre){
		return this.dictionaryObjects.get(nombre);
	}
	
	public void cuandoTePidanPone(String nombre,Object valor){
		this.dictionaryObject.put(nombre, valor);
	}
	
	public void cuandoTePidanPone(String nombre,ArrayList<Object> valores){
		this.dictionaryObjects.put(nombre, valores);
	}

}
