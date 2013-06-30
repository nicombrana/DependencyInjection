package test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.ContenedorAtributos;

//FIXME No es property, es field
public class TestContenedorProperties {
	
	
	
	private ContenedorAtributos contProperties;
	
	@Before
	public void setUp() throws Exception {
		contProperties = new ContenedorAtributos();
		
//		contProperties.agregarDependencia(tipoInyectable, tiposDependencia)
		
		
		contProperties.configurate(PersonaHome.class, PersonaDataBaseMock.class);
		contProperties.configurate(PersonaService.class, PersonaService.class);
		contProperties.configurate("Usuario",String.class,"Franco");
		contProperties.configurate("Password",String.class,"VamosQueFunca!");
		contProperties.configurate("Host",String.class,"ElHost");
		contProperties.configurate("Puerto",int.class,1234);
		contProperties.configurate("Esquema",String.class,"Blah");
		contProperties.agregarDependencia(PersonaService.class,PersonaHome.class);
		contProperties.agregarDependencia(PersonaHome.class,"Usuario");
		contProperties.agregarDependencia(PersonaHome.class,"Password");
		contProperties.agregarDependencia(PersonaHome.class,"Host");
		contProperties.agregarDependencia(PersonaHome.class,"Puerto");
		contProperties.agregarDependencia(PersonaHome.class,"Esquema");
		
	}
	
	@Test
	public void instanciacionSimple() throws Exception {
//		contProperties.configurate("unFoo", Foo.class); //FIXME porqué tengo que pasar el tipo? Quisiera por hacer esto!
		contProperties.configurate(Foo.class, Foo.class);
		// contProperties.agregarDependencia(Foo.class, 9) FIXME no puedo decir esto tampoco!
		contProperties.configurate("bar", int.class, 9); //FIXME tengo que ponerle a la dependencia el mismo nombre que el atributo. Eso esmuy limitante
		contProperties.agregarDependencia(Foo.class, "bar");

		
		Foo foo = (Foo)contProperties.dameUnObjeto(Foo.class); //FIXME no puedo obtener objetos por id!
		assertEquals(9, foo.bar);
	}
	
	@Test(expected=InstantiationException.class)
	public void deberiaTenerUnReporteDeErroresRazonable() throws Exception {
		contProperties.configurate(Foo.class, Foo.class);
		contProperties.configurate("bar", int.class, 9); 
		contProperties.agregarDependencia(Foo.class, "otroBar"); 
		contProperties.dameUnObjeto(Foo.class);
	}
	
	//FIXME hay tests que fallan
	@Test
	public void testContenedorProperties() throws Exception {
		PersonaService personaService = (PersonaService) contProperties.dameUnObjeto(PersonaService.class);
		Assert.assertEquals("Franco", personaService.getPersonaHome().getUsuario());
	}
	
	@Test
	public void testPersonaServiceTieneUnPersonaDataBaseMock() throws Exception {
		PersonaService personaService = (PersonaService) contProperties.dameUnObjeto(PersonaService.class);
		Assert.assertEquals(PersonaDataBaseMock.class, personaService.getPersonaHome().getClass());
	}
	
	@Test
	public void testHayObjetosHelper(){
		Assert.assertTrue(contProperties.getDiccionarioObjetoHelper().containsKey("Usuario"));
	}
	
	@Test
	public void testContenedorObjetos() throws Exception {
		contProperties = new ContenedorAtributos();
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
