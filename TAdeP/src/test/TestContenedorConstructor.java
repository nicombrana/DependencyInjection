package test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.PorConstructor;

public class TestContenedorConstructor {
	
	private PorConstructor contConstructor;
	
	@Before
	public void setUp() throws Exception {
		contConstructor = new PorConstructor();
		contConstructor.configurate(PersonaHome.class, PersonaDataBaseHome.class);
		contConstructor.configurate(PersonaService.class, PersonaService.class);
		contConstructor.configurate("Usuario","".getClass(),"Franco");
		contConstructor.configurate("Password","".getClass(),"VamosQueFunca!");
		contConstructor.configurate("Host","".getClass(),"ElHost");
		contConstructor.configurate("Puerto",int.class,1234);
		contConstructor.configurate("Esquema","".getClass(),"Blah");
		contConstructor.agregarDependencia(PersonaService.class,PersonaHome.class);
		contConstructor.agregarDependencia(PersonaHome.class,"Usuario");
		contConstructor.agregarDependencia(PersonaHome.class,"Password");
		contConstructor.agregarDependencia(PersonaHome.class,"Host");
		contConstructor.agregarDependencia(PersonaHome.class,"Puerto");
		contConstructor.agregarDependencia(PersonaHome.class,"Esquema");
	}
	
	@Test
	public void testContenedorConstructor() throws Exception {
		PersonaService personita = (PersonaService) contConstructor.dameUnObjeto(PersonaService.class);
		Assert.assertEquals("Franco", personita.getPersonaHome().getUsuario());
	}
	
	@Test
	public void testPersonaServiceTieneUnPersonaDataBaseMock() throws Exception {
		PersonaService personaService = (PersonaService) contConstructor.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(PersonaDataBaseHome.class, personaService.getPersonaHome().getClass());
	}
	
	@Test
	public void testContenedorObjetos() throws Exception {
		contConstructor = new PorConstructor();
		contConstructor.configurate(PersonaHome.class, PersonaDataBaseHome.class);
		contConstructor.configurate("Usuario","".getClass(),"Fede");
		contConstructor.configurate("Password","".getClass(),"AguanteEsteGrupo");
		contConstructor.configurate("Host","".getClass(),"ElHost");
		contConstructor.configurate("Puerto",int.class,1234);
		contConstructor.configurate("Esquema","".getClass(),"Blah");
		contConstructor.agregarDependencia(PersonaHome.class,"Usuario");
		contConstructor.agregarDependencia(PersonaHome.class,"Password");
		contConstructor.agregarDependencia(PersonaHome.class,"Host");
		contConstructor.agregarDependencia(PersonaHome.class,"Puerto");
		contConstructor.agregarDependencia(PersonaHome.class,"Esquema");
	
		PersonaDataBaseHome persoDB = (PersonaDataBaseHome) contConstructor.dameUnObjeto(PersonaHome.class);
		Assert.assertEquals("Fede", persoDB.getUsuario());
	}
	
}
