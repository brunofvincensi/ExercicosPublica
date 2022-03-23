package valores;

import java.util.HashMap;
import java.util.Map;

public class Feriados {

	public final static Map<Integer, int[]> feriados = new HashMap<>();

	static {

		int[] mes1 = { 1 };
		int[] mes2 = { 20, 21 };
		int[] mes3 = {};
		int[] mes4 = { 15, 21 };
		int[] mes5 = { 1 };
		int[] mes6 = {};
		int[] mes7 = { 16 };
		int[] mes8 = { 1 };
		int[] mes9 = { 7 };
		int[] mes10 = { 12 };
		int[] mes11 = { 15 };
		int[] mes12 = { 25 };

		feriados.put(1, mes1);
		feriados.put(2, mes2);
		feriados.put(3, mes3);
		feriados.put(4, mes4);
		feriados.put(5, mes5);
		feriados.put(6, mes6);
		feriados.put(7, mes7);
		feriados.put(8, mes8);
		feriados.put(9, mes9);
		feriados.put(10, mes10);
		feriados.put(11, mes11);
		feriados.put(12, mes12);

	}
}
