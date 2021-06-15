package vivimosJava.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PropiedadesTestingDAOImpl implements PropiedadesTestingDAO {
	
	private String sqlTodas="SELECT * FROM propiedades_testing";
	private String sqlFindById="SELECT * FROM propiedades_testing WHERE id= :id";

	@Autowired
	NamedParameterJdbcTemplate namedParam;
	
	
	@Override
	public List<PropiedadesTestingDTO> todas() {
		
		List<PropiedadesTestingDTO> listaPropiedadesTesting=namedParam.query(sqlTodas, BeanPropertyRowMapper.newInstance(PropiedadesTestingDTO.class));
		return listaPropiedadesTesting;
	
	}


	@Override
	public PropiedadesTestingDTO findById(int id) {
		PropiedadesTestingDTO propiedadesTestingDTO = new PropiedadesTestingDTO();
		MapSqlParameterSource params =new MapSqlParameterSource();
		params.addValue("id", id);
		
		try {
			propiedadesTestingDTO=namedParam.queryForObject(sqlFindById, params, BeanPropertyRowMapper.newInstance(PropiedadesTestingDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propiedadesTestingDTO;
	}

}
