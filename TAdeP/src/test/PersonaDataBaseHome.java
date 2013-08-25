package test;

public class PersonaDataBaseHome implements PersonaHome {


	public String usuario;
	public String password;
	public String host;
	public Integer puerto;
	public String esquema;
	
	public PersonaDataBaseHome(){
		
	}
	
	public PersonaDataBaseHome(String usuario, String password, String host,
			Integer puerto, String esquema) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.host = host;
		this.puerto = puerto;
		this.esquema = esquema;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPuerto() {
		return puerto;
	}

	public void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}

	public String getEsquema() {
		return esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}


}
