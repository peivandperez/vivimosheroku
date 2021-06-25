package vivimosJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivimosJava.model.PropiedadesTestingDAO;
import vivimosJava.model.TestimonialesDAO;
import vivimosJava.model.TestimonialesDTO;

@Service
public class TestimonialesServiceImpl implements TestimonialesService {
	
	@Autowired
	TestimonialesDAO testimonialesDAO;

	@Override
	public List<TestimonialesDTO> todas() {
		System.out.println("entra a testimoniales service");
		List<TestimonialesDTO> testimoniales=testimonialesDAO.todas();
		
		return testimoniales;
	}

	@Override
	public List<TestimonialesDTO> findByNegocio(String tipo_negocio) {
		List<TestimonialesDTO> testimonialesNegocio=testimonialesDAO.findByNegocio(tipo_negocio);
		return testimonialesNegocio;
	}

}
