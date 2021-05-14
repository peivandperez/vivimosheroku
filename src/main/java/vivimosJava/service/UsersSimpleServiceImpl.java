package vivimosJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivimosJava.model.UsersSimpleDAO;
import vivimosJava.model.UsersSimpleDTO;

@Service
public class UsersSimpleServiceImpl implements UsersSimpleService {
	@Autowired
	UsersSimpleDAO usersSimpleDAO;

	
	@Override
	public int insert(UsersSimpleDTO usersSimpleDTO) {
		return usersSimpleDAO.insert(usersSimpleDTO);
	}

}
