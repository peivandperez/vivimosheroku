package vivimosJava.service;

import java.util.List;
import vivimosJava.model.TestimonialesDTO;

public interface TestimonialesService {
	public List<TestimonialesDTO> todas();
	public List<TestimonialesDTO> findByNegocio(String tipo_negocio);
}
