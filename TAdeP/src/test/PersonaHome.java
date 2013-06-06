package test;

public interface PersonaHome {

	public String getUsuario();
	
	public String getPassword();
	
	public String getHost();
	
	public int getPuerto();
	
	public String getEsquema();

	public void setUsuario(String nombre);
	
	public void setPassword(String password);
	
	public void setHost(String host);
	
	public void setPuerto(int puerto);
	
	public void setEsquema(String esquema);
}
