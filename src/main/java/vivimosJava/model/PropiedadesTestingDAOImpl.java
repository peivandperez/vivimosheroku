package vivimosJava.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	private String sqlFindByDireccion= "SELECT * FROM propiedades_testing WHERE id= :direccion";
	private String sqlFindByUrl= "SELECT * FROM propiedades_testing WHERE url= :url";

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


	@Override
	public PropiedadesTestingDTO findByDireccion(String direccion) {
		PropiedadesTestingDTO propiedadesTestingDTO = new PropiedadesTestingDTO();
		MapSqlParameterSource params =new MapSqlParameterSource();
		params.addValue("direccion", direccion);
		
		try {
			
			propiedadesTestingDTO=namedParam.queryForObject(sqlFindByDireccion, params, BeanPropertyRowMapper.newInstance(PropiedadesTestingDTO.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propiedadesTestingDTO;
	}
	
	@Override
	public PropiedadesTestingDTO findByUrl(String url) {
		PropiedadesTestingDTO propiedadesTestingDTO = new PropiedadesTestingDTO();
		MapSqlParameterSource params =new MapSqlParameterSource();
		params.addValue("url", url);
			
		try {
			propiedadesTestingDTO=namedParam.queryForObject(sqlFindByUrl, params, BeanPropertyRowMapper.newInstance(PropiedadesTestingDTO.class));
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
		return propiedadesTestingDTO;
	}

		
	
	}


