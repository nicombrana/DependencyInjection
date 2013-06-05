package test;

public class Persona {
	private String usuario;
	private String password;
	private String host;
	private int puerto;
	private String esquema;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String nombre){
		this.usuario = nombre;
	}

	//Getters
	public String getUsuario(){
		return this.usuario;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getHost(){
		return this.host;
	}
	
	public int getPuerto(){
		return this.puerto;
	}
	
	public String getEsquema(){
		return this.esquema;
	}

}
