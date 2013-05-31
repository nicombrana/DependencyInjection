package src;

public class PersonaService {

	private PersonaHome homeDePersona;
	
	public PersonaService(){
	}	
	public PersonaService(PersonaHome personaHome) {
		this.homeDePersona = personaHome;
	}

	// Getters & Setters
	public void setPersona(PersonaHome personaHome){
		this.homeDePersona = personaHome;
	}
		
	public PersonaHome getPersona(){
		return this.homeDePersona;
	}
	
	public String nombreDeUnUsuario(){
		return this.getPersona().damePersona().getUsuario();
	}
	
}
