package vivimosJava.model;

public class TestimonialesDTO {
	private int idtestimoniales;
	private String info;
	private String tipo_negocio;
	private String nombre;
	public int getIdtestimonials() {
		return idtestimoniales;
	}
	public void setIdtestimonials(int idtestimoniales) {
		this.idtestimoniales = idtestimoniales;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getTipo_negocio() {
		return tipo_negocio;
	}
	public void setTipo_negocio(String tipo_negocio) {
		this.tipo_negocio = tipo_negocio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TestimonialesDTO() {
	}
	public TestimonialesDTO(String info, String tipo_negocio, String nombre) {
		this.info = info;
		this.tipo_negocio = tipo_negocio;
		this.nombre = nombre;
	}
	public TestimonialesDTO(int idtestimoniales, String info, String tipo_negocio, String nombre) {
		this.idtestimoniales = idtestimoniales;
		this.info = info;
		this.tipo_negocio = tipo_negocio;
		this.nombre = nombre;
	}
	
	
}
