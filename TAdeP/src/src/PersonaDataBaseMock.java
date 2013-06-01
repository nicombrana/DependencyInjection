package src;

import java.util.ArrayList;


public class PersonaDataBaseMock implements PersonaHome {

	private ArrayList<Persona> personas;
	
	public PersonaDataBaseMock() {
		this.personas = new ArrayList<Persona>();
	}
	
	public void agregarPersona(Persona persona){
		this.personas.add(persona);
	}
	
	public Persona damePersona(){
		return this.personas.get(0);
	}
	
	public Persona dameUnPelado(int posicion){
		return this.personas.get(posicion);
	}
	
	@Override
	public Persona buscaUnaPersonaPorNombre(String nombre){
		Persona persona = new Persona();
		persona = this.encontraPersona(nombre);
		return persona;
	}
	
	public Persona encontraPersona(String nombre){
		Persona perso = new Persona();
		for (Persona persona : this.personas) {
			if (persona.getUsuario() == nombre) {
				perso = persona;
			}
		}
		return perso;
	}
}
