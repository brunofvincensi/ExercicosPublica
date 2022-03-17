package services;

import java.util.List;
import java.util.Optional;

public interface CrudGenericService <T> {

	 List<T> findAll();
	
	 void save(T object);
	
	 void delete(String var);
	
	 void update(String var, T object);
	 
	 Optional<T> findBy(String var);
}
