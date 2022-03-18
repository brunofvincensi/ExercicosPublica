package services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import models.LivroComprado;
import services.CrudGenericService;

public class LivroCompradoServiceImpl implements CrudGenericService<LivroComprado>{
	
	private static List<LivroComprado> livrosComprados = new ArrayList<>();
	
	@Override
	public void save(LivroComprado lc) {
		livrosComprados.add(lc);
	}
	
	@Override
	public List<LivroComprado> findAll(){
		return livrosComprados;
	}

	@Override
	public void delete(String index) {
		
	}

	@Override
	public void update(String index, LivroComprado lc) {
		
	}

	@Override
	public Optional<LivroComprado> findBy(String index) {
		
		return null;
	}
	
}
