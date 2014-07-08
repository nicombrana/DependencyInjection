package src;

import java.lang.reflect.InvocationTargetException;

//FIXME expresividad: ¿estrategia de.....?
public interface Estrategia {
	
    //FIXME expresividad: genera.... qué? 
	public Object genera(ClaseHelper helper) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception;
}
