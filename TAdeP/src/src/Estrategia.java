package src;

import java.lang.reflect.InvocationTargetException;

public interface Estrategia {
	
	public Object genera(ClaseHelper helper) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception;
}
