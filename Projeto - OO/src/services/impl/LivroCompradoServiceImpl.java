package services.impl;

import java.util.ArrayList;
import java.util.List;

import models.LivroComprado;

public class LivroCompradoServiceImpl {
	
	private static List<LivroComprado> livrosComprados = new ArrayList<>();
	
	
	public void save(LivroComprado lc) {
		livrosComprados.add(lc);
	}
	
	public List<LivroComprado> findAll(){
		return livrosComprados;
	}
	

}
