package src;
import java.util.ArrayList;


public class PersonaMock {

	private ArrayList<Persona> personas;
	
	public PersonaMock() {
	}
	
	public void agregarPersona(Persona persona){
		this.personas.add(persona);
	}
	
	public Persona damePersona(){
		return this.personas.get(0);
	}

}
