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
	@Override
	public Object dameUnObjetoUsando(Estrategia estrategia) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
		return estrategia.genera(this);
	}
	

	@Override
	public void agregarDependencia(ContenedorHelper dependencia) {
		this.getDependencias().add(dependencia);
	}

	// Setters & Getters
	public void setClase(Class<?> clase) {
		this.clase = clase;
	}

	public void setDependencias(ContenedorHelper objeto) {
		this.dependencias.add(objeto);
	}

	public Class<?> getClase() {
		return this.clase;
	}

	//FIXME nuevamente, no usen tipos tan concretos como ArrayList. 
	//Usen List, Collection, Iterable, etc, según lo que necesiten
	public ArrayList<ContenedorHelper> getDependencias() {
		return this.dependencias;
	}

}
