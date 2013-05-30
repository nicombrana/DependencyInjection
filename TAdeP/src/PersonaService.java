
public class PersonaService {

	private PersonaHome homeDePersona;
	
	public PersonaService(PersonaHome personaHome) {
		this.homeDePersona = personaHome;
	}

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
