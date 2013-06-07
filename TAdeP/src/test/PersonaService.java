package test;

public class PersonaService {

	public PersonaHome personaDataBaseHome;
	
	public PersonaService(){
	}	
	
	
	public PersonaService(PersonaHome personaHome) {
		this.personaDataBaseHome = personaHome;
	}

	// Getters & Setters
	public void setPersonaHome(PersonaHome personaHome){
		this.personaDataBaseHome = personaHome;
	}
		
	public PersonaHome getPersonaHome(){
		return this.personaDataBaseHome;
	}
	
}
