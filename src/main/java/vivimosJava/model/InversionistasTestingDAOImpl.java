package vivimosJava.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InversionistasTestingDAOImpl implements InversionistasTestingDAO {

	private String listaInversionistasReducido="SELECT * FROM lista_reducida";
	private String listaInversionistas="SELECT * FROM lista_completa";
	
	@Autowired
	NamedParameterJdbcTemplate namedParam;
	
	@Override
	public List<InversionistasTestingDTO> listaInversionistasTesting() {
		List<InversionistasTestingDTO> listaInversionistasTesting=namedParam.query(listaInversionistas, BeanPropertyRowMapper.newInstance(InversionistasTestingDTO.class));
	
		return listaInversionistasTesting;
	}

}
