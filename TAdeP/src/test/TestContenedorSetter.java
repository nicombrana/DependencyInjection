package test;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.Contenedor;
import src.PorSetter;

public class TestContenedorSetter {
	
	private Contenedor contenedor;
	
	@Before
	public void setUp() throws Exception {
		contenedor = new Contenedor();
		contenedor.configurate(PersonaHome.class, PersonaDataBaseHome.class);
		contenedor.configurate(PersonaService.class, PersonaService.class);
		contenedor.configurate("Usuario","".getClass(),"Franco");
		contenedor.configurate("Password","".getClass(),"VamosQueFunca!");
		contenedor.configurate("Host","".getClass(),"ElHost");
//		contenedor.configurate("Puerto",Integer.class,1234);
		contenedor.configurate("Esquema","".getClass(),"Blah");
		contenedor.agregarDependencia(PersonaService.class,PersonaHome.class);
//		contenedor.agregarDependencia(PersonaHome.class,"Usuario");
//		contenedor.agregarDependencia(PersonaHome.class,"Password");
		contenedor.agregarDependencia(PersonaHome.class,"Host");
//		contenedor.agregarDependencia(PersonaHome.class,"Puerto");
		contenedor.agregarDependencia(PersonaHome.class,"Esquema");
//		
//		contenedor.configurate(Persona.class, Persona.class);
//		contenedor.configurate("".getClass(), "Fede");
//		contenedor.configurate(int.class, 25);
//		ArrayList<Class<?>> listaDependencias =new ArrayList<Class<?>>();
//		listaDependencias.add("".getClass());
//		listaDependencias.add(int.class);
//		contenedor.agregarDependencia(Persona.class, listaDependencias);
		
	}
	
	@Test
	public void testContenedorSetter() throws Exception {
		contenedor.setEstrategia(new PorSetter());
		PersonaService personita = (PersonaService) contenedor.dameUnObjeto(PersonaService.class);
		Assert.assertEquals("Franco", personita.getPersonaHome().getUsuario());
	}
	
	@Test
	public void testCPersonaServiceTieneUnPersonaDataBaseHome() throws Exception {
		PersonaService personaService = (PersonaService) contenedor.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(PersonaDataBaseHome.class, personaService.getPersonaHome().getClass());
	}
	
//	@Test
//	public void testContenedorObjetos() throws Exception {
//		contenedor = new PorSetter();
//		contenedor.configurate(PersonaHome.class, PersonaDataBaseHome.class);
//		contenedor.configurate("Usuario","".getClass(),"Fede");
//		contenedor.configurate("Password","".getClass(),"AguanteEsteGrupo");
//		contenedor.configurate("Host","".getClass(),"ElHost");
//		contenedor.configurate("Puerto",int.class,1234);
//		contenedor.configurate("Esquema","".getClass(),"Blah");
//		contenedor.agregarDependencia(PersonaHome.class,"Usuario");
//		contenedor.agregarDependencia(PersonaHome.class,"Password");
//		contenedor.agregarDependencia(PersonaHome.class,"Host");
//		contenedor.agregarDependencia(PersonaHome.class,"Puerto");
//		contenedor.agregarDependencia(PersonaHome.class,"Esquema");
//	
//		PersonaDataBaseHome persoDB = (PersonaDataBaseHome) contenedor.dameUnObjeto(PersonaHome.class);
//		Assert.assertEquals("Fede", persoDB.getUsuario());
//	}
	
	@Test
	public void testPersona() throws Exception {
		Persona personita = (Persona) contenedor.dameUnObjeto(Persona.class);
		Assert.assertEquals(25, personita.getEdad());
	}
}
