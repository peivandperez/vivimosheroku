package vivimosJava.model;

public class InversionistasTestingDTO {
	private int idlista_completa;
	private String nombre;
	private String apellido;
	private String mail;
	
	
	public int getIdlista_completa() {
		return idlista_completa;
	}
	public void setId(int id) {
		this.idlista_completa = idlista_completa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public InversionistasTestingDTO(String nombre, String apellido, String mail) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
	}
	public InversionistasTestingDTO() {
	}
	
	
}
