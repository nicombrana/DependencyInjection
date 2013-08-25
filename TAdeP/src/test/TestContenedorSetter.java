package test;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.Contenedor;
import src.PorSetter;

public class TestContenedorSetter {

	private Contenedor contenedor;

	@Before
	public void setUp() throws Exception {
		contenedor = new Contenedor();
	}

	private void configurarPersonaService() throws Exception {
		contenedor.configurate(PersonaHome.class, PersonaDataBaseHome.class);
		contenedor.configurate(PersonaService.class, PersonaService.class);
		contenedor.configurate("Usuario", "".getClass(), "Franco");
		contenedor.configurate("Password", "".getClass(), "VamosQueFunca!");
		contenedor.configurate("Host", "".getClass(), "ElHost");
		contenedor.configurate("Puerto", Integer.class, 1234);
		contenedor.configurate("Esquema", "".getClass(), "Blah");
		contenedor.agregarDependencia(PersonaService.class, PersonaHome.class);
		contenedor.agregarDependencia(PersonaHome.class, "Usuario");
		contenedor.agregarDependencia(PersonaHome.class, "Password");
		contenedor.agregarDependencia(PersonaHome.class, "Host");
		contenedor.agregarDependencia(PersonaHome.class, "Puerto");
		contenedor.agregarDependencia(PersonaHome.class, "Esquema");
	}

	private void configurarPersona() throws Exception {
		contenedor.configurate(Persona.class, Persona.class);
		contenedor.configurate("".getClass(), "Fede");
		contenedor.configurate(Integer.class, 25);
		ArrayList<Class<?>> listaDependencias = new ArrayList<Class<?>>();
		listaDependencias.add("".getClass());
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
	public void testPersonaPorSetter() throws Exception {
		contenedor.setEstrategia(new PorSetter());
		configurarPersona();
		Persona personita = (Persona) contenedor.dameUnObjeto(Persona.class);
		Assert.assertEquals("Fede", personita.getNombre());
	}

}
