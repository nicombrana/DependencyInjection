import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class testPersonasHome {

	@Before
	public void setUp() throws Exception {
		Contenedor cont = new Contenedor();
		Persona pers1 = new Persona("nico");
		Persona pers2 = new Persona("nahu");
		PersonaMock persMock = new PersonaMock();
		persMock.agregarPersona(pers1);
		persMock.agregarPersona(pers2);
		cont.cuandoTePidanPone("home de personas", persMock);
		PersonaService persoService = new PersonaService();
	}

	@Test
	public void testElNombreDeUnaPersona(){
		PersonaHome personas = cont.dameUnObjeto("home de personas");
		Persona persona = personas.damePersona();
		this.assertEquals(persona.getUsuario(),"nico");
	}
	
	@Test
	public void testQueUnaPersonaSeaPelado() {
		p = persService.dameunPelado();
		this.assertEquals(p.nombre(),"nico");
	}

	
	@After
	public void tearDown() throws Exception {
		
	}
}
