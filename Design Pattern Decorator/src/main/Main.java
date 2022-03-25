package main;

import javax.swing.JOptionPane;

import abstracts.Pao;
import adicionais.Frango;
import adicionais.Maionese;
import adicionais.Presunto;
import adicionais.Queijo;
import adicionais.Salada;
import paos.Parmesao;
import paos.TresQueijos;

public class Main {

	public static void main(String[] args) {

		String tiposPao = "(1) -> Parmesao\n(2) -> Três Queijos";

		int paoSelecionado = Integer.parseInt(JOptionPane.showInputDialog(tiposPao));

		Pao pao;

		switch (paoSelecionado) {
		case 1 -> pao = new Parmesao();

		case 2 -> pao = new TresQueijos();

		default -> throw new IllegalArgumentException("Unexpected value: " + paoSelecionado);
		
		}

		boolean sair = false;

		String adicionais = "(1) -> Frango\n";
		adicionais += "(2) -> Maionese\n";
		adicionais += "(3) -> Presunto\n";
		adicionais += "(4) -> Queijo\n";
		adicionais += "(5) -> Salada\n";
		adicionais += "(6) -> Finalizar pedido\n";

		while (!sair) {

			int quantidade = 0;

			int adicionalSelecionado = Integer.parseInt(JOptionPane.showInputDialog(adicionais));

			if (adicionalSelecionado < 6) {
				quantidade = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade"));
			}

			switch (adicionalSelecionado) {
			case 1 -> pao = new Frango(pao, quantidade);
			case 2 -> pao = new Maionese(pao, quantidade);
			case 3 -> pao = new Presunto(pao, quantidade);
			case 4 -> pao = new Queijo(pao, quantidade);
			case 5 -> pao = new Salada(pao, quantidade);
			case 6 -> sair = true;

			default -> throw new IllegalArgumentException("Unexpected value: " + adicionalSelecionado);
			}

		}

		JOptionPane.showMessageDialog(null, pao.getDescricao() + " | R$" + pao.getTotalPrice());

		// -------------------------------------------------------------------------------
		
		Pao tresQueijos = new TresQueijos();
		System.out.println(tresQueijos.getDescricao() + "| R$" + tresQueijos.getTotalPrice());

		Pao frango = new Frango(tresQueijos, 2);

		System.out.println(frango.getDescricao() + "| R$" + frango.getTotalPrice());

		Pao mistoQuente = new Queijo(new Maionese(new Presunto(tresQueijos, 2), 1), 3);

		System.out.println("-------------------------------");
		System.out.println();
		System.out.printf("Misto quente -> %s | R$%.2f%n", mistoQuente.getDescricao(), mistoQuente.getTotalPrice());

	}
}
