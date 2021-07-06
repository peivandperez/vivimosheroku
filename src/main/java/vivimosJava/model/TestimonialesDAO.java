package vivimosJava.model;

import java.util.List;

public interface TestimonialesDAO {
	public List<TestimonialesDTO> todas();
	public List<TestimonialesDTO> findByNegocio(String tipo_negocio);
}
