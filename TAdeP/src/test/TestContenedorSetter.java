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
		contSet.configurate("Usuario",String.class,"Fede");
		contSet.configurate("Password",String.class,"VamosQueFunca!");
		contSet.configurate("Host",String.class,"ElHost");
		contSet.configurate("Puerto",int.class,1234);
		contSet.configurate("Esquema",String.class,"Blah");
		contSet.agregarDependencia(PersonaService.class,PersonaHome.class);
//		contSet.agregarDependencia(PersonaHome.class,"Usuario");
//		contSet.agregarDependencia(PersonaHome.class,"Password");
//		contSet.agregarDependencia(PersonaHome.class,"Host");
//		contSet.agregarDependencia(PersonaHome.class,"Puerto");
//		contSet.agregarDependencia(PersonaHome.class,"Esquema");
		
	}
	
	@Test
	public void testContenedorSetter() throws Exception {
		PersonaService personita = (PersonaService) contSet.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(personita.getPersonaHome().getUsuario(), "Franco");
	}
	
//	@Test
//	public void testContenedorObjetos() throws Exception {
//		contSet = new ContenedorSetter();
//		contSet.configurate(PersonaDataBaseHome.class, PersonaDataBaseHome.class);
//		contSet.configurate("Usuario","Fede");
//		contSet.configurate("Password","AguanteEsteGrupo");
//		contSet.configurate("Host","elHost");
//		contSet.configurate("Puerto",1234);
//		contSet.configurate("Esquema","Blah");

//		contSet.agregarDependencia("Usuario");
//		contSet.agregarDependencia("Password");
//		contSet.agregarDependencia("Host");
//		contSet.agregarDependencia("Puerto");
//		contSet.agregarDependencia("Esquema");
//		
//		
//		PersonaDataBaseHome persoDB = (PersonaDataBaseHome) contSet.dameUnObjeto(PersonaDataBaseHome.class);
//		Assert.assertEquals(persoDB.getUsuario(), "Fede");
//	}
}
