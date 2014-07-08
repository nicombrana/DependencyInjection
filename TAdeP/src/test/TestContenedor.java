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
	  //FIXME procuren ser consistentes con el uso del idioma: o todo inglés, o todo español (configurate vs agregarDependencia)
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

	private void configurarPersonaFede() throws Exception {
		contenedor.configurate(Persona.class, Persona.class);
		contenedor.configurate(String.class, "Fede");
		contenedor.configurate(Integer.class, 25);
		//FIXME tema de estilo: 
		//es mucho más comodo escribir Arrays.asList(String.class, Integer.class) que 
		//instanciar una lista y agregar los elementos a mano
		ArrayList<Class<?>> listaDependencias = new ArrayList<Class<?>>();
		listaDependencias.add(String.class);
		listaDependencias.add(Integer.class);
		contenedor.agregarDependencia(Persona.class, listaDependencias);
	}
	
	private void configurarPersonaFranco() throws Exception {
		contenedor.configurate(Persona.class, Persona.class);
		//FIXME su mecanismo de especificación de dependencias es muy endeble, ya que determina a dónde va a parar
		//la dependencia a partir del tipo la dependencia: ¿qué pasa si tienen dos atributos del mismo tipo en persona?
		//Por ejemplo, miren que fácil rompí su test: tan sólo agregué una property String foo en persona. 
		//Y es aún peor: dado que el orden en reflection lee los atributos y métodos no está determinado, este test ahora a veces
		//da verde, a veces de rojo
		
		//Tanto en agregarDependenciaConValor como en agregarDependencia, deberían especificar tres cosas: la referencia
		//a la que agregarle la dependencia, el valor de o referencia a la dependencia, y el nombre de la misma. Es decir, debería ser 
		//un mensaje de aridad 3. 
		contenedor.agregarDependenciaConValor(Persona.class, "Franco");
		contenedor.agregarDependenciaConValor(Persona.class, 28);
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
		//FIXME sería interesante que no hubiera que castear, sino que tome 
		//el tipo de retorno a partir del tipo del parámetro. 
		//Algo del siguiente estilo: <A> A dameUnObjeto(Class<A> tipo) 
		PersonaService personaService = (PersonaService) contenedor
				.dameUnObjeto(PersonaService.class);
		Assert.assertEquals("Franco", personaService.getPersonaHome().getUsuario());
	}

	@Test
	public void testPersonaPorSetter() throws Exception {
		contenedor.setEstrategia(new PorSetter());
		configurarPersonaFede();
		Persona personita = (Persona) contenedor.dameUnObjeto(Persona.class);
		Assert.assertEquals("Fede", personita.getNombre());
	}
	
	@Test
	public void testPersonaPorConstructor() throws Exception {
		contenedor.setEstrategia(new PorConstructor());
		configurarPersonaFranco();
		Persona personita = (Persona) contenedor.dameUnObjeto(Persona.class);
		//FIXME una boludez: usen el import org.junit y no junit.framework
		Assert.assertEquals("Franco", personita.getNombre());
	}

}
