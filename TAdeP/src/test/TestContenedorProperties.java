package test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.ContenedorProperties;

public class TestContenedorProperties {
	
	private ContenedorProperties contProperties;
	
	@Before
	public void setUp() throws Exception {
		contProperties = new ContenedorProperties();
		contProperties.configurate(PersonaDataBaseHome.class, PersonaDataBaseMock.class);
		contProperties.configurate(PersonaService.class, PersonaService.class);
		contProperties.configurate("Usuario",String.class,"Franco");
		contProperties.configurate("Password",String.class,"VamosQueFunca!");
		contProperties.configurate("Host",String.class,"ElHost");
		contProperties.configurate("Puerto",int.class,1234);
		contProperties.configurate("Esquema",String.class,"Blah");
		contProperties.agregarDependencia(PersonaService.class,PersonaDataBaseHome.class);
		contProperties.agregarDependencia(PersonaDataBaseHome.class,"Usuario");
		contProperties.agregarDependencia(PersonaDataBaseHome.class,"Password");
		contProperties.agregarDependencia(PersonaDataBaseHome.class,"Host");
		contProperties.agregarDependencia(PersonaDataBaseHome.class,"Puerto");
		contProperties.agregarDependencia(PersonaDataBaseHome.class,"Esquema");
		
	}
	
	@Test
	public void testContenedorSetter() throws Exception {
		PersonaService personaService = (PersonaService) contProperties.dameUnObjeto(PersonaService.class);
		Assert.assertEquals("Franco", personaService.getPersonaHome().getUsuario());
	}
	
	@Test
	public void testContenedorSetterTieneUnPersonaDataBaseMock() throws Exception {
		PersonaService personaService = (PersonaService) contProperties.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(PersonaDataBaseMock.class, personaService.getPersonaHome().getClass());
	}
	
	@Test
	public void testContenedorObjetos() throws Exception {
		contProperties = new ContenedorProperties();
		contProperties.configurate(PersonaDataBaseHome.class, PersonaDataBaseHome.class);
		contProperties.configurate("Usuario",String.class,"Fede");
		contProperties.configurate("Password",String.class,"AguanteEsteGrupo");
		contProperties.configurate("Host",String.class,"ElHost");
		contProperties.configurate("Puerto",int.class,1234);
		contProperties.configurate("Esquema",String.class,"Blah");
		contProperties.agregarDependencia(PersonaDataBaseHome.class,"Usuario");
		contProperties.agregarDependencia(PersonaDataBaseHome.class,"Password");
		contProperties.agregarDependencia(PersonaDataBaseHome.class,"Host");
		contProperties.agregarDependencia(PersonaDataBaseHome.class,"Puerto");
		contProperties.agregarDependencia(PersonaDataBaseHome.class,"Esquema");
	
		PersonaDataBaseHome persoDB = (PersonaDataBaseHome) contProperties.dameUnObjeto(PersonaDataBaseHome.class);
		Assert.assertEquals("Fede", persoDB.getUsuario());
	}
	
}
