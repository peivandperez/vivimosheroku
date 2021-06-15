package vivimosJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivimosJava.model.PropiedadesTestingDAO;
import vivimosJava.model.PropiedadesTestingDTO;

@Service
public class PropiedadesTestingServiceImpl implements PropiedadesTestingService {
	@Autowired
	PropiedadesTestingDAO propiedadesTestingDAO;
	
	@Override
	public List<PropiedadesTestingDTO> listTodas() {
		List<PropiedadesTestingDTO> listaPropiedadesTesting=propiedadesTestingDAO.todas();
		return listaPropiedadesTesting;
		
	}

	@Override
	public PropiedadesTestingDTO findById(int id) {
		PropiedadesTestingDTO findById=propiedadesTestingDAO.findById(id);
		return findById;
	}

	@Override
	public PropiedadesTestingDTO findByDireccion(String direccion) {
		PropiedadesTestingDTO findByDireccion=propiedadesTestingDAO.findByDireccion(direccion);
		return findByDireccion;
	}

}
