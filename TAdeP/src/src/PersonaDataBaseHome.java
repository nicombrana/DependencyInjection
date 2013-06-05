package src;

public class PersonaDataBaseHome implements PersonaHome {

	private String usuario;
	private String password;
	private String host;
	private int puerto;
	private String esquema;
	
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



	public int getPuerto() {
		return puerto;
	}



	public void setPuerto(int puerto) {
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


	
	
	@Override
	public String getUsuario() {
		return usuario;
	}
		
		
		



	
}
