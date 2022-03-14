package Ex04;

public class Pergunta {

	private String perguta;
	
	private String alt1;
	private String alt2;
	private String alt3;
	private String alt4;
	
	//private String[] pergutas;
	
	private String altCerta;
	
	private String dica;

	
	
	public Pergunta() {
		super();
	}

	public Pergunta(String perguta, String alt1, String alt2, String alt3, String alt4, String altCerta, String dica) {
		super();
		this.perguta = perguta;
		this.alt1 = alt1;
		this.alt2 = alt2;
		this.alt3 = alt3;
		this.alt4 = alt4;
		this.altCerta = altCerta;
		this.dica = dica;
	}

	public String getPerguta() {
		return perguta;
	}

	public void setPerguta(String perguta) {
		this.perguta = perguta;
	}

	public String getAlt1() {
		return alt1;
	}

	public void setAlt1(String alt1) {
		this.alt1 = alt1;
	}

	public String getAlt2() {
		return alt2;
	}

	public void setAlt2(String alt2) {
		this.alt2 = alt2;
	}

	public String getAlt3() {
		return alt3;
	}

	public void setAlt3(String alt3) {
		this.alt3 = alt3;
	}

	public String getAlt4() {
		return alt4;
	}

	public void setAlt4(String alt4) {
		this.alt4 = alt4;
	}

	public String getAltCerta() {
		return altCerta;
	}

	public void setAltCerta(String altCerta) {
		this.altCerta = altCerta;
	}

	public String getDica() {
		return dica;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}
	
	
}
