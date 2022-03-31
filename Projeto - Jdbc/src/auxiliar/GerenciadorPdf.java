package auxiliar;

public class GerenciadorPdf {
	
	public final static String DOMINIO = "C:\\Users\\publica\\Desktop";	
	private static int numero = 0; 

	public static int getNumero() {
		numero++;
		return numero;		
	}
	
	public static String gerarCodigoBoleto() {

		String codigo = "";
		for (int i = 0; i < 48; i++) {
			codigo += (int) Math.floor((Math.random() * 10));
		}

		return codigo;
	}
}
