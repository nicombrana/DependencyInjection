package src;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ClaseHelper extends ContenedorHelper {

	private Class<?> clase;
	private ArrayList<ContenedorHelper> dependencias = new ArrayList<ContenedorHelper>();



	public ClaseHelper(Class<?> tipo, Class<?> clase) {
		this.setTipo(tipo);
		this.setClase(clase);
	}

	// Comportamiento
	public Object dameUnObjetoUsando(Estrategia estrategia) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
		return estrategia.genera(this);
	}
	

	public void agregarDependencia(ContenedorHelper dependencia) {
		this.getDependencias().add(dependencia);
	}

	// Setters & Getters
	public void setTipo(Class<?> tipo) {
		this.tipo = tipo;
	}

	public void setClase(Class<?> clase) {
		this.clase = clase;
	}

	public void setDependencias(ContenedorHelper objeto) {
		this.dependencias.add(objeto);
	}

	public Class<?> getTipo() {
		return this.tipo;
	}

	public Class<?> getClase() {
		return this.clase;
	}

	public ArrayList<ContenedorHelper> getDependencias() {
		return this.dependencias;
	}

}
