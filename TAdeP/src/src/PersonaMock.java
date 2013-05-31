package src;
import java.util.ArrayList;


public class PersonaMock implements PersonaHome {

	private ArrayList<Persona> personas;
	
	public PersonaMock() {
		this.personas = new ArrayList<Persona>();
	}
	
	public void agregarPersona(Persona persona){
		this.personas.add(persona);
	}
	
	public Persona damePersona(){
		return this.personas.get(0);
	}
	
	public Persona dameUnPelado(){
		return this.personas.get(1);
	}

}
