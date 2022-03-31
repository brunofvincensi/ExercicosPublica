package daos;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidade.Aluno;

public class AlunoDAO implements CrudGeneric<Aluno, Integer>{


public List<Aluno> findAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public void save(Aluno aluno) throws SQLException {
	  	  
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence_escola");
	 
	  EntityManager em = emf.createEntityManager();
	  
	  
	  em.getTransaction().begin();
	  em.persist(aluno);
	  em.getTransaction().commit();
	  
	  
	  
	  emf.close();
	  em.close();
	
}

public void update(Aluno obj, Integer id) throws SQLException {
	// TODO Auto-generated method stub
	
}

public void delete(Integer id) throws SQLException {
	// TODO Auto-generated method stub
	
}

public Optional<Aluno> findById(Integer id) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
	
	
	
	
}
