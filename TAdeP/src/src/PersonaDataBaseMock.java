package src;


public class PersonaDataBaseMock implements PersonaHome {
	
	private String usuario = "Franco";
	private String password = "UTNTAdP";
	private String host = "esteGrupoEsElMejor";
	private int puerto = 1234;
	private String esquema = "NoSeQuePoner";
	
	
	
	@Override
	public String getUsuario() {
		return usuario;
	}


}
