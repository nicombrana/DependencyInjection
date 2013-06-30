package src;

public abstract class Componente { //Helper??

	public Class<?> tipo;
	
	public void setTipo(Class<?> tipo) {
		this.tipo = tipo;
	}

	public Class<?> getTipo(){
		return this.tipo;
	}

	public abstract Object getValor(ContenedorConstructor contenedorConstructor) throws Exception;

}
