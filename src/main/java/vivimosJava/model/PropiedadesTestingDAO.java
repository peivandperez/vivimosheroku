package vivimosJava.model;

import java.util.List;

public interface PropiedadesTestingDAO {
	public List<PropiedadesTestingDTO> todas();
	public PropiedadesTestingDTO findById(int id);
}
