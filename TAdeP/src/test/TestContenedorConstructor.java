package test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.ContenedorConstructor;

public class TestContenedorConstructor {
	
	private ContenedorConstructor contConstructor;
	
	@Before
	public void setUp() throws Exception {
		contConstructor = new ContenedorConstructor();
		contConstructor.configurate(PersonaDataBaseHome.class, PersonaDataBaseMock.class);
		contConstructor.configurate(PersonaService.class, PersonaService.class);
		contConstructor.configurate("Usuario",String.class,"Franco");
		contConstructor.configurate("Password",String.class,"VamosQueFunca!");
		contConstructor.configurate("Host",String.class,"ElHost");
		contConstructor.configurate("Puerto",int.class,1234);
		contConstructor.configurate("Esquema",String.class,"Blah");
		contConstructor.agregarDependencia(PersonaService.class,PersonaDataBaseHome.class);
		contConstructor.agregarDependencia(PersonaDataBaseHome.class,"Usuario");
		contConstructor.agregarDependencia(PersonaDataBaseHome.class,"Password");
		contConstructor.agregarDependencia(PersonaDataBaseHome.class,"Host");
		contConstructor.agregarDependencia(PersonaDataBaseHome.class,"Puerto");
		contConstructor.agregarDependencia(PersonaDataBaseHome.class,"Esquema");
	}
	
	@Test
	public void testContenedorConstructor() throws Exception {
		PersonaService personita = (PersonaService) contConstructor.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(personita.getPersonaHome().getUsuario(), "Franco");
	}
	
	@Test
	public void testPersonaServiceTieneUnPersonaDataBaseMock() throws Exception {
		PersonaService personaService = (PersonaService) contConstructor.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(PersonaDataBaseMock.class, personaService.getPersonaHome().getClass());
	}
	
	@Test
	public void testContenedorObjetos() throws Exception {
		contConstructor = new ContenedorConstructor();
		contConstructor.configurate(PersonaDataBaseHome.class, PersonaDataBaseHome.class);
		contConstructor.configurate("Usuario",String.class,"Fede");
		contConstructor.configurate("Password",String.class,"AguanteEsteGrupo");
		contConstructor.configurate("Host",String.class,"ElHost");
		contConstructor.configurate("Puerto",int.class,1234);
		contConstructor.configurate("Esquema",String.class,"Blah");
		contConstructor.agregarDependencia(PersonaDataBaseHome.class,"Usuario");
		contConstructor.agregarDependencia(PersonaDataBaseHome.class,"Password");
		contConstructor.agregarDependencia(PersonaDataBaseHome.class,"Host");
		contConstructor.agregarDependencia(PersonaDataBaseHome.class,"Puerto");
		contConstructor.agregarDependencia(PersonaDataBaseHome.class,"Esquema");
	
		PersonaDataBaseHome persoDB = (PersonaDataBaseHome) contConstructor.dameUnObjeto(PersonaDataBaseHome.class);
		Assert.assertEquals("Fede", persoDB.getUsuario());
	}
}
