package vivimosJava.service;

import java.util.List;
import vivimosJava.model.PropiedadesTestingDTO;


public interface PropiedadesTestingService {
	public List<PropiedadesTestingDTO> listTodas();
	public PropiedadesTestingDTO findById(int id);
	public PropiedadesTestingDTO findByDireccion(String direccion);
	public PropiedadesTestingDTO findByUrl(String url);
}
