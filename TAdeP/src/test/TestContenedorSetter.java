package test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.ContenedorSetter;
import src.PersonaDataBaseHome;
import src.PersonaDataBaseMock;
import src.PersonaHome;
import src.PersonaService;

public class TestContenedorSetter {
	
	private ContenedorSetter contSet;
	
	@Before
	public void setUp() throws Exception {
		contSet = new ContenedorSetter();
		contSet.configurate(PersonaHome.class, PersonaDataBaseMock.class);
		contSet.configurate(PersonaService.class, PersonaService.class);
		contSet.agregarDependencia(PersonaHome.class);
	}
	
	@Test
	public void testContenedorSetter() throws Exception {
		PersonaService personita = (PersonaService) contSet.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(personita.getPersonaHome().getUsuario(), "Franco");
	}
	
	@Test
	public void testContenedorObjetos() throws Exception {
		contSet = new ContenedorSetter();
		contSet.configurate(PersonaDataBaseHome.class, PersonaDataBaseHome.class);
		contSet.configurate("Usuario","Fede");
		contSet.configurate("Password","AguanteEsteGrupo");
		contSet.configurate("Host","elHost");
		contSet.configurate("Puerto",1234);
		contSet.configurate("Esquema","Blah");
		contSet.configurate("Usuario",String.class);
		contSet.configurate("Password",String.class);
		contSet.configurate("Host",String.class);
		contSet.configurate("Puerto",int.class);
		contSet.configurate("Esquema",String.class);
		contSet.agregarDependencia("Usuario");
		contSet.agregarDependencia("Password");
		contSet.agregarDependencia("Host");
		contSet.agregarDependencia("Puerto");
		contSet.agregarDependencia("Esquema");
		
		
		PersonaDataBaseHome persoDB = (PersonaDataBaseHome) contSet.dameUnObjeto(PersonaDataBaseHome.class);
		Assert.assertEquals(persoDB.getUsuario(), "Fede");
	}
}
