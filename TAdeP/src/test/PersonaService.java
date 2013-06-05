package test;

public class PersonaService {

	private PersonaHome homeDePersona;
	
	public PersonaService(){
	}	
	
	
	public PersonaService(PersonaHome personaHome) {
		this.homeDePersona = personaHome;
	}

	// Getters & Setters
	public void setPersonaHome(PersonaHome personaHome){
		this.homeDePersona = personaHome;
	}
		
	public PersonaHome getPersonaHome(){
		return this.homeDePersona;
	}
	
}
