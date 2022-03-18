package models;

import enums.Estado;

public class Autor extends Pessoa{
	
	public Autor() {
		super();
	}

	public Autor(String nome, int idade, String email, Estado estado) {
		super(nome, email, idade, estado);		
	}


	@Override
	public String toString() {
		return "Autor [" + super.toString() + "]";
	}


}
