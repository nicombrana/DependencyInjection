package test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.ContenedorSetter;

public class TestContenedorSetter {
	
	private ContenedorSetter contSet;
	
	@Before
	public void setUp() throws Exception {
		contSet = new ContenedorSetter();
		contSet.configurate(PersonaHome.class, PersonaDataBaseMock.class);
		contSet.configurate(PersonaService.class, PersonaService.class);
		contSet.configurate("Usuario",String.class,"Franco");
		contSet.configurate("Password",String.class,"VamosQueFunca!");
		contSet.configurate("Host",String.class,"ElHost");
		contSet.configurate("Puerto",int.class,1234);
		contSet.configurate("Esquema",String.class,"Blah");
		contSet.agregarDependencia(PersonaService.class,PersonaHome.class);
		contSet.agregarDependencia(PersonaHome.class,"Usuario");
		contSet.agregarDependencia(PersonaHome.class,"Password");
		contSet.agregarDependencia(PersonaHome.class,"Host");
		contSet.agregarDependencia(PersonaHome.class,"Puerto");
		contSet.agregarDependencia(PersonaHome.class,"Esquema");
		
	}
	
	@Test
	public void testContenedorSetter() throws Exception {
		PersonaService personita = (PersonaService) contSet.dameUnObjeto(PersonaService.class);
		Assert.assertEquals("Franco", personita.getPersonaHome().getUsuario());
	}
	
	@Test
	public void testCPersonaServiceTieneUnPersonaDataBaseMock() throws Exception {
		PersonaService personaService = (PersonaService) contSet.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(PersonaDataBaseMock.class, personaService.getPersonaHome().getClass());
	}
	
	@Test
	public void testContenedorObjetos() throws Exception {
		contSet = new ContenedorSetter();
		contSet.configurate(PersonaDataBaseHome.class, PersonaDataBaseHome.class);
		contSet.configurate("Usuario",String.class,"Fede");
		contSet.configurate("Password",String.class,"AguanteEsteGrupo");
		contSet.configurate("Host",String.class,"ElHost");
		contSet.configurate("Puerto",int.class,1234);
		contSet.configurate("Esquema",String.class,"Blah");
		contSet.agregarDependencia(PersonaDataBaseHome.class,"Usuario");
		contSet.agregarDependencia(PersonaDataBaseHome.class,"Password");
		contSet.agregarDependencia(PersonaDataBaseHome.class,"Host");
		contSet.agregarDependencia(PersonaDataBaseHome.class,"Puerto");
		contSet.agregarDependencia(PersonaDataBaseHome.class,"Esquema");
	
		PersonaDataBaseHome persoDB = (PersonaDataBaseHome) contSet.dameUnObjeto(PersonaDataBaseHome.class);
		Assert.assertEquals("Fede", persoDB.getUsuario());
	}
}
