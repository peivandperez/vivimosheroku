package vivimosJava.model;

public class PropiedadesTestingDTO {
	private int idpropiedadesTesting;
	private String direccion;
	private String precio;
	private String tipologia;
	
	public int getIdpropiedadesTesting() {
		return idpropiedadesTesting;
	}
	public void setIdpropiedadesTesting(int idpropiedadesTesting) {
		this.idpropiedadesTesting = idpropiedadesTesting;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public PropiedadesTestingDTO(String direccion, String precio, String tipologia) {
		this.direccion = direccion;
		this.precio = precio;
		this.tipologia = tipologia;
	}
	public PropiedadesTestingDTO() {
	}
	
	
}
