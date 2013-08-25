package src;

import java.lang.reflect.Method;

public interface Busqueda {
	
	public Object getValor();

	boolean buscasA(ContenedorHelper helper);

	boolean buscasA(Method metodo);
}
