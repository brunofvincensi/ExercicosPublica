package models;


public class Autor extends Pessoa{
	
	public Autor() {
		super();
	}

	public Autor(String nome, int idade, String email) {
		super(nome, email, idade );		
	}


	@Override
	public String toString() {
		return "Autor [" + super.toString() + "]";
	}


}
