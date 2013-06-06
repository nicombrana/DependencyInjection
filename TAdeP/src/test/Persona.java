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

	public void setUsuario(String nombre){
		this.usuario = nombre;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setHost(String host){
		this.host = host;
	}
	
	public void setPuerto(int puerto){
		this.puerto = puerto;
	}
	
	public void setEsquema(String esquema){
		this.esquema = esquema;
	}
}
