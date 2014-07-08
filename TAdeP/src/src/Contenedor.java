package src;

import java.util.ArrayList;

public class Contenedor {

	private ArrayList<ContenedorHelper> helpers = new ArrayList<ContenedorHelper>();
	private Estrategia estrategia;

	//FIXME nunca usen excepciones chequeadas (que heredan de excepcion)
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
	  //FIXME no les parece un poquito "asqueroso" que haya "ContenedoresHelper"s
	  //con una referencia == " " solo para señalizar que ese objeto es un valor y no ua referencia?
	  //¿Que opinan de la robustez y claridad de esta solución?
	  //Yo creo que acá les falta una abstracción, y esto viene de la mano de que eligieron pobres nombres
	  //para sus "ContenedorHelper". Piensen que representan en términos de inyección de dependencias, 
	  //intenten buscar un mejor nombre, y luego piensen si los mensajes que exponen son cohesivos
	  //respecto de esa abstracción. Y luego piensen si no hay dos abstraciones mezcladas, que pueden separar
	  //y en el camino, eliminar esta necesidad de valores centinela. 
		this.configurate(" ", tipo, valor);
	}

	public void agregarDependencia(Class<?> tipoInyectable,
			Class<?> tipoDependencia) throws Exception {
		new BusquedaHelper(tipoInyectable).dameUnObjetoDesde(this.helpersAsVector())
				.agregarDependencia(new BusquedaHelper(tipoDependencia).dameUnObjetoDesde(this.helpersAsVector()));
	}

	
	//FIXME es que no tendría sentido que te dejara :D
	//X extends Z & Y significa que X es un subtipo de Z e Y. Y definitivamente
	//en Java (y en cualquier lenguaje razonable) no tiene sentido que haya un objeto que
	//represente al mismo tiempo un String y una Clase
	public <T extends Class<?> /*No me deja agregar & String :(*/ > void agregarDependencia(Class<?> tipoInyectable,
			ArrayList<T> tiposDependencia) throws Exception {
		for (T tipo : tiposDependencia) {
			this.agregarDependencia(tipoInyectable, tipo);
		}
	}

	
	public void agregarDependencia(Class<?> tipoInyectable,
			String referenciaDependencia) throws Exception {
	  //FIXME no ven lógica repetida dentro de este método? Y también dentro de la sobrecarga 
	  //de agregarDependencia que está más arriba?
		new BusquedaHelper(tipoInyectable).dameUnObjetoDesde(this.helpersAsVector())
				.agregarDependencia(
						new BusquedaHelper(referenciaDependencia).dameUnObjetoDesde(this.helpersAsVector()));
	}

	//FIXME muy poco flexible esta solución, en tanto
	//habria que delarar un metodo por cada tipo de dependencia (int, Integer, String, bool, etc, etc)
	//que se quiera inyectar. No podría generalizarlo, para que reciba object
	//y tome el tipo a partir de valor.clazz?
	public void agregarDependenciaConValor(Class<?> tipoInyectable,
			String valor) throws Exception {
		this.configurate(String.class, valor);
		this.agregarDependencia(tipoInyectable, String.class);
	}
	
	public void agregarDependenciaConValor(Class<?> tipoInyectable,
			int valor) throws Exception {
		this.configurate(Integer.class, valor);
		this.agregarDependencia(tipoInyectable, Integer.class);
	}
	

	// Getters & Setters
	public ArrayList<ContenedorHelper> getHelpers() {
		return helpers;
	}

	//FIXME no usen tipos de listas concretos, sino tipos tan generales como sean posibles.
	//Por ejemplo, en este caso, List. 
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