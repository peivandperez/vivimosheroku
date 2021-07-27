package vivimosJava.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ImagesDAOImpl implements ImagesDAO {
	
	public String insertImage="INSERT INTO images (name,idpropiedad,filepath)"
			+ "VALUES (:name ,:idPropiedad,filePath)";
		

	@Autowired
	NamedParameterJdbcTemplate namedParam;
	
	@Override
	public int insert(ImagesDTO imagesDTO) {
		int rows=0;
		
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("name", imagesDTO.getId());
		params.addValue("idPropiedad", imagesDTO.getIdpropiedad());
		params.addValue("filePath", imagesDTO.getFilepath());
		
		try {
			rows=namedParam.update(insertImage, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

}
