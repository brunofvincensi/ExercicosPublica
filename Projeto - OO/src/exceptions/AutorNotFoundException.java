package exceptions;

public class AutorNotFoundException extends RuntimeException{
	
	public AutorNotFoundException() {
		super("Autor não encontrado");
	}
	

}
