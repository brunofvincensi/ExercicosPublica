package util;

import java.time.DayOfWeek;
import java.time.LocalDate;

import valores.Feriados;

//Classe para auxiliar nos calculos
public class Calculo {

	static int diasRentaveis = 0;

	/**
	 * Calcula o o dia que finalizara o investimento, levando em com feriado e final de semana
	 * @param aporte
	 * @param duracao
	 * @return
	 */
	public static LocalDate calcularRetirada(LocalDate aporte, int duracao) {

		LocalDate retirada = aporte.plusMonths(duracao);
		
		
		DayOfWeek diaSemana = retirada.getDayOfWeek();		
		int mes = retirada.getMonthValue();
		int dia =  retirada.getDayOfMonth();		
		int[] feriados = Feriados.feriados.get(mes);
		
		for(int i = 0; i < feriados.length; i++) {
			
			if( dia == feriados[i] ) {
				retirada = retirada.plusDays(1);
				break;
			}
		}
		
		if (diaSemana == DayOfWeek.SATURDAY) {
			retirada = retirada.plusDays(2);
		} 
		else {
			if (diaSemana == DayOfWeek.SUNDAY) {
				retirada = retirada.plusDays(1);
			}
		}

		return retirada;
	}

	/**
	 * calcula o valor com juros compostos
	 * @param valorAporte
	 * @param taxa
	 * @param duracao
	 * @return
	 */
	public static double calcularValorComJuros(double valorAporte, double taxa, int duracao) {

		return valorAporte * Math.pow((1 + (taxa / 100)), duracao);
	}

	/**
	 * calcula o valor do imposto do cdb
	 * @param valor
	 * @param duracao
	 * @return
	 */
	public static double calcularImpostoCdb(double valor, double duracao) {

		if (duracao <= 6) {
			return 0.225;
		} else if (duracao <= 12) {
			return 0.20;
		} else {
			return 0.175;
		}

	}

}
