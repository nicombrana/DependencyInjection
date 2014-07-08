package src;

import java.lang.reflect.InvocationTargetException;

//FIXME busquen un mejor nombre para la abstracción ContenedorHelper. "Ayuda al contenedor" no dice mucho, 
//eso podría describir a cualquier objeto que el contenedor use
public abstract class ContenedorHelper {

  //FIXME capaz les podría ser util parametrizar a ContenedorHelper según un tipo genérico A, que coincida con 
  //el tipo de Class<A> tipo. De esa forma, podrían exponer más información de tipos
  //al exterior
	public Class<?> tipo;
	public String referencia = " ";

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	//FIXME para qué tienen setters que vuelven al ContenedorHelper mutable?
	//Les aporta algo? Prueben modelar al ContenedorHelper de forma inmutable (sin setters y con atributos privados y/o final),
	//inyectables por constructor
	//y verán que les queda un código más simple
	public void setTipo(Class<?> tipo) {
		this.tipo = tipo;
	}

	public Class<?> getTipo() {
		return this.tipo;
	}


    //FIXME si no tiene sentido que haya una implementación, declaren a este
    //método como abstract
	public void settea(Class<?> clase, Object objeto) throws Exception {

	}


    //FIXME si no tiene sentido que haya una implementación, declaren a este
    //método como abstract
	public void agregarDependencia(ContenedorHelper dependencia) {

	}
	
	//FIXME si no tiene sentido que haya una implementación, declaren a este
	//método como abstract
	//FIXME eviten escribir en la firma de un metodo que el mismo lanza muchas excepciones, en particular cuando son chequeadas,
	//hace mas complejo al código y más difícil razonar sobre este.
	public Object dameUnObjetoUsando(Estrategia estrategia) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception{
		return null;
	}
	
//	public Busqueda crearBusquedaDeMetodo(){
//		if (this.getReferencia().equalsIgnoreCase(" ")) {
//			return new BusquedaMetodoPorTipo(this);
//		}
//		
//		return new BusquedaMetodoPorReferencia(this);
//	}
	
	public boolean sos(Class<?> tipo){
		return this.getTipo().equals(tipo);
	}
	
	public boolean sos(String referencia){
		return this.getReferencia().equals(referencia);
	}
	
	
}
