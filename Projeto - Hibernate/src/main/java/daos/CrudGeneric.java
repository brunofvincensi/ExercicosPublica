package daos;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudGeneric <T, I>{

List<T> findAll() throws SQLException;
	
	void save(T obj) throws SQLException;
	
	void update(T obj, I id) throws SQLException;
	
	void delete(I id) throws SQLException;
	
	Optional<T> findById(I id) throws SQLException;
}
