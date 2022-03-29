package controller.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudGeneric <T, I>{
	
	List<T> findAll() throws SQLException;
	
	void save();
	
	void update(T obj, I id);
	
	void delete(I id);
	
	Optional<T> findById(I id) throws SQLException;

}
