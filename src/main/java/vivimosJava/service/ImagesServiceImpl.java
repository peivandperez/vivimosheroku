package vivimosJava.service;

import org.springframework.beans.factory.annotation.Autowired;

import vivimosJava.model.ImagesDAO;
import vivimosJava.model.ImagesDTO;

public class ImagesServiceImpl implements ImagesService {
	
	@Autowired
	ImagesDAO imagesDAO;

	@Override
	public int insert(ImagesDTO imagesDTO) {
		return imagesDAO.insert(imagesDTO);
	}

}
