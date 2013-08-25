package test;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.Contenedor;
import src.PorConstructor;
import src.PorSetter;

public class TestContenedor {

	private Contenedor contenedor;

	@Before
	public void setUp() throws Exception {
		contenedor = new Contenedor();
	}

	private void configurarPersonaService() throws Exception {
		contenedor.configurate(PersonaHome.class, PersonaDataBaseHome.class);
		contenedor.configurate(PersonaService.class, PersonaService.class);
		contenedor.configurate("Usuario", String.class, "Franco");
		contenedor.configurate("Password",String.class, "VamosQueFunca!");
		contenedor.configurate("Host", String.class, "ElHost");
		contenedor.configurate("Puerto", Integer.class, 1234);
		contenedor.configurate("Esquema", String.class, "Blah");
		contenedor.agregarDependencia(PersonaService.class, PersonaHome.class);
		contenedor.agregarDependencia(PersonaHome.class, "Usuario");
		contenedor.agregarDependencia(PersonaHome.class, "Password");
		contenedor.agregarDependencia(PersonaHome.class, "Host");
		contenedor.agregarDependencia(PersonaHome.class, "Puerto");
		contenedor.agregarDependencia(PersonaHome.class, "Esquema");
	}

	private void configurarPersona() throws Exception {
		contenedor.configurate(Persona.class, Persona.class);
		contenedor.configurate(String.class, "Fede");
		contenedor.configurate(Integer.class, 25);
		ArrayList<Class<?>> listaDependencias = new ArrayList<Class<?>>();
		listaDependencias.add(String.class);
		listaDependencias.add(Integer.class);
		contenedor.agregarDependencia(Persona.class, listaDependencias);
	}
	
	@Test
	public void testPersonaServicePorSetter() throws Exception {
		contenedor.setEstrategia(new PorSetter());
		configurarPersonaService();
		PersonaService personaService = (PersonaService) contenedor
				.dameUnObjeto(PersonaService.class);
		Assert.assertEquals("Franco", personaService.getPersonaHome().getUsuario());
	}
	
	@Test
	public void testPersonaServicePorConstructor() throws Exception {
		contenedor.setEstrategia(new PorConstructor());
		configurarPersonaService();
		PersonaService personaService = (PersonaService) contenedor
				.dameUnObjeto(PersonaService.class);
		Assert.assertEquals("Franco", personaService.getPersonaHome().getUsuario());
	}

	@Test
	public void testPersonaPorSetter() throws Exception {
		contenedor.setEstrategia(new PorSetter());
		configurarPersona();
		Persona personita = (Persona) contenedor.dameUnObjeto(Persona.class);
		Assert.assertEquals("Fede", personita.getNombre());
	}
	
	@Test
	public void testPersonaPorConstructor() throws Exception {
		contenedor.setEstrategia(new PorConstructor());
		configurarPersona();
		Persona personita = (Persona) contenedor.dameUnObjeto(Persona.class);
		Assert.assertEquals("Fede", personita.getNombre());
	}

}
