package models;

import enums.TipoInvestimento;

public class Investimento {

	private TipoInvestimento tipo;

	private double jurosBruto;

	private double valorImposto;

	private double valorTotal;

	private double jurosLiquido;

	public Investimento() {

	}

	public Investimento(TipoInvestimento tipo, double jurosBruto, double valorImposto, double valorAporte) {
		this.tipo = tipo;
		this.jurosBruto = jurosBruto;
		this.valorImposto = valorImposto;
		this.jurosLiquido = jurosLiquido(jurosBruto, valorImposto);
		this.valorTotal = valorTotal(valorAporte, jurosLiquido);
	}

	private double jurosLiquido(double jurosBruto, double valorImposto) {
		return jurosBruto - (jurosBruto * valorImposto);
	}

	private double valorTotal(double valorAporte, double jurosLiquido) {

		return valorAporte + jurosLiquido;

	}

	public TipoInvestimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoInvestimento tipo) {
		this.tipo = tipo;
	}

	public double getJurosBruto() {
		return jurosBruto;
	}

	public void setJurosBruto(double jurosBruto) {
		this.jurosBruto = jurosBruto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getJurosLiquido() {
		return jurosLiquido;
	}

	public void setJurosLiquido(double jurosLiquido) {
		this.jurosLiquido = jurosLiquido;
	}

	public double getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}

}
