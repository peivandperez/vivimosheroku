package vivimosJava.model;

import java.util.Arrays;

public class ImagesDTO {
	
	private int id;
	private String name;
	private int idpropiedad;
	private String filepath;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdpropiedad() {
		return idpropiedad;
	}
	public void setIdpropiedad(int idpropiedad) {
		this.idpropiedad = idpropiedad;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public ImagesDTO(String name, int idpropiedad, String filepath) {
		this.name = name;
		this.idpropiedad = idpropiedad;
		this.filepath = filepath;
	}
	public ImagesDTO() {
	}
	@Override
	public String toString() {
		return "ImagesDTO [id=" + id + ", name=" + name + ", idpropiedad=" + idpropiedad + ", filepath=" + filepath
				+ "]";
	}
	
	
	
	

	
	
	

}
