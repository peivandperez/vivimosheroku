package vivimosJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivimosJava.model.ImagesDAO;
import vivimosJava.model.ImagesDTO;

@Service
public class ImagesServiceImpl implements ImagesService {
	
	@Autowired
	ImagesDAO imagesDAO;

	@Override
	public int insert(ImagesDTO imagesDTO) {
		return imagesDAO.insert(imagesDTO);
	}

}
