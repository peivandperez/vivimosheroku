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

}
