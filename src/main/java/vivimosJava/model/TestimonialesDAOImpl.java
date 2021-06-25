package vivimosJava.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TestimonialesDAOImpl implements TestimonialesDAO {
	
	private String sqlTodas="SELECT * FROM testimoniales";
	private String sqlNegocio="SELECT * FROM testimoniales WHERE tipo_negocio= :tipo_negocio";
	
	@Autowired
	NamedParameterJdbcTemplate namedParam;

	@Override
	public List<TestimonialesDTO> todas() {
		List<TestimonialesDTO> testimoniales=new ArrayList<TestimonialesDTO>();
		try {
			testimoniales=namedParam.query(sqlTodas, BeanPropertyRowMapper.newInstance(TestimonialesDTO.class));
			System.out.println("hace query en sql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testimoniales;
	}

	@Override
	public List<TestimonialesDTO> findByNegocio(String tipo_negocio) {
		List<TestimonialesDTO> testimonialesNegocio=new ArrayList<TestimonialesDTO>();
		MapSqlParameterSource params =new MapSqlParameterSource();
		params.addValue("tipo_negocio", tipo_negocio);
		
		try {
			testimonialesNegocio=namedParam.query(sqlNegocio, params, BeanPropertyRowMapper.newInstance(TestimonialesDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
		
		return testimonialesNegocio;
	}

}
