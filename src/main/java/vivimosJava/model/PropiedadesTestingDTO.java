package vivimosJava.model;

public class PropiedadesTestingDTO {
	private int id;
	private String direccion;
	private String precio;
	private String tipologia;
	private String url;
	private String urlImagenPrincipal;
	
	public String getUrlImagenPrincipal() {
		return urlImagenPrincipal;
	}
	public void setUrlImagenPrincipal(String urlImagenPrincipal) {
		this.urlImagenPrincipal = urlImagenPrincipal;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	
	public PropiedadesTestingDTO() {
	}
	public PropiedadesTestingDTO(int id, String direccion, String precio, String tipologia, String url,
			String urlImagenPrincipal) {
		this.id = id;
		this.direccion = direccion;
		this.precio = precio;
		this.tipologia = tipologia;
		this.url = url;
		this.urlImagenPrincipal = urlImagenPrincipal;
	}
	public PropiedadesTestingDTO(String direccion, String precio, String tipologia, String url,
			String urlImagenPrincipal) {
		this.direccion = direccion;
		this.precio = precio;
		this.tipologia = tipologia;
		this.url = url;
		this.urlImagenPrincipal = urlImagenPrincipal;
	}
	@Override
	public String toString() {
		return "PropiedadesTestingDTO [id=" + id + ", direccion=" + direccion + ", precio=" + precio + ", tipologia="
				+ tipologia + ", url=" + url + ", urlImagenPrincipal=" + urlImagenPrincipal + "]";
	}


	
	
	
}
