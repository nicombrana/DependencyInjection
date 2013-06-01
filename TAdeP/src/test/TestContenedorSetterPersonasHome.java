package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import src.ContenedorSetter;
import src.Persona;
import src.PersonaDataBaseMock;
import src.PersonaService;

public class TestContenedorSetterPersonasHome {

	private ContenedorSetter cont;
	private PersonaDataBaseMock persMock;
	private PersonaService persoService;
		
	@Before
	public void setUp() throws Exception {
		cont = new ContenedorSetter();
		Persona pers1 = new Persona("nico");
		Persona pers2 = new Persona("nahu");
		persMock = new PersonaDataBaseMock();
		persMock.agregarPersona(pers1);
		persMock.agregarPersona(pers2);
		cont.cuandoTePidanPone("home de personas", persMock);
		PersonaDataBaseMock persoMock = (PersonaDataBaseMock) cont.dameUnObjeto("home de personas");
		persoService = new PersonaService();
		persoService.setPersonaHome(persoMock);
	}

	@Test
	public void testElNombreDeUnaPersona(){
		Assert.assertEquals(persoService.nombreDeUnUsuario(),"nico");
	}
	
	@Test
	public void testQueUnaPersonaSeaPelado() {
		Persona p =((PersonaDataBaseMock) persoService.getPersonaHome()).dameUnPelado(1);
		Assert.assertEquals(p.getUsuario(),"nahu");
	}

	
	@After
	public void tearDown() throws Exception {
		
	}
}
