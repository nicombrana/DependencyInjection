package test;
//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import src.Contenedor;
import src.Persona;
//import src.PersonaDataBaseHome;
import src.PersonaMock;
import src.PersonaService;
import src.PersonaHome;


public class TestPersonasHome {

	private Contenedor cont;
	private PersonaService persoService;
	
	
	@Before
	public void setUp() throws Exception {
		cont = new Contenedor();
		Persona pers1 = new Persona("nico");
		Persona pers2 = new Persona("nahu");
		PersonaMock persMock = new PersonaMock();
		persMock.agregarPersona(pers1);
		persMock.agregarPersona(pers2);
		cont.cuandoTePidanPone("home de personas", persMock);
		persoService = new PersonaService();
	}

	@Test
	public void testElNombreDeUnaPersona(){
		PersonaHome personas = (PersonaHome) cont.dameUnObjeto("home de personas");
		Persona persona = personas.damePersona();
		Assert.assertEquals(persona.getUsuario(),"nico");
	}
	
	@Test
	public void testQueUnaPersonaSeaPelado() {
		Persona p = persoService.dameUnPelado();
		Assert.assertEquals(p.getUsuario(),"nico");
	}

	
	@After
	public void tearDown() throws Exception {
		
	}
}
