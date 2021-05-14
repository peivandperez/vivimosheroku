package vivimosJava.model;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UsersSimpleDAOImpl implements UsersSimpleDAO {
	
	public String insertUsers="INSERT INTO users (email)"
	+"VALUES (:email) ON DUPLICATE KEY UPDATE idusers=idusers";
	
	
	@Autowired
	NamedParameterJdbcTemplate namedParam;
	
	@Override
	public int insert(UsersSimpleDTO usersSimpleDTO) {
		int rows=0;
	
		
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("email", usersSimpleDTO.getEmail());
		
		try {
			rows=namedParam.update(insertUsers, params);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return rows;
		
	}

	

}
