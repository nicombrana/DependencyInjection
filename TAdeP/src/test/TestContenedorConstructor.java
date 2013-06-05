package test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.ContenedorConstructor;

public class TestContenedorConstructor {
	
	private ContenedorConstructor contCons;
	
	@Before
	public void setUp() throws Exception {
		contCons = new ContenedorConstructor();
		contCons.configurate(PersonaHome.class, PersonaDataBaseMock.class);
		contCons.configurate(PersonaService.class, PersonaService.class);
		contCons.agregarDependencia(PersonaHome.class);
	}
	
	@Test
	public void testContenedorConstructor() throws Exception {
		PersonaService personita = (PersonaService) contCons.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(personita.getPersonaHome().getUsuario(), "Franco");
	}
}
