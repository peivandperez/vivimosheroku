package model.dto;

public class UsersSimple {
	private Integer idusers;
	private String email;
	
	public Integer getIdusers() {
		return idusers;
	}
	public void setIdusers(Integer idusers) {
		this.idusers = idusers;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UsersSimple(Integer idusers, String email) {
		this.idusers = idusers;
		this.email = email;
	}
	public UsersSimple() {
	}
	
	@Override
	public String toString() {
		return "UsersSimple [idusers=" + idusers + ", email=" + email + "]";
	}
	
	
}
