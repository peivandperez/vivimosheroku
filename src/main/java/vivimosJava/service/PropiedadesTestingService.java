package vivimosJava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vivimosJava.model.PropiedadesTestingDTO;


public interface PropiedadesTestingService {
	public List<PropiedadesTestingDTO> listTodas();
	public PropiedadesTestingDTO findById(int id);
	public PropiedadesTestingDTO findByDireccion(String direccion);
}
