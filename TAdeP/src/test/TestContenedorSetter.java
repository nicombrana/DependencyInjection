package test;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.ContenedorProperties;

public class TestContenedorSetter {
	
	private ContenedorProperties contSet;
	
	@Before
	public void setUp() throws Exception {
		contSet = new ContenedorProperties();
		//FIXME esto no está bien. El contenedor debería soportar todos los métodos de inyección,
		//y ser específico de cada configuracion
		
		contSet.configurate(PersonaHome.class, PersonaDataBaseHome.class);
		contSet.configurate(PersonaService.class, PersonaService.class);
		//XXX OK, soporta configuracion por componente
		
		contSet.configurate("Usuario","".getClass(),"Franco");
		contSet.configurate("Password","".getClass(),"VamosQueFunca!");
		contSet.configurate("Host","".getClass(),"ElHost");
		contSet.configurate("Puerto",int.class,1234);
		contSet.configurate("Esquema","".getClass(),"Blah");
		
		//XXX ok, tambien soporta por id
		contSet.agregarDependencia(PersonaService.class,PersonaHome.class);
		contSet.agregarDependencia(PersonaHome.class,"Usuario");
		contSet.agregarDependencia(PersonaHome.class,"Password");
		contSet.agregarDependencia(PersonaHome.class,"Host");
		contSet.agregarDependencia(PersonaHome.class,"Puerto");
		contSet.agregarDependencia(PersonaHome.class,"Esquema");
		
		
		contSet.configurate(Persona.class, Persona.class); 
		contSet.configurate("".getClass(), "Fede"); //FIXME porque no String.class?
		contSet.configurate(int.class, 25);
		
		
		ArrayList<Class<?>> listaDependencias = new ArrayList<Class<?>>();
		listaDependencias.add("".getClass());
		listaDependencias.add(int.class);
		contSet.agregarDependencia(Persona.class, listaDependencias);
		
	}
	
	@Test
	public void testContenedorSetter() throws Exception {
		PersonaService personita = (PersonaService) contSet.dameUnObjeto(PersonaService.class);
		Assert.assertEquals("Franco", personita.getPersonaHome().getUsuario());
	}
	
	@Test
	public void testCPersonaServiceTieneUnPersonaDataBaseHome() throws Exception {
		PersonaService personaService = (PersonaService) contSet.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(PersonaDataBaseHome.class, personaService.getPersonaHome().getClass());
	}
	
	@Test
	public void testContenedorObjetos() throws Exception {
		contSet = new ContenedorProperties();
		contSet.configurate(PersonaHome.class, PersonaDataBaseHome.class);
		contSet.configurate("Usuario","".getClass(),"Fede");
		contSet.configurate("Password","".getClass(),"AguanteEsteGrupo");
		contSet.configurate("Host","".getClass(),"ElHost");
		contSet.configurate("Puerto",int.class,1234);
		contSet.configurate("Esquema","".getClass(),"Blah");
		contSet.agregarDependencia(PersonaHome.class,"Usuario");
		contSet.agregarDependencia(PersonaHome.class,"Password");
		contSet.agregarDependencia(PersonaHome.class,"Host");
		contSet.agregarDependencia(PersonaHome.class,"Puerto");
		contSet.agregarDependencia(PersonaHome.class,"Esquema");
	
		PersonaDataBaseHome persoDB = (PersonaDataBaseHome) contSet.dameUnObjeto(PersonaHome.class);
		Assert.assertEquals("Fede", persoDB.getUsuario());
	}
	
	@Test
	public void testPersona() throws Exception {
		Persona personita = (Persona) contSet.dameUnObjeto(Persona.class);
		Assert.assertEquals(25, personita.getEdad());
	}
}
