package services;

import java.util.List;
import java.util.Optional;

public interface CrudGenericService <T> {

	/**
	 * @return a lista do tipo especificado
	 */
	 List<T> findAll();
	
	 /**
	  * @param um objeto para ser adicionado na lista
	  */
	 void save(T object);
	
	 /**
	  * @param variavel que serve para procurar o objeto a ser excluido
	  */
	 void delete(String var);
	
	 /**
	  * @param variavel que serve para procurar o objeto a ser alterado
	  * @param novo objeto
	  */
	 void update(String var, T object);
	 
	 /**
	  * @param variavel para encontrar o objeto
	  * @return o objeto 
	  */
	 Optional<T> findBy(String var);
}
