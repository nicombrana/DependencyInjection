package test;


public class PersonaDataBaseMock extends PersonaDataBaseHome {
	

	public PersonaDataBaseMock(String usuario, String password, String host,
			int puerto, String esquema) {
		super(usuario, password, host, puerto, esquema);
		// TODO Auto-generated constructor stub
	}

	public String usuario;
	public String password;
	public String host;
	public Integer puerto;
	public String esquema;
	
	

}
