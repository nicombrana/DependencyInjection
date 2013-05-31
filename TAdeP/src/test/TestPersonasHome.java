package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import src.Contenedor;
import src.Persona;
import src.PersonaMock;
import src.PersonaService;

public class TestPersonasHome {

	private Contenedor cont;
	private PersonaMock persMock;
	//private PersonaMock personas;
	private PersonaService persoService;
		
	@Before
	public void setUp() throws Exception {
		cont = new Contenedor();
		Persona pers1 = new Persona("nico");
		Persona pers2 = new Persona("nahu");
		persMock = new PersonaMock();
		persMock.agregarPersona(pers1);
		persMock.agregarPersona(pers2);
		cont.cuandoTePidanPone("home de personas", persMock);
		persoService = new PersonaService((PersonaMock)cont.dameUnObjeto("home de personas"));
	}

	@Test
	public void testElNombreDeUnaPersona(){
		//personas = (PersonaMock) cont.dameUnObjeto("home de personas");
		//Persona persona = personas.damePersona();
		Assert.assertEquals(persoService.nombreDeUnUsuario(),"nico");//persona.getUsuario()
	}
	
	@Test
	public void testQueUnaPersonaSeaPelado() {
		Persona p =((PersonaMock) persoService.getPersonaHome()).dameUnPelado();
		Assert.assertEquals(p.getUsuario(),"nahu");
	}

	
	@After
	public void tearDown() throws Exception {
		
	}
}
