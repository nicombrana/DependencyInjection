package test;

public class Persona {
	
	private String nombre;
	private int edad;
		
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
	}

	//Getters & Setters
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
}	