package test;

public class Persona {
	
	private String nombre;
	private Integer edad;
		
	private String foo;
	public String getFoo() {
      return foo;
    }
	public void setFoo(String foo) {
      this.foo = foo;
    }
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String nombre, Integer edad){
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
	
	public Integer getEdad() {
		return edad;
	}
	
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
}	